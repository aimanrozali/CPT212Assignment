package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class InverseSort {

    private List<String> listOfWords = new ArrayList<String>();

    public void ImportWord() throws IOException {
        List<String> words = new ArrayList<String>();
        File myFile = new File ("C:\\Users\\Aiman\\Desktop\\Bachelor Of Computer Science (Hons)\\CPT212\\CPT212Assignment\\bubbleSorted.txt");
        Scanner sc = new Scanner(myFile);

        while (sc.hasNextLine()) {
            words.add(sc.nextLine());
        }


        System.out.println("Words list have been imported ...");

        Collections.sort(words, Collections.reverseOrder());

        String [] wr = words.toArray(new String [0]);

        FileWriter writer = new FileWriter("inverseSorted.txt");
        for(int x = 0 ; x < wr.length; x++)
        {
            writer.write(wr[x] + '\n');
        }
        writer.close();
        System.out.println("Has been inverse sorted ...");

    }


}
