package com.company;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


// Main Class Starts
public class Main {


    public static int menu()
    {
        int selection = 0;
        Scanner cin = new Scanner(System.in);
        System.out.println("=========================================================");
        System.out.println("|              Sorting Algorithms                       |");
        System.out.println("=========================================================");
        System.out.println("|  1 . Quick Sort Algortihm (Best Case)                 |");
        System.out.println("|  2 . Bubble Sort Algortihm (Best Case)                |");
        System.out.println("|  3 . Insertion Sort Algortihm (Best Case)             |");
        System.out.println("|  4 . Radix Sort Algortihm (Best Case)                 |\n");
        System.out.println("|  5 . Quick Sort Algortihm (Average Case)              |");
        System.out.println("|  6 . Bubble Sort Algortihm (Average Case)             |");
        System.out.println("|  7 . Insertion Sort Algortihm (Average Case)          |");
        System.out.println("|  8 . Radix Sort Algortihm (Average Case)              |\n");
        System.out.println("|  9 . Quick Sort Algortihm (Worst Case)                |");
        System.out.println("|  10. Bubble Sort Algortihm (Worst Case)               |");
        System.out.println("|  11. Insertion Sort Algortihm (Worst Case)            |");
        System.out.println("|  12. Radix Sort Algortihm (Worst Case)                |\n");
        System.out.println("|  13. Exit                                             |");
        System.out.println("=========================================================");
        System.out.println("Choose which sort algorithm you want to use to sort the word list ( 1-4 ) : ");
        int flag = 0;
        // Prompt User To Select
        while(flag != 1)
        {
            selection = cin.nextInt();
            if(selection < 1 || selection > 13)
            {
                System.out.println("You have entered an invalid input ! ");
                System.out.println("Choose which sort algorithm you want to use to sort the word list ( 1-4 ) : ");
            }
            else
            {
                flag = 1;
                break;
            }
        }

        return selection;

    }

    // Selection Menu For Type Sort To Be Implemented
    public static void main(String[] args) throws IOException {

        QuickSort QS = new QuickSort();
        BubbleSort BS = new BubbleSort();
        InsertionSort IS = new InsertionSort();
        RadixSort RS = new RadixSort();

        int selection = 0;

        while(selection != 13)
        {
            switch(selection = menu())
            {
                /*-------BEST CASE---------------------------*/
                case 1 : QS.ImportWord(1);
                         QS.QuickSort();
                         break;
                case 2 : BS.ImportWord(1);
                         BS.bubbleSort();
                         break;
                case 3 : IS.ImportWord(1);
                         IS.insertionSort();
                         break;
                case 4 : RS.ImportWord(4);
                         RS.radixSort();
                         break;
                /*-------Average Case--------------------------*/
                case 5 : QS.ImportWord(2);
                         QS.QuickSort();
                         break;
                case 6 : BS.ImportWord(2);
                        BS.bubbleSort();
                        break;
                case 7 : IS.ImportWord(2);
                        IS.insertionSort();
                        break;
                case 8 : RS.ImportWord(2);
                        RS.radixSort();
                        break;
                /*--------Worst Case---------------------*/
                case 9 : QS.ImportWord(3);
                        QS.QuickSort();
                        break;
                case 10 : BS.ImportWord(3);
                        BS.bubbleSort();
                        break;
                case 11 : IS.ImportWord(3);
                        IS.insertionSort();
                        break;
                case 12 : RS.ImportWord(5);
                        RS.radixSort();
                        break;
                /*--------------------------------------*/
                case 13 : break;
            }
        }


    }
}
