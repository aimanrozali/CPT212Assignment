package com.company;

import java.io.FileWriter;
import java.io.IOException;

// Quick Sort Algorithm
class QuickSort extends Words {
    static int OperationsCounter = 0;

    public void QuickSort() throws IOException {
        String[] WordList = getWords().toArray(new String[0]);
        System.out.println("Starting the Quick Sort algorithm ...");
        int operationCounter =+ quickSort(WordList, 0, WordList.length - 1, OperationsCounter);
        System.out.println("The Words List has been sorted using Quick Sort, now writing it into a text file ...");
        FileWriter writer = new FileWriter("quickSorted.txt");
        for (int x = 0; x < WordList.length; x++) {
            writer.write(WordList[x] + '\n');
        }
        writer.close();
        System.out.println("The Sorted Words List is now in quickSorted.txt file");
        System.out.println("Primitive Operation =" + operationCounter);

    }

    public int quickSort(String[] WordList, int lowerindex, int higherindex, int OperationsCounter)
            throws IOException {

        int i = lowerindex; // low index
        int j = higherindex; // high index
        OperationsCounter += 2; // 2 assignments

        String pivot = WordList[i + (j - i) / 2];
        OperationsCounter += 5; // Assignment, Referencing & Arithmetic

        OperationsCounter++; // First comparison
        while (i <= j)
        {
            OperationsCounter++;//Loop comparison

            OperationsCounter++;//First comparison
            while (WordList[i].compareToIgnoreCase(pivot) < 0)
            {
                OperationsCounter++;//Loop comparison
                i++;
                OperationsCounter += 2; // Assignment & Arithmetic
            }
            OperationsCounter++;//Entrance comparison
            while (WordList[j].compareToIgnoreCase(pivot) > 0)
            {
                OperationsCounter++;//Entrance comparison
                j--;
                OperationsCounter += 2; // Assignment & Arithmetic
            }
            OperationsCounter++;//Entrance comparison
            if (i <= j)
            {
                String temp = WordList[i];
                OperationsCounter += 2; // Asgnmnt + Referencing
                WordList[i] = WordList[j];
                OperationsCounter += 3; // Asgnmnt + 2 Referencing
                WordList[j] = temp;
                OperationsCounter += 3; // Asgnmnt + Referencing
                i++;
                j--;
                OperationsCounter += 4; // Assignment & Arithmetic
            }
        }
        OperationsCounter++;//Entrance comparison
        if (lowerindex < j) {
            OperationsCounter=+quickSort(WordList, lowerindex, j, OperationsCounter);
        }
        OperationsCounter++;//Entrance comparison
        if (i < higherindex) {
            OperationsCounter=+quickSort(WordList, i, higherindex, OperationsCounter);
        }

        return OperationsCounter;
    }
}
