package com.company;

import com.sun.corba.se.spi.orb.Operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;


class Words
{

    private List<String> listOfWords = new ArrayList<String>();
    private int primCounter = 0;

    public void ImportWord() throws FileNotFoundException {
        List<String> words = new ArrayList<String>();
        File myFile = new File ("C:\\Users\\Aiman\\Desktop\\Bachelor Of Computer Science (Hons)\\CPT212\\CPT212Assignment\\src\\com\\company\\wordList.txt");
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

    public void setPrimCounter(int ctr) {primCounter = ctr;}

    public int getPrimCounter() { return primCounter; }

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
    public long OperationsCounter = 0;

    public void bubbleSort() throws IOException {
        String [] WordList = getWords().toArray(new String [0]);
        OperationsCounter++;

        System.out.println("Starting the bubble sort algorithm ...");

        for(int j = 0; j < WordList.length - 1; j++) {
            OperationsCounter+=2;
            for (int i = j + 1; i < WordList.length; i++) {
                OperationsCounter+=2;
                if (WordList[j].compareToIgnoreCase(WordList[i]) > 0) {
                    String temp = WordList[j];
                    WordList[j] = WordList[i];
                    WordList[i] = temp;
                    OperationsCounter+=3;
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
        System.out.println("Primitive Operation = "+OperationsCounter);
        promptEnterKey();
        clearScreen();

    }

}

class InsertionSort extends Words
{
    private long OperationsCounter = 0;

    public void insertionSort() throws IOException {
        String [] WordList = getWords().toArray(new String [0]);

        System.out.println("Starting the Insertion Sort algorithm ...");

        for (int j = 1; j < WordList.length; j++) {
            OperationsCounter+=2;
            String key = WordList[j];
            int i = j-1;
            OperationsCounter+=2;
            while ( (i > -1) && ( WordList[i].compareToIgnoreCase(key) > 0 ) ) {
                WordList[i+1] = WordList[i];
                i--;
                OperationsCounter+=4;
            }
            WordList[i+1] = key;
            OperationsCounter++;
        }

        System.out.println("The Words List has been sorted using Insertion Sort, now writing it into a text file ...");

        FileWriter writer = new FileWriter("insertionSorted.txt");
        for(int x = 0 ; x < WordList.length; x++)
        {
            writer.write(WordList[x] + '\n');
        }
        writer.close();
        System.out.println("The Sorted Words List is now in insertionSorted.txt file");
        System.out.println("Primitive Operation ="+OperationsCounter);
        promptEnterKey();
        clearScreen();


    }

}

class QuickSort extends Words
{
    static int OperationsCounter = 0;
    public void QuickSort() throws IOException {
        String [] WordList = getWords().toArray(new String [0]);
        OperationsCounter++;
        System.out.println("Starting the Quick Sort algorithm ...");
        quickSort(WordList,0, WordList.length - 1, OperationsCounter);
        System.out.println("The Words List has been sorted using Quick Sort, now writing it into a text file ...");
        FileWriter writer = new FileWriter("quickSorted.txt");
        for(int x = 0 ; x < WordList.length; x++)
        {
            writer.write(WordList[x] + '\n');
        }
        writer.close();
        System.out.println("The Sorted Words List is now in quickSorted.txt file");
        System.out.println("Primitive Operation ="+OperationsCounter);
        promptEnterKey();
        clearScreen();
    }

    public void quickSort(String [] WordList,int lowerindex, int higherindex, int OperationsCounter) throws IOException {


        int i = lowerindex; // low index
        OperationsCounter++;
        int j = higherindex; // high index
        OperationsCounter++;

        String pivot = WordList[i + (j-i) / 2];
        OperationsCounter++;
        while (i <= j)
            OperationsCounter++;
        {
            while(WordList[i].compareToIgnoreCase(pivot) < 0)
                OperationsCounter++;
            {
                i++;
                OperationsCounter++;
            }
            while(WordList[j].compareToIgnoreCase(pivot) >0)
                OperationsCounter++;
            {
                j--;
                OperationsCounter++;
            }
            if(i<=j)
                OperationsCounter++;
            {
                String temp = WordList[i];
                OperationsCounter++;
                WordList[i] = WordList[j];
                OperationsCounter++;
                WordList[j] = temp;
                OperationsCounter++;
                i++;
                OperationsCounter++;
                j--;
                OperationsCounter++;

            }
        }

        if (lowerindex<j){
            OperationsCounter++;
            quickSort(WordList,lowerindex,j, OperationsCounter);
        }
        if(i < higherindex){
            OperationsCounter++;
            quickSort(WordList,i,higherindex, OperationsCounter);
        }


    }

}

class RadixSort extends Words {

}




