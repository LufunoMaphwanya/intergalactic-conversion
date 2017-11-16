package src.main.java.com.intergalactic.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static src.main.java.com.intergalactic.converter.NumberConversionUtil.romanToDecimal;

public class App {

    public static void main(String[] args) throws Exception {

        String filename = "instructions.txt";

        File inputFile = new File(filename);
        BufferedReader buffer = new BufferedReader(new FileReader(inputFile));

        String readLine = "";

        while ((readLine = buffer.readLine()) != null) {
            System.out.println(readLine);
        }




    }
}
