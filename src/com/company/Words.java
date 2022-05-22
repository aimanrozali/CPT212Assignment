package com.company;

//import com.sun.corba.se.spi.orb.Operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

// to get list of words that user wants to sort
class Words {

    private List<String> listOfWords = new ArrayList<String>();
    private int primCounter = 0;

    // searching list of words
    public void ImportWord(int sel) throws FileNotFoundException {
        List<String> words = new ArrayList<String>();

        String path = "";

        switch (sel)
        {
            case 1: path = "C:\\Users\\Aiman\\Desktop\\Bachelor Of Computer Science (Hons)\\CPT212\\CPT212Assignment\\BestList.txt";
                    System.out.println("Using Sorted Word File...");
                    break;
            case 2: path = "C:\\Users\\Aiman\\Desktop\\Bachelor Of Computer Science (Hons)\\CPT212\\CPT212Assignment\\AverageList.txt";
                    System.out.println("Using Unsorted Word File...");
                    break;
            case 3: path = "C:\\Users\\Aiman\\Desktop\\Bachelor Of Computer Science (Hons)\\CPT212\\CPT212Assignment\\WorstList.txt";
                    System.out.println("Using Reverse Sorted Word File...");
                    break;
            case 4: path = "C:\\Users\\Aiman\\Desktop\\Bachelor Of Computer Science (Hons)\\CPT212\\CPT212Assignment\\RadixBestCase.txt";
                    System.out.println("Using Radix Best Case Word File...");
                    break;
            case 5: path = "C:\\Users\\Aiman\\Desktop\\Bachelor Of Computer Science (Hons)\\CPT212\\CPT212Assignment\\RadixWorstCase.txt";
                    System.out.println("Using Radix Worst Case Word File...");
                    break;

            default:
                    path = "C:\\Users\\Aiman\\Desktop\\Bachelor Of Computer Science (Hons)\\CPT212\\CPT212Assignment\\AverageList.txt";
        }

        File myFile = new File(path);
        Scanner sc = new Scanner(myFile);


        while (sc.hasNextLine()) {
            words.add(sc.nextLine());
        }

        this.listOfWords = words;
        System.out.println("Words list have been imported ...");

    }

    // retrieving list of words
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







