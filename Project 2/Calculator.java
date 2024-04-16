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
        final int buttonSize = 80;
        final int btnStartLocationX = 20;
        final int btnStartLocationY = 105;
        final int WIDTH = 18+buttonSize*4+(btnStartLocationX*2); //changes size of window based on button size and margins
        final int HEIGHT = 600;

        // color for background of buttons
        Color bgColor = new Color(82, 82, 99);
        Color fgColor = new Color(233, 245, 245);

        //Main display
        displayLbl = new JLabel("0", JTextField.RIGHT);
        Border outline = BorderFactory.createLineBorder(new Color (40, 40, 51));
        Border margins = new EmptyBorder(20,20,20,20);
        displayLbl.setBorder(BorderFactory.createCompoundBorder(outline, margins));
        displayLbl.setBounds(btnStartLocationX,btnStartLocationX, buttonSize*4, buttonSize);
        displayLbl.setBackground(new Color(40, 40, 51));
        displayLbl.setForeground(fgColor);
        displayLbl.setOpaque(true);
        frame.add(displayLbl);

        //Clear, delete, and equal buttons
        JButton clearBtn = new JButton("C");
        clearBtn.setBounds(btnStartLocationX,btnStartLocationY,buttonSize, buttonSize);
        clearBtn.setBackground(bgColor);
        clearBtn.setForeground(fgColor);
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
                    bgColor = new Color(82, 82, 99);
                } else {
                    displayName = numbers[index];
                    bgColor = new Color(40, 40, 51);
                }
                
                //create button at calculated position and name
                JButton button = new JButton(displayName);
                button.setBounds(btnStartLocationX+(j*buttonSize), buttonSize+btnStartLocationY+(i*buttonSize), buttonSize, buttonSize);
                button.setBackground(bgColor);
                button.setForeground(fgColor);

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
            text += l;
        }
        if(text==""){
            text = "0";
        }
        displayLbl.setText(text);
    }

    private String findType(String value){
        try{
            Integer.parseInt(value);
            return "number";
        }
        catch(Exception e){
            return "not Number";
        }
    }

    public void buttonClick(ActionEvent e){
        String type = findType(e.getActionCommand());
        //checks to see if type is number when display is empty
        if(type == "number" || displaylist.size() != 0){
            displaylist.add(e.getActionCommand());
        }
        else{
            displaylist.add("0");
            displaylist.add(e.getActionCommand());

        }
        updateDisplay();
    }

    public void addition(){
        // Add all numbers next to a '+' sign
    }

    public void subtraction(){
        //substract all numbers next to a '-' sign
    }

    public void multiply(){
        // multiply all numbers next to a '*'
    }

    public void divide(){
        // divide all numbers next to a '/'
    }

    public void negative(){
        // take input and *-1
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
    }
}
