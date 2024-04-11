// CS-280 Sp24
// Sydney Nilles
// Assignment 9 - due 04/12/2024

import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        Scanner nelson = new Scanner(System.in);
        int num1 = 0;
        int counter = 0;
        int numInvalid = 0;
        while(counter < 2){
            System.out.println("Please enter a number: ");
            try {
                num1 += nelson.nextInt();
                counter ++;
            } catch (Exception e) {
                System.out.print("Incorrect input. ");
                nelson.nextLine();
                numInvalid ++;
            }     
        }
        System.out.println("The sum is: " + num1);
        System.out.println("Number of invalid inputs: " + numInvalid);
        nelson.close();
        
    }
}