package com.company;

import java.io.FileWriter;
import java.io.IOException;

class QuickSort extends Words {
    static int OperationsCounter = 0;

    public void QuickSort() throws IOException {
        String[] WordList = getWords().toArray(new String[0]);
        System.out.println("Starting the Quick Sort algorithm ...");
        quickSort(WordList, 0, WordList.length - 1, OperationsCounter);
        System.out.println("The Words List has been sorted using Quick Sort, now writing it into a text file ...");
        FileWriter writer = new FileWriter("quickSorted.txt");
        for (int x = 0; x < WordList.length; x++) {
            writer.write(WordList[x] + '\n');
        }
        writer.close();
        System.out.println("The Sorted Words List is now in quickSorted.txt file");
        System.out.println("Primitive Operation =" + OperationsCounter);
        promptEnterKey();
        clearScreen();
    }

    public void quickSort(String[] WordList, int lowerindex, int higherindex, int OperationsCounter)
            throws IOException {

        int i = lowerindex; // low index

        int j = higherindex; // high index


        String pivot = WordList[i + (j - i) / 2];

        while (i <= j)

        {
            while (WordList[i].compareToIgnoreCase(pivot) < 0)

            {
                i++;

            }
            while (WordList[j].compareToIgnoreCase(pivot) > 0)

            {
                j--;

            }
            if (i <= j)

            {
                String temp = WordList[i];

                WordList[i] = WordList[j];

                WordList[j] = temp;

                i++;

                j--;


            }
        }

        if (lowerindex < j) {

            quickSort(WordList, lowerindex, j, OperationsCounter);
        }
        if (i < higherindex) {

            quickSort(WordList, i, higherindex, OperationsCounter);
        }

    }

}
