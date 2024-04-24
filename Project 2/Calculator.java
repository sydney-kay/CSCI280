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
    private JLabel displayLbl;

    public Calculator(){
        displaylist = new ArrayList<String>();
        initializeGUI();
    }

    private void initializeGUI(){
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
                clearCalculator(e); // method to be called
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
                delete(e); // method to be called
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
                equal(e); // method to be called
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
                if(findType(displaylist.getLast())=="decimal"){
                    displaylist.add("0");
                }
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

    public void delete(ActionEvent e){
        if(displaylist.size()!=0){
            displaylist.remove(displaylist.size()-1);
            if(findType(displaylist.getLast()).equals("+/-")){
                displaylist.remove(displaylist.size()-1);
            }
            updateDisplay();
        }
    }

    public void clearCalculator(ActionEvent e){
        displaylist.clear();
        updateDisplay();
    }

    private void executeOperation(String operator, int indexOperator){
        System.out.println("\ninput: "+displaylist);

        //gets num1
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

        //gets num2
        String rightNum = "";
        for(int i = indexOperator+1; i < displaylist.size(); i++){
            switch(findType(displaylist.get(i))){
                case "+/-":
                    rightNum = "-"+rightNum;
                    break;
                case "operator":
                    i = displaylist.size()+1;
                    break;
                default:
                    rightNum = rightNum + displaylist.get(i);
            }
        }
        System.out.println("rightNum = "+rightNum);

        //remove numbers and operators
        int inputIndex = 0; //location of where the result should go
        for(int i = 0; i < leftNum.length(); i++){
            inputIndex = indexOperator-1-i;
            displaylist.remove(inputIndex);
        }
        for(int i = 0; i < rightNum.length(); i++){
            displaylist.remove(inputIndex+1);
        }
        displaylist.remove(inputIndex);

        //convert to doubles
        double rightNum2 = Double.parseDouble(rightNum);
        double leftNum2 = Double.parseDouble(leftNum);

        //calculate result
        double resultNum = 0;
        switch(operator){
            case "*":
                resultNum = (leftNum2 * rightNum2);
                break;
            case "/":
                resultNum = (leftNum2 / rightNum2);
                break;
            case "+":
                resultNum = (leftNum2 + rightNum2);
                break;
            case "-":
                resultNum = (leftNum2 - rightNum2);
                break;
        }

        //removes unnessecary .0 at the end of a number
        String result = "";
        if((int)resultNum == resultNum){
            result = "" + (int) resultNum;
        }
        else{
            result = "" + resultNum;
        }
        System.out.println("Result: "+result);

        //adds result to the display
        for (int i = 0; i < result.length(); i++) {
            String toAdd = String.valueOf(result.charAt(result.length()-1-i));
            if(toAdd.equals("-")){
                displaylist.add(inputIndex, "+/-");
            }
            else{
                displaylist.add(inputIndex, toAdd);
            }
        }

        //checks for possible errors in the output
        if(displaylist.contains("E")){
            displayLbl.setText("Overflow!");
            displaylist.clear();
        }
        else if(displaylist.contains("I")){
            if(displaylist.getFirst().equals("+/-")){
                displayLbl.setText("Negative Infinity");
                displaylist.clear();
            }
            else{
                displayLbl.setText("Infinity");
                displaylist.clear();
            }
        }
        else if(displaylist.contains("N")){
            displayLbl.setText("Not a Number");
            displaylist.clear();
        }
        else{
            System.out.println(displaylist);
            System.out.println();
            updateDisplay();
        }
    }
    
    public void equal(ActionEvent e){
        //checks to see if there is an operator at the end
        if(displaylist.size()>0){
            if(findType(displaylist.getLast()).equals("operator")){
                displaylist.remove(displaylist.size()-1);
                updateDisplay();
            }
        }
        //starts calculation

        //do multiplication/division
        while(displaylist.contains("*") || displaylist.contains("/")){//needed to catch a shifting array
            for(int i = 0; i < displaylist.size(); i++){
                String value = displaylist.get(i);
                if(value.equals("*")){
                    executeOperation("*", i);
                    break; //stops for loop as the size of the array has changed
                }
                else if(value.equals("/")){
                    executeOperation("/", i);
                    break; //stops for loop as the size of the array has changed
                }
            }
        }

        //do addition/subtraction
        while(displaylist.contains("+") || displaylist.contains("-")){//needed to catch a shifting array
            for(int i = 0; i < displaylist.size(); i++){
                String value = displaylist.get(i);
                if(value.equals("+")){
                    executeOperation("+", i);
                    break; //stops for loop as the size of the array has changed
                }
                else if(value.equals("-")){
                    executeOperation("-", i);
                    break; //stops for loop as the size of the array has changed
                }
            }
        }
    }
}