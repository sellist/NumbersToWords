package org.sellis;

public class App
{
    public static void main( String[] args ) {
        NumbersToWords numToWords = new NumbersToWords();
        UserInputHandler userHandler = new UserInputHandler();

        while (true) {
            System.out.println(numToWords.convertNumberToWords(userHandler.getUserInteger()));
            System.out.println("Enter q to quit, or anything else to go again.");
            if (userHandler.getInput().equals("q")) {
                System.exit(0);
            }
        }

    }
}
