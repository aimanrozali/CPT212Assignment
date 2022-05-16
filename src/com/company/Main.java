package com.company;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static int menu()
    {
        int selection = 0;
        Scanner cin = new Scanner(System.in);
        System.out.println("==============================================");
        System.out.println("|              Sorting Algorithms            |");
        System.out.println("==============================================");
        System.out.println("|  1 . Quick Sort Algortihm                  |");
        System.out.println("|  2 . Bubble Sort Algortihm                 |");
        System.out.println("|  3 . Insertion Sort Algortihm              |");
        System.out.println("|  4 . Exit                                  |");
        System.out.println("==============================================");
        System.out.println("Choose which sort algorithm you want to use to sort the word list ( 1-4 ) : ");
        int flag = 0;
        while(flag != 1)
        {
            selection = cin.nextInt();
            if(selection < 1 || selection > 4)
            {
                System.out.println("You have entered an invalid input ! ");
                System.out.println("Choose which sort algorithm you want to use to sort the word list ( 1-3 ) : ");
            }
            else
            {
                flag = 1;
                break;
            }
        }

        return selection;

    }

    public static void main(String[] args) throws IOException {

        int selection = 0;

        while(selection != 4)
        {
            switch(selection = menu())
            {
                case 1 : QuickSort QS = new QuickSort(); QS.ImportWord();QS.QuickSort(); break;
                case 2 : BubbleSort BS = new BubbleSort(); BS.ImportWord();BS.bubbleSort();break;
                case 3 : InsertionSort IS = new InsertionSort(); IS.ImportWord();IS.insertionSort();break;
                case 4 : break;
            }
        }


    }
}
