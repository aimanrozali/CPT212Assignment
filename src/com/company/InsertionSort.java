package com.company;

import java.io.FileWriter;
import java.io.IOException;

class InsertionSort extends Words {
    private long OperationsCounter = 0;

    public void insertionSort() throws IOException {
        String[] WordList = getWords().toArray(new String[0]);

        System.out.println("Starting the Insertion Sort algorithm ...");

        for (int j = 1; j < WordList.length; j++) {
            OperationsCounter += 2;
            String key = WordList[j];
            int i = j - 1;
            OperationsCounter += 2;
            while ((i > -1) && (WordList[i].compareToIgnoreCase(key) > 0)) {
                WordList[i + 1] = WordList[i];
                i--;
                OperationsCounter += 4;
            }
            WordList[i + 1] = key;
            OperationsCounter++;
        }

        System.out.println("The Words List has been sorted using Insertion Sort, now writing it into a text file ...");

        FileWriter writer = new FileWriter("insertionSorted.txt");
        for (int x = 0; x < WordList.length; x++) {
            writer.write(WordList[x] + '\n');
        }
        writer.close();
        System.out.println("The Sorted Words List is now in insertionSorted.txt file");
        System.out.println("Primitive Operation =" + OperationsCounter);
        promptEnterKey();
        clearScreen();

    }

}
