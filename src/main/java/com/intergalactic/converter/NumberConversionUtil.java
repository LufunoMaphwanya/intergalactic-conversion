package src.main.java.com.intergalactic.converter;

import java.util.Arrays;

public class NumberConversionUtil {

    public static int romanToDecimal(String romanNumeral) {
        int[] romanNumeralInts = new int[romanNumeral.length()];

        for (int i = 0; i < romanNumeral.length(); i++) {
            switch (romanNumeral.charAt(i)) {
                case 'I':
                    romanNumeralInts[i] = 1;
                    break;
                case 'V':
                    romanNumeralInts[i] = 5;
                    break;
                case 'X':
                    romanNumeralInts[i] = 10;
                    break;
                case 'L':
                    romanNumeralInts[i] = 50;
                    break;
                case 'C':
                    romanNumeralInts[i] = 100;
                    break;
                case 'D':
                    romanNumeralInts[i] = 500;
                    break;
                case 'M':
                    romanNumeralInts[i] = 1000;
                    break;
            }
        }


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


}
