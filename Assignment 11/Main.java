
// CS-280 Sp24
// Sydney Nilles
// Assignment 10 - due 04/22/2024

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        try {
            Scanner nelson = new Scanner(System.in);
            FileOutputStream outputFile = new FileOutputStream("output.txt");
            OutputStreamWriter outputWriter = new OutputStreamWriter(outputFile);

            // prompt user
            System.out.println("Please enter the text you would like in the file, press enter when you are done. ");
            String input = nelson.nextLine();

            // by rough estimation and online confirmation, strings are 2 bytes each, so a string of 25 length would be roughly 50 bytes
            if (input.length() > 25){
                outputWriter.write(input.substring(0,26));
            } else {
                outputWriter.write(input);
            }

            // close all the things that need to be closed
            nelson.close();
            outputWriter.close();
        } catch (IOException e) {
            System.out.println("IOException Error.");
        }
        
    }
}
