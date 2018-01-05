package com.pluralsight;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Name {

    private ArrayList names = new ArrayList();

    public void readInName() throws IOException {

        //Get the path to the file and open it
        try (BufferedReader br = Files.newBufferedReader(Paths.get("name.txt"))) {

            String name;

            //Until there are no more lines to read from the file, loop through and add them to the list
            while ((name = br.readLine()) != null) {
                names.add(name);
            }

            //If there is an issue opening the file, it will throw a message
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    //If the proposed name doesn't already exist, add it, otherwise message
    public void addName(String nameToAdd) {
        if (!names.contains(nameToAdd)) {
            names.add(nameToAdd);
        } else {
            System.out.println("Can't add that name. It already exists");
        }
    }

    //If the name to be replaced exists, replace it, otherwise message
    public void replaceName(String nameToReplace, String nameToUse) {
        final int index = names.indexOf(nameToReplace);
        if (index != -1) {
            names.set(index, nameToUse);
        }
        else {
            System.out.println("Can't replace that name. It doesn't exist.");
        }
    }

    //Write out the list of names
    public void writeOutName() throws IOException {

        //Get the path to the file which will be created/overwritten,
        // read all the lines from the list into the file and close it
        try (BufferedWriter br = Files.newBufferedWriter(Paths.get("name2.txt"))) {

            int length;

            //As long as there are still lines to read from the list, loop through and write them out
            for (length = 0; length < names.size(); length++) {
                br.write((String) names.get(length));
                br.newLine();
            }

            //If there is an issue creating/opening the file to be written to, it will throw a message
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

}
