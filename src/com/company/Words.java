package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Words
{

    private List<String> listOfWords = new ArrayList<String>();

    public void ImportWord() throws FileNotFoundException {
        List<String> words = new ArrayList<String>();
        File myFile = new File ("C:\\Users\\arman\\Desktop\\CPT212Assignment\\src\\com\\company\\wordList.txt");
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

    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

class BubbleSort extends Words
{
    private int OperationsCounter;

    public void bubbleSort() throws IOException {
        String [] WordList = getWords().toArray(new String [0]);

        System.out.println("Starting the bubble sort algorithm ...");

        for(int j = 0; j < WordList.length - 1; j++) {
            for (int i = j + 1; i < WordList.length; i++) {
                if (WordList[j].compareToIgnoreCase(WordList[i]) > 0) {
                    String temp = WordList[j];
                    WordList[j] = WordList[i];
                    WordList[i] = temp;
                }
            }
        }

        System.out.println("The Words List has been sorted using Bubble Sort, now writing it into a text file ...");

        FileWriter writer = new FileWriter("bubbleSorted.txt");
        for(int x = 0 ; x < WordList.length; x++)
        {
            writer.write(WordList[x] + '\n');
        }
        writer.close();
        System.out.println("The Sorted Words List is now in bubbleSorted.txt file");
        promptEnterKey();
        clearScreen();

    }

}

class InsertionSort extends Words
{
    public void insertionSort() throws IOException {
        String [] WordList = getWords().toArray(new String [0]);

        System.out.println("Starting the Insertion Sort algorithm ...");

        for (int j = 1; j < WordList.length; j++) {
            String key = WordList[j];
            int i = j-1;
            while ( (i > -1) && ( WordList[i].compareToIgnoreCase(key) > 0 ) ) {
                WordList[i+1] = WordList[i];
                i--;
            }
            WordList[i+1] = key;
        }

        System.out.println("The Words List has been sorted using Insertion Sort, now writing it into a text file ...");

        FileWriter writer = new FileWriter("insertionSorted.txt");
        for(int x = 0 ; x < WordList.length; x++)
        {
            writer.write(WordList[x] + '\n');
        }
        writer.close();
        System.out.println("The Sorted Words List is now in insertionSorted.txt file");
        promptEnterKey();
        clearScreen();


    }

}

class QuickSort extends Words
{
    public void QuickSort() throws IOException {
        String [] WordList = getWords().toArray(new String [0]);
        System.out.println("Starting the Quick Sort algorithm ...");
        quickSort(WordList,0, WordList.length - 1);
        System.out.println("The Words List has been sorted using Quick Sort, now writing it into a text file ...");
        FileWriter writer = new FileWriter("quickSorted.txt");
        for(int x = 0 ; x < WordList.length; x++)
        {
            writer.write(WordList[x] + '\n');
        }
        writer.close();
        System.out.println("The Sorted Words List is now in quickSorted.txt file");
        promptEnterKey();
        clearScreen();
    }

    public void quickSort(String [] WordList,int lowerindex, int higherindex) throws IOException {


        int i = lowerindex; // low index
        int j = higherindex; // high index

        String pivot = WordList[i + (j-i) / 2];
        while (i <= j)
        {
            while(WordList[i].compareToIgnoreCase(pivot) < 0)
            {
                i++;
            }
            while(WordList[j].compareToIgnoreCase(pivot) >0)
            {
                j--;
            }
            if(i<=j)
            {
                String temp = WordList[i];
                WordList[i] = WordList[j];
                WordList[j] = temp;
                i++;
                j--;

            }
        }

        if (lowerindex<j){
            quickSort(WordList,lowerindex,j);
        }
        if(i < higherindex){
            quickSort(WordList,i,higherindex);
        }


    }

}

