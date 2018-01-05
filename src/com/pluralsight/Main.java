package com.pluralsight;

import java.io.IOException;

public class Main {

    /*
    https://programmingbydoing.com/
    Simple file input - Assignment #130
     */

    public static void main(String[] args) throws IOException {

        System.out.println();

        //Instantiate the name class
        Name name = new Name();

        //Read the names from the provided file
        name.readInName();
        //Add a name
        name.addName("The wife");
        //Replace a name
        name.replaceName("Krystin Giroux","Krystin Golden");
        //Write the names to a new file
        name.writeOutName();

        System.out.println("Success!");


    }
}
