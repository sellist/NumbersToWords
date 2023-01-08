package org.sellis;

import java.util.ArrayList;
import java.util.List;

public class NumbersToWords {


    // zero and one indices sometimes empty to make math easier later
    private static final String[] ONES = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };
    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    private static final String[] TEENS = {
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    // if wanted, can add further magnitudes and do some recasting to longs throughout to support up to -/+ 2^63
    private static final String[] MAGNITUDES = {
            "", "thousand", "million", "billion"
    };

    /**
     * @param input Signed integer desired to translate into English spoken word format
     * @return Spoken English representation of given number.
     */
    public String convertNumberToWords(int input){
        int number;
        StringBuilder output = new StringBuilder();

        if (input == 0) {
            return "zero";
        }

        // handles negatives and prevents mutation of input
        if (input < 0) {
            output.append("negative ");
            number = -input;
        } else {
            number = input;
        }

        if (number < 1000) {
            output.append(convertMagnitude(number));
        } else {
            output.append(convertGreaterThanOneThousand(number));
        }

        // trim removes the excess zero and one index's in ONES, TENS, and MAGNITUDES if needed
        return output.toString().trim();
    }

    /**
     * Handles a given input as if it is below one thousand, converting 0-999 to English. Magnitudes should be added
     * after this is called.
     * @param number One-digit to three-digit integer.
     * @return English representation of given numbers, sans magnitude
     */
    private String convertMagnitude(int number) {
        List<String> output = new ArrayList<>();
        int hundreds = number / 100;

        if (hundreds >= 1) {
            output.add(ONES[hundreds]);
            output.add("hundred");
            number -= hundreds * 100;
        }

        int ones = number % 10;

        if (number < 10) {
            output.add(ONES[number]);
            return String.join(" ", output).trim();
        } else if (number < 20) {
            output.add(TEENS[number - 10]);
            return String.join(" ", output).trim();
        }

        int tens = number / 10;
        output.add(TENS[tens]);
        output.add(ONES[ones]);

        return String.join(" ", output).trim();
    }

    /**
     * Main logic loop to work through magnitudes to work through number
     * @param number Sanitized user input as integer to process
     * @return English representation of given number
     */
    private String convertGreaterThanOneThousand(int number) {

        List<String> output = new ArrayList<>();
        int remainder = 0;

        // reverse iterate through magnitudes list to work starting at largest
        for (int i = MAGNITUDES.length - 1; i >= 0; i--) {
            int currentMagnitude = (int) Math.pow(1000, i);
            if (number >= currentMagnitude) {
                int magnitudeAmount = number / currentMagnitude;
                remainder = number - (magnitudeAmount * currentMagnitude);
                number -= magnitudeAmount * currentMagnitude;

                output.add(convertMagnitude(magnitudeAmount));
                output.add(MAGNITUDES[i]);
            }
            if (currentMagnitude == 1) {
                output.add(convertMagnitude(remainder));
            }
        }
        return String.join(" ",output).trim();
    }
}
