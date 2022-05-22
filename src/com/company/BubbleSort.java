package com.company;

import java.io.FileWriter;
import java.io.IOException;

class BubbleSort extends Words {
    public long OperationsCounter = 0;

    public void bubbleSort() throws IOException {
        String[] WordList = getWords().toArray(new String[0]);
        OperationsCounter += 2; // Assgnmnt & Referencing

        System.out.println("Starting the bubble sort algorithm ...");
        OperationsCounter++; // int j = 1
        for (int j = 0; j < WordList.length - 1; j++) {

            if(j%5000==0)
            {
                System.out.println("N= "+(j)+". Primitive Operation= "+OperationsCounter);
            }

            OperationsCounter += 4; // j < WordList.length - 1 and j++
            OperationsCounter += 2; // int i = j + 1
            for (int i = j + 1; i < WordList.length; i++) {
                OperationsCounter += 3; // i < WordList.length and i++
                OperationsCounter += 3; // WordList[j].compareToIgnoreCase(WordList[i]) > 0
                if (WordList[j].compareToIgnoreCase(WordList[i]) > 0) {
                    String temp = WordList[j];
                    WordList[j] = WordList[i];
                    WordList[i] = temp;
                    OperationsCounter += 7; // All operations in this if statement
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


    }

}
