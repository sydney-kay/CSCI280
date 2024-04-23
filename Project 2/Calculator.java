// CS-280 Sp24
// Derek Shannon & Sydney Nilles
// Project 2
// 05/02/2024

import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> displaylist;
    private double result;
    private JLabel displayLbl;

    public Calculator(){
        displaylist = new ArrayList<String>();
        result = 0.0;
        initializeGUI();
    }

    public void initializeGUI(){
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(new Color(18, 18, 26));
        final int buttonSize = 80;
        final int btnStartLocationX = 20;
        final int btnStartLocationY = 105;
        final int WIDTH = 18+buttonSize*4+(btnStartLocationX*2); //changes size of window based on button size and margins
        final int HEIGHT = 600;

        // color for background of buttons
        Color bgColor = new Color(73, 72, 99);
        Color fgColor = new Color(233, 245, 245);

        //Main display
        displayLbl = new JLabel("0", JTextField.RIGHT);
        Border outline = BorderFactory.createLineBorder(new Color (146, 146, 179));
        Border margins = new EmptyBorder(20,20,20,20);
        displayLbl.setBorder(BorderFactory.createCompoundBorder(outline, margins));
        displayLbl.setBounds(btnStartLocationX,btnStartLocationX, buttonSize*4, buttonSize);
        displayLbl.setBackground(new Color(33, 33, 46));
        displayLbl.setForeground(fgColor);
        displayLbl.setOpaque(true);
        frame.add(displayLbl);

        //Clear, delete, and equal buttons
        JButton clearBtn = new JButton("C");
        clearBtn.setBounds(btnStartLocationX,btnStartLocationY,buttonSize, buttonSize);
        clearBtn.setBackground(bgColor);
        clearBtn.setForeground(fgColor);
        clearBtn.setBorder(outline);
        frame.add(clearBtn);
        clearBtn.addActionListener(new ActionListener() { //click event
            @Override
            public void actionPerformed(ActionEvent e) {
                clearCalculator(e);
            }
        });

        JButton deleteBtn = new JButton("DEL");
        deleteBtn.setBounds(btnStartLocationX+buttonSize,btnStartLocationY,buttonSize, buttonSize);
        deleteBtn.setBackground(bgColor);
        deleteBtn.setForeground(fgColor);
        deleteBtn.setBorder(outline);
        frame.add(deleteBtn);
        deleteBtn.addActionListener(new ActionListener() { //click event
            @Override
            public void actionPerformed(ActionEvent e) {
                delete(e);
            }
        });

        JButton equalBtn = new JButton("=");
        equalBtn.setBounds(btnStartLocationX+buttonSize*2,btnStartLocationY,buttonSize*2, buttonSize);
        equalBtn.setBackground(bgColor);
        equalBtn.setForeground(fgColor);
        equalBtn.setBorder(outline);
        frame.add(equalBtn);
        equalBtn.addActionListener(new ActionListener() { //click event
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call your method here
                equal(e);
            }
        });

        //number and operator buttons
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "+/-", "0", "."};
        String[] operators = {"+", "-", "*", "/"};

        for (int i = 0; i < 4; i++) { // Loop through rows
            for (int j = 0; j < 4; j++) {// Loop through columns
                int index = i * 3 + j; // Calculate the index in the numbers array
                String displayName = "";

                if (j == 3) { // If it's the last column
                    displayName = operators[i];
                    bgColor = new Color(73, 72, 99);
                } else {
                    displayName = numbers[index];
                    bgColor = new Color(33, 33, 46);
                }
                
                //create button at calculated position and name
                JButton button = new JButton(displayName);
                button.setBounds(btnStartLocationX+(j*buttonSize), buttonSize+btnStartLocationY+(i*buttonSize), buttonSize, buttonSize);
                button.setBackground(bgColor);
                button.setForeground(fgColor);
                button.setBorder(outline);

                frame.add(button);
                // Add ActionListener to the button
                button.addActionListener(new ActionListener() {//click event 
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buttonClick(e);
                    }
                });
            }
        }

        frame.setSize(WIDTH, HEIGHT); //size of the screen
        frame.setLayout(null);
        frame.setVisible(true); //makes the frame visible
    }
    public void updateDisplay(){
        String text = "";
        for(String l: displaylist){
            if(l.equals("+/-")){
                l="-";
            }
            text += l;
        }
        if(text==""){
            text = "0";
        }
        displayLbl.setText(text);
    }

    private String findType(String value){
        //checks if number
        try{
            Integer.parseInt(value);
            return "number";
        }
        catch(Exception e){}

        //checks if operator
        if("*+-/".contains(value)){
            return "operator";
        }
        //checks if decimal
        if(".".contains(value)){
            return "decimal";
        }
        //checks if +/-
        if("+/-".contains(value)){
            return "+/-";
        }
        return "Error";
    }

    public void buttonClick(ActionEvent e){
        String type = findType(e.getActionCommand());
        //checks to see if type is number
        if(type == "number"){
            displaylist.add(e.getActionCommand());
        }
        //if there is nothing in display then auto add 0
        else if(displaylist.size() == 0 && type != "+/-"){
            displaylist.add("0");
            displaylist.add(e.getActionCommand());
        }
        //if there is already an operator then replace it
        else if(type=="operator"){
            if(findType(displaylist.getLast())=="operator"){
                displaylist.set(displaylist.size()-1, e.getActionCommand());
            }
            else{
                displaylist.add(e.getActionCommand());
            }
        }
        else if(type=="decimal"){
            for(int i = displaylist.size()-1; i>=0; i--){ //reverse loops through displaylist
                switch(findType(displaylist.get(i))){
                    case "number": 
                        break;
                    case "operator": 
                        if(displaylist.size()-1 == i){ //adds 0 if there is no number before decimal
                            displaylist.add("0");
                        }
                        displaylist.add(e.getActionCommand());
                        i = -1;
                        break;
                    case "decimal":
                        i=-1;
                        break;
                    case "+/-":
                        break;
                    default:
                        System.out.println("Error!");
                        break;
                }
                if(i == 0){
                    displaylist.add(e.getActionCommand());
                }
            }
        }
        else if(type=="+/-"){
            //donesn't add +/- if there isn't a number
            if(displaylist.size()>0){
                if(!findType(displaylist.getLast()).equals("number")){
                    return;
                }
            }
            //attempts to add or remove +/-
            for(int i = displaylist.size()-1; i>=0; i--){ //reverse loops through displaylist
                switch(findType(displaylist.get(i))){
                    case "number":
                    case "decimal":
                        break;
                    case "+/-":
                        displaylist.remove(i);
                        i = -1;
                        break;
                    case "operator":
                        displaylist.add(i+1, "+/-");
                        i = -1;
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }
                if(i==0){
                    displaylist.add(0, "+/-");
                }
            }
        }
        updateDisplay();
    }

    public void operation(String op){
        // setting default indexes in the event there are no operators before the op variable
        int indexOfFirstOp = -1;
        int indexOfNextOp = displaylist.size();
        // setting default numbers before displaylist information is applied
        double num1 = 1;
        double num2 = 1;
        String result = "";
        String compiledNum = "";

        // Searching for any operators before op
        for (int i = 0; i <  displaylist.indexOf(op); i++){
            if (findType(displaylist.get(i)) == "operator"){
                indexOfFirstOp = i;
            }
        }
        // Searching for any operators after op
        for (int i = displaylist.size() -1; i >  displaylist.indexOf(op); i--){
            if (findType(displaylist.get(i)) == "operator"){
                indexOfNextOp = i;
            }
        }
        
        // Checking for negative numbers & compiling the list numbers together
        if (findType(displaylist.get(indexOfFirstOp + 1)) == "+/-" ){
            num1 = num1*-1;
            for (int i = indexOfFirstOp + 2; i <  displaylist.indexOf(op); i+=0){
                compiledNum = compiledNum + displaylist.remove(i);
                indexOfNextOp--;
            }
            num1 = num1 * Double.parseDouble(compiledNum);
        } else {
            for (int i = indexOfFirstOp + 1; i <  displaylist.indexOf(op); i+=0){
                compiledNum = compiledNum + displaylist.remove(i);
                indexOfNextOp--;
            }
            num1 = num1 * Double.parseDouble(compiledNum);
        }
        System.out.println(compiledNum);
        compiledNum = ""; // reset the compiled number so another variable doesn't need to be made
        // doing the same thing as num1 to num2
        if (findType(displaylist.get(displaylist.indexOf(op) + 1)) == "+/-" ){
            num2 = num2*-1;
            for (int i = displaylist.indexOf(op) + 2; i < indexOfNextOp; i++){
                compiledNum = compiledNum + displaylist.remove(i);
            }
            num2 = num2 * Double.parseDouble(compiledNum);
        } else {
            for (int i = displaylist.indexOf(op) + 1; i < indexOfNextOp; i++){
                compiledNum = compiledNum + displaylist.remove(i);
            }
            num2 = num2 * Double.parseDouble(compiledNum);
        }
        System.out.println(compiledNum);
        
        switch(op){
            case "*":
                result = "" + (num1*num2);
                break;
            case "/":
                result = "" + (num1/num2);
                break;
            case "+":
                result = "" + (num1 + num2);
                break;
            case "-":
                result = "" + (num1 - num2);
                break;
        }
        System.out.println(result);
        for (int i = result.length()-1; i > -1; i--){
            displaylist.add(displaylist.indexOf(op)+1, result.substring(i,i+1));
        }
        displaylist.remove(op);
        
    }

    public void delete(ActionEvent e){
        if(displaylist.size()!=0){
            displaylist.remove(displaylist.size()-1);
            updateDisplay();
        }
    }

    public void clearCalculator(ActionEvent e){
        displaylist.clear();
        updateDisplay();
    }

    public void operation2(){
        //do multiplication/division
        for(int i =0; i < displaylist.size(); i++){
            String value = displaylist.get(i);
            if(value.equals("*")){
                operation("*");
            }
            else if(value.equals("/")){
                operation("/");
            }
        }
        //do addition/subtraction
        for(int i =0; i < displaylist.size(); i++){
            String value = displaylist.get(i);
            if(value.equals("+")){
                operation("+");
            }
            else if(value.equals("-")){
                operation("-");
            }
        }
    }

    public void operation4(){
        //do multiplication/division
        for(int i =0; i < displaylist.size(); i++){
            String value = displaylist.get(i);
            if(value.equals("*")){
                operation3("*", i);
            }
            else if(value.equals("/")){
                operation3("/", i);
            }
        }
        //do addition/subtraction
        for(int i =0; i < displaylist.size(); i++){
            String value = displaylist.get(i);
            if(value.equals("+")){
                operation3("+", i);
            }
            else if(value.equals("-")){
                operation3("-", i);
            }
        }
    }
    public void operation3(String operator, int indexOperator){
        //num1
        String leftNum = "";
        for(int i = indexOperator-1; i >= 0; i--){
            switch(findType(displaylist.get(i))){
                case "+/-":
                    leftNum = "-"+leftNum;
                case "operator":
                    i = -1;
                    break;
                default:
                    leftNum = displaylist.get(i) + leftNum;
            }
        }
        System.out.println("leftNum = "+leftNum);

    }
    
    public void equal(ActionEvent e){
        // compute results & display on screen
        // basically call all the other methods depending on what's in displaylist
        
        // check if i is a number
        /* switch()
         * case "*": multiplication
         * case "/": division
         * case "+": addition
         * case "-": subtraction
         */
        operation2();
    }
}
