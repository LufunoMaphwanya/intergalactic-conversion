package src.main.java.com.intergalactic.converter;

import java.util.Arrays;

public class NumberConversionUtil {

    public static int romanToDecimal(String romanNumeral) {
        int[] romanNumeralInts = convertToInts(romanNumeral);

        // Do subtractions first
        for (int i = 0; i < romanNumeralInts.length; i++) {
            if (i != romanNumeralInts.length - 1 && romanNumeralInts[i] < romanNumeralInts[i + 1]) {
                romanNumeralInts[i + 1] = romanNumeralInts[i + 1] - romanNumeralInts[i];
                romanNumeralInts[i] = 0;
            }
        }


        //Additions second
        int sum = 0;
        for (int num : romanNumeralInts) {
            sum += num;
        }

        return sum;
    }

    private static int[] convertToInts(String r) {
        int[] intArray = new int[r.length()];

        for (int i = 0; i < r.length(); i++) {
            switch (r.charAt(i)) {
                case 'I':
                    intArray[i] = 1;
                    break;
                case 'V':
                    intArray[i] = 5;
                    break;
                case 'X':
                    intArray[i] = 10;
                    break;
                case 'L':
                    intArray[i] = 50;
                    break;
                case 'C':
                    intArray[i] = 100;
                    break;
                case 'D':
                    intArray[i] = 500;
                    break;
                case 'M':
                    intArray[i] = 1000;
                    break;
            }
        }

        return intArray;
    }


}
