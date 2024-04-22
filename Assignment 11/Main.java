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
            outputWriter.write(input.substring(0,51));

            // close all the things that need to be closed
            nelson.close();
            outputWriter.close();
        } catch (IOException e) {
            // TODO: handle exception
        }
        
    }
}
