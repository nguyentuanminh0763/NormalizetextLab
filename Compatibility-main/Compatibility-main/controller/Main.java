package Compatibility.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {


    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            int countLine = Compatibility.countLine();
            int count = 1;
            br = new BufferedReader(new FileReader(new File("E:\\LAB211\\Compatibility\\data\\input.txt")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("E:\\LAB211\\Compatibility\\data\\output.txt", true)));
            String line;
            //write until end file
            while ((line = br.readLine()) != null) {
                //check line empty
                if (Compatibility.isLineEmpty(line)) {
                    continue;
                }
                line = Compatibility.formatOneSpace(line);
                line = Compatibility.formatSpecialCharacters(line);
                line = Compatibility.afterDotUpperCase(line);
                line = Compatibility.noSpaceQuotes(line);
                line = Compatibility.firstUpercase(line);
                line = Compatibility.lastAddDot(line);
                pw.print(line);
                if (count < countLine) {
                    pw.print(System.getProperty("line.separator"));
                }
                count++;
            }
            br.close();
            pw.close();
            System.out.println("Normalize successful.");
        } catch (FileNotFoundException ex) {
            System.err.println("Can't not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}