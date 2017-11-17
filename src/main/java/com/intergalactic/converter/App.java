package com.intergalactic.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class App {

    public static void main(String[] args) throws Exception {

        ConversionBot bot = new ConversionBot();

        String filename = "instructions.txt";

        File inputFile = new File(filename);
        BufferedReader buffer = new BufferedReader(new FileReader(inputFile));

        String readLine = "";

        while ((readLine = buffer.readLine()) != null) {
            bot.receiveInfo(readLine);
        }


    }
}
