import java.io.*;
import javax.swing.*;

public class TempDLS {
    public static void main(String [] args){
        int buttonSize = 50;
        JFrame frame = new JFrame();
        

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

                } else {
                    displayName = numbers[index];
                }
                JButton button = new JButton(displayName);
                button.setBounds(20+(j*buttonSize), 20+(i*buttonSize), buttonSize, buttonSize);
                frame.add(button);
            }
        }

        frame.setSize(400, 800); //size of the screen
        frame.setLayout(null);
        frame.setVisible(true); //makes the frame visible
    }
}
