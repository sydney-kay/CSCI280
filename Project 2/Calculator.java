// CS-280 Sp24
// Derek Shannon & Sydney Nilles
// Project 2
// 05/02/2024

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> display;
    private double result;

    public Calculator(){
        display = new ArrayList<String>();
        result = 0.0;
        initializeGUI();
    }

    public void initializeGUI(){
        JFrame frame = new JFrame();
        
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "+/-", "0", "."};
        String[] operators = {"+", "-", "*", "/"};
        int buttonSize = 50;

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
                    //color
                } else {
                    displayName = numbers[index];
                    //color
                }

                //create button at calculated position and name
                JButton button = new JButton(displayName);
                button.setBounds(20+(j*buttonSize), 20+(i*buttonSize), buttonSize, buttonSize);
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

        frame.setSize(400, 800); //size of the screen
        frame.setLayout(null);
        frame.setVisible(true); //makes the frame visible
    }

    public void buttonClick(ActionEvent e){
        System.out.println(e.getActionCommand());
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

    public void delete(){
        display.remove(display.size());
    }

    public void clearCalculator(){
        display.clear();
    }

    public void equal(){
        // compute results & display on screen
        // basically call all the other methods depending on what's in display
        
        // check if i is a number
        /* switch()
         * case "*": multiplication
         * case "/": division
         * case "+": addition
         * case "-": subtraction
         */
    }
}
