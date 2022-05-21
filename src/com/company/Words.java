package com.company;

//import com.sun.corba.se.spi.orb.Operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

class Words {

    private List<String> listOfWords = new ArrayList<String>();
    private int primCounter = 0;

    public void ImportWord() throws FileNotFoundException {
        List<String> words = new ArrayList<String>();
        File myFile = new File(
                "C:\\Users\\Aiman\\Desktop\\Bachelor Of Computer Science (Hons)\\CPT212\\CPT212Assignment\\WorstList.txt");
        Scanner sc = new Scanner(myFile);

        while (sc.hasNextLine()) {
            words.add(sc.nextLine());
        }

        this.listOfWords = words;
        System.out.println("Words list have been imported ...");

    }

    public List<String> getWords() {
        return listOfWords;
    }

    public void setPrimCounter(int ctr) {
        primCounter = ctr;
    }

    public int getPrimCounter() {
        return primCounter;
    }

    public void promptEnterKey() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}







