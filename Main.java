// CS-280 Sp24
// Sydney Nilles
// Assignment 9 - due 04/12/2024

import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        Scanner nelson = new Scanner(System.in);
        int num1 = 0;
        for(int i = 0; i < 2; i++){
            System.out.println("Please enter a number: ");
            try {
                num1 += nelson.nextInt();
            } catch (Exception e) {
                System.out.println("Incorrect input, please enter a number.");
            }     
        }
        
    }
}