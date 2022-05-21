package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RadixSort extends Words {

    public void radixSort() throws IOException {
        long epoch=0;
        String[] WordList = getWords().toArray(new String[0]);

        System.out.println("Starting Radix Sort...");

        int maxLen = getMax(WordList);
        epoch++;
        System.out.println(maxLen);

        long start, end;

        start = System.currentTimeMillis();
        sort(WordList,maxLen,epoch);
        end = System.currentTimeMillis();
        System.out.println("Elapsed: " + (end - start));
    }

    public static void sort(String[] arr, int maxLen, long epoch) throws IOException {
        final int BUCKETS = 256;

        ArrayList<String>[] wordsByLength = new ArrayList[maxLen + 1];
        ArrayList<String>[] buckets = new ArrayList[BUCKETS];

        epoch+=2;

        epoch++;
        for (int i = 0; i < wordsByLength.length; i++) {
            wordsByLength[i] = new ArrayList<>();
            epoch+=4;
        }

        epoch++;
        for (int i = 0; i < BUCKETS; i++) {
            buckets[i] = new ArrayList<>();
            epoch+=4;
        }

        for (String s : arr) {
            wordsByLength[s.length()].add(s);
            epoch+=3;
        }

        int idx = 0;
        epoch++;
        for (ArrayList<String> wordList : wordsByLength) {
            epoch += 3;
            for (String s : wordList) {
                arr[idx++] = s;
                epoch+=4;
            }
        }

        int startingIndex = arr.length;
        epoch+=3;
        for (int pos = maxLen - 1; pos >= 0; pos--) {
            startingIndex -= wordsByLength[pos + 1].size();
            epoch+=6;

            for (int i = startingIndex; i < arr.length; i++) {
                buckets[arr[i].charAt(pos)].add(arr[i]);
                epoch+=3;
            }

            idx = startingIndex;
            epoch+=2;
            for (ArrayList<String> thisBucket : buckets) {
                epoch+=4;
                for (String s : thisBucket) {
                    arr[idx++] = s;
                    epoch+=3;
                }

                thisBucket.clear();
            }
        }

        printArr(arr,epoch);
    }

    static void printArr(String[] WordList, long epoch) throws IOException {
        FileWriter writer = new FileWriter("radixSorted.txt");
        for (int x = 0; x < WordList.length; x++) {
            writer.write(WordList[x] + '\n');
        }
        writer.close();

        System.out.println("Primitive Operation: "+epoch);
    }


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


