// CS-280 Sp24
// Sydney Nilles
// Assignment 12 - due 04/25/2024

import java.io.FileReader; 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Main{
    public static void main(String[]args){
        try {
            // Setting up the readers and writer and where they'll get input from
            FileReader inpReader = new FileReader("input.txt");
            BufferedReader bFileReader = new BufferedReader(inpReader);
            BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter outputWriter = new PrintWriter("output.txt");

            // Collecting the information from input.txt and storing it.
            String tempString = "";
            String inputStorage = "";
            while ((tempString = bFileReader.readLine())!= null){ // in the event of multiple lines in input.txt
                inputStorage = inputStorage + tempString + "\n";
            }

            // Taking input string from keyboard section
            System.out.println("Please write what you would like printed:");
            tempString = keyReader.readLine(); // may as well reuse that variable
            System.out.println(tempString);

            // reading the string and printing line by line
            StringReader inputReader = new StringReader(inputStorage);
            int tempChar = 0;
            while ((tempChar = inputReader.read()) != -1){
                System.out.println((char)tempChar);
            }

            // printing to an output file
            outputWriter.print(inputStorage);

            // closing all the readers and writer.
            inpReader.close();
            bFileReader.close();
            keyReader.close();
            inputReader.close();
            outputWriter.close();
        }  catch (IOException e) {
            System.out.println("IOException Error.");
        }
    }
}