package org.sellis;

import java.util.Scanner;

public class UserInputHandler {

    Scanner scan = new Scanner(System.in);

    /**
     * Takes and validates raw user input
     * @return String of a valid string, empty if input is invalid.
     */
    public String getInput(){
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        if (userInput != null && !userInput.isBlank() && !userInput.isEmpty()) {
            return userInput;
        }
        return "";
    }

    /**
     * Converts string from user input to a usable integer
     * @return Integer converted from String user input, null if input is invalid.
     */
    public Integer convertInputToInteger(String userInput){
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Streamlines process to call for user input to get integer
     * @return Valid, non-null integer
     */
    public int getUserInteger(){
        Integer output = null;
        while (output == null) {
            System.out.println("Please enter an integer");
            output = this.convertInputToInteger(this.getInput());
        }
        return output;
    }
}
