package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// implementation of Radix Sort (RS)
public class RadixSort extends Words {

    // main function of RS implementation
    public void radixSort() throws IOException {
        long epoch=0;   // initial Primitive Counter Operation (POC)
        String[] WordList = getWords().toArray(new String[0]);

        System.out.println("Starting Radix Sort...");

        // getting the max element
        int maxLen = getMax(WordList);
        epoch++;    // incrementing POC by 1
        System.out.println(maxLen);

        long start, end;

        start = System.currentTimeMillis();
        sort(WordList,maxLen,epoch);
        end = System.currentTimeMillis();
        System.out.println("Elapsed: " + (end - start));
    }

    // placing of elements in a sorted order
    public static void sort(String[] arr, int maxLen, long epoch) throws IOException {

        // Initialized buckets according to Extended ASCII index
        final int BUCKETS = 256;
        epoch++; // incrementing POC by 1

        ArrayList<String>[] wordsByLength = new ArrayList[maxLen + 1];
        ArrayList<String>[] buckets = new ArrayList[BUCKETS];

        epoch+=3;   // incrementing POC by 3

        epoch+=2;    // incrementing POC by 2

        // in search of elements with the most array value
        epoch++; // int i = 1
        for (int i = 0; i < wordsByLength.length; i++) {
            epoch+=3;//incrementing POC by 3
            wordsByLength[i] = new ArrayList<>();
            epoch+=2;// incrementing POC by 2
        }

        epoch++;    // incrementing POC by 1
        // assigning array to buckets
        for (int i = 0; i < BUCKETS; i++) {
            epoch += 3; // incrementing POC by 3
            buckets[i] = new ArrayList<>();
            epoch+=2;   // incrementing POC by 2
        }

        // finding the length of strings
        for (String s : arr) {
            wordsByLength[s.length()].add(s);
            epoch+=3;   // incrementing POC by 3
        }

        int idx = 0;
        epoch++;    // incrementing POC by 1
        for (ArrayList<String> wordList : wordsByLength) {
            epoch += 3; // incrementing POC by 3
            for (String s : wordList) {
                arr[idx++] = s;
                epoch+=4;   // incrementing POC by 4
            }
        }

        int startingIndex = arr.length;
        epoch++;   // incrementing POC by 1
        epoch += 2; //incrementing POC by 2
        for (int pos = maxLen - 1; pos >= 0; pos--) {
            epoch += 3; //incrementing POC by 3
            startingIndex -= wordsByLength[pos + 1].size();
            epoch+=4;   // incrementing POC by 4

            for (int i = startingIndex; i < arr.length; i++) {
                buckets[arr[i].charAt(pos)].add(arr[i]);
                epoch+=3;   // incrementing POC by 3
            }

            idx = startingIndex;
            epoch+=2;   // incrementing POC by 2
            for (ArrayList<String> thisBucket : buckets) {
                epoch+=4;   // incrementing POC by 4
                for (String s : thisBucket) {
                    arr[idx++] = s;
                    epoch+=3;   // incrementing POC by 3
                }

                thisBucket.clear(); // clear buckets
            }
        }

        printArr(arr,epoch);
    }

    // printing sorted words in a text file
    static void printArr(String[] WordList, long epoch) throws IOException {
        FileWriter writer = new FileWriter("radixSorted.txt");
        for (int x = 0; x < WordList.length; x++) {
            writer.write(WordList[x] + '\n');
        }
        writer.close();

        System.out.println("Primitive Operation: "+epoch);
    }


    // in search of the maximum element in the array
    static int getMax(String[] array) {
        int index = 0;
        int elementLength = array[0].length();
        for (int i = 1; i < array.length; i++) {
            if (array[i].length() > elementLength) {
                index = i;
                elementLength = array[i].length();
            }
        }
        return array[index].length();
    }

}


