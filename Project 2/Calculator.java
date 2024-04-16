// CS-280 Sp24
// Derek Shannon & Sydney Nilles
// Project 2
// 05/02/2024

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> displaylist;
    private double result;

    public Calculator(){
        displaylist = new ArrayList<String>();
        result = 0.0;
        initializeGUI();
    }

    public void initializeGUI(){
        JFrame frame = new JFrame();
        final int buttonSize = 80;
        final int btnStartLocationX = 20;
        final int btnStartLocationY = 100;
        final int WIDTH = 18+buttonSize*4+(btnStartLocationX*2); //changes size of window based on button size and margins
        final int HEIGHT = 600;

        // color for background of buttons
        Color bgColor = new Color(82, 82, 99);
        Color fgColor = new Color(233, 245, 245);

        //Clear, delete, and equal buttons
        JButton clearBtn = new JButton("C");
        clearBtn.setBounds(btnStartLocationX,btnStartLocationY,buttonSize, buttonSize);
        clearBtn.setBackground(bgColor);
        clearBtn.setForeground(fgColor);
        frame.add(clearBtn);
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call your method here
                clearCalculator(e);
            }
        });

        JButton deleteBtn = new JButton("DEL");
        deleteBtn.setBounds(btnStartLocationX+buttonSize,btnStartLocationY,buttonSize, buttonSize);
        deleteBtn.setBackground(bgColor);
        deleteBtn.setForeground(fgColor);
        frame.add(deleteBtn);
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call your method here
                delete(e);
            }
        });

        JButton equalBtn = new JButton("=");
        equalBtn.setBounds(btnStartLocationX+buttonSize*2,btnStartLocationY,buttonSize*2, buttonSize);
        equalBtn.setBackground(bgColor);
        equalBtn.setForeground(fgColor);
        frame.add(equalBtn);
        equalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call your method here
                equal(e);
            }
        });

        //number and operator buttons
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "+/-", "0", "."};
        String[] operators = {"+", "-", "*", "/"};

        // Loop through rows
        for (int i = 0; i < 4; i++) {
            // Loop through columns
            for (int j = 0; j < 4; j++) {
                // Calculate the index in the numbers array
                int index = i * 3 + j;
                // If it's the last column, print the operator, else print the number
                String displayName = "";
                if (j == 3) {
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
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Call your method here
                        buttonClick(e);
                    }
                });
            }
        }

        frame.setSize(WIDTH, HEIGHT); //size of the screen
        frame.setLayout(null);
        frame.setVisible(true); //makes the frame visible
    }

    public void buttonClick(ActionEvent e){
        displaylist.add(e.getActionCommand());
        for(String l: displaylist){
            System.out.print(l);
        }
        System.out.println();
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
        displaylist.remove(displaylist.size()-1);
        for(String l: displaylist){
            System.out.print(l);
        }
        System.out.println();
    }

    public void clearCalculator(ActionEvent e){
        displaylist.clear();
        for(String l: displaylist){
            System.out.print(l);
        }
        System.out.println();
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
