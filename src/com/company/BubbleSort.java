package com.company;

import java.io.FileWriter;
import java.io.IOException;

class BubbleSort extends Words {
    public long OperationsCounter = 0;

    public void bubbleSort() throws IOException {
        String[] WordList = getWords().toArray(new String[0]);
        OperationsCounter++;

        System.out.println("Starting the bubble sort algorithm ...");

        for (int j = 0; j < WordList.length - 1; j++) {
            OperationsCounter += 2;
            for (int i = j + 1; i < WordList.length; i++) {
                OperationsCounter += 2;
                if (WordList[j].compareToIgnoreCase(WordList[i]) > 0) {
                    String temp = WordList[j];
                    WordList[j] = WordList[i];
                    WordList[i] = temp;
                    OperationsCounter += 3;
                }
            }
        }

        System.out.println("The Words List has been sorted using Bubble Sort, now writing it into a text file ...");

        FileWriter writer = new FileWriter("bubbleSorted.txt");
        for (int x = 0; x < WordList.length; x++) {
            writer.write(WordList[x] + '\n');
        }
        writer.close();
        System.out.println("The Sorted Words List is now in bubbleSorted.txt file");
        System.out.println("Primitive Operation = " + OperationsCounter);
        promptEnterKey();
        clearScreen();

    }

}
