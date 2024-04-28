package org.example.utils;

/**
 * NumberSpeller utils, spells the number to words
 */
public class NumberSpeller {

    private static String[] oneToNine = {
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static String[] tenToNinteen = {
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static String[] dozens = {
            "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static String spell(int number) {
        if (number == 0) {
            return "";
        }

        if (number <= 9) {
            return oneToNine[number - 1];
        }
        else if (number <= 19) {
            return tenToNinteen[number % 10];
        }
        else {
            return dozens[number / 10 - 1] + (((number % 10) == 0) ? spell(0) : " " + spell(number % 10));
        }
    }
}
