package com.intergalactic.converter;

import java.util.LinkedHashMap;
import java.util.Map;

public class NumberConversionUtil {

    public static int romanToDecimal(String romanNumeral) throws Exception {
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

    private static int[] convertToInts(String r) throws Exception {
        int[] intArray = new int[r.length()];
        for (int i = 0; i < r.length(); i++) {
            intArray[i] = convertRomanCharToDecimal(r.charAt(i));
        }

        return intArray;
    }

    private static int convertRomanCharToDecimal(char romanChar) throws Exception {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                String exDescription = String.format("Character %s is not a valid", romanChar);
                throw new Exception(exDescription);
        }
    }

    public static String decimalToRomanNumerals(int Int) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
            int matches = Int/entry.getValue();
            res += repeat(entry.getKey(), matches);
            Int = Int % entry.getValue();
        }
        return res;
    }

    public static String repeat(String s, int n) {
        if(s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

}
