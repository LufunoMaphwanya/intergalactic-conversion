package src.main.java.com.intergalactic.converter;

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


}
