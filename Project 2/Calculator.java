// CS-280 Sp24
// Derek Shannon & Sydney Nilles
// Project 2
// 05/02/2024

import java.io.*;
import javax.swing.*;
import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> display;
    private double result;

    public Calculator(){
        display = new ArrayList<String>();
        result = 0.0;
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
