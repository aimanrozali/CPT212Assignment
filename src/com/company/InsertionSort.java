package com.company;

import java.io.FileWriter;
import java.io.IOException;

// implementation of Insertion Sort (IS)
class InsertionSort extends Words {
    private long OperationsCounter = 0; // initial Primitive Operation Counter (POC)

    // array sorting with IS
    public void insertionSort() throws IOException {
        String[] WordList = getWords().toArray(new String[0]);

        System.out.println("Starting the Insertion Sort algorithm ...");

        OperationsCounter++; //int j
        for (int j = 1; j < WordList.length; j++) {
            OperationsCounter += 3; // POC incremented by 3
            String key = WordList[j];
            int i = j - 1;
            OperationsCounter += 4; // POC incremented by 4

            // elements of array that are greater than key is moved one position to the right from initial position
            while ((i > -1) && (WordList[i].compareToIgnoreCase(key) > 0)) {
                OperationsCounter += 3;
                WordList[i + 1] = WordList[i];
                i--;
                OperationsCounter += 4; // POC incremented by 4
            }
            WordList[i + 1] = key;
            OperationsCounter+= 3;    // POC incremented by 3
        }

        System.out.println("The Words List has been sorted using Insertion Sort, now writing it into a text file ...");

        // printing sorted word list in a text file
        FileWriter writer = new FileWriter("insertionSorted.txt");
        for (String s : WordList) {
            writer.write(s + '\n');
        }
        writer.close();
        System.out.println("The Sorted Words List is now in insertionSorted.txt file");
        System.out.println("Primitive Operation =" + OperationsCounter);


    }

}
