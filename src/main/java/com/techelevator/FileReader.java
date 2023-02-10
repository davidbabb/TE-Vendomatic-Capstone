package com.techelevator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static List<ProductCount> readSnacksFromFile(String fileName) {
        List<ProductCount> snacks = new ArrayList<>(); //initalize a list of ProductCount objects named snacks
        try (BufferedReader buffRead = new BufferedReader(new java.io.FileReader(fileName))) { //open a BufferRead and reads a file from fileName
            String line; // variable to store each line of text
            while ((line = buffRead.readLine()) != null) { //while loop will read each line from file until the end of the file is reached indicated by null
                String[] values = line.split("\\|");// line is split into an array of String values by the pipe
                ProductCount snack = new ProductCount(values[0], values[1], Double.parseDouble(values[2]), values[3], 5); //A new ProductCount object called snack is created from the values array and is added to that list
                snacks.add(snack); //adds the object snack to the list of ProductCount objects snacks
            }

        } catch (IOException e){ // this catch block will handle any exceptions that might be thrown when the file is read
            e.printStackTrace();// prints the stack trace of the exception
        }
        return snacks; //returns the list of snacks once all lines are processed
    }
}
