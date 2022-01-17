package ArraysListsData.Week2;

import edu.duke.*;
import java.util.*;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies () {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    public void findUnique () {
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();

        for (String word : fr.words()) {
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            if (index == -1) {
                myWords.add(word);
                myFreqs.add(1);
            } else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }
        }
    }

    private int findIndexOfMax () {
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for (int i = 1; i < myFreqs.size(); i++) {
            if (max < myFreqs.get(i)) {
                max = myFreqs.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void tester() {
        findUnique();
        System.out.println("Number of unique words: " + myWords.size());

        //for (int i = 0; i < myWords.size(); i++) {
        //    System.out.println(myFreqs.get(i) + " " + myWords.get(i));
        //}

        System.out.println("The word that occurs the most often and its count are: " + myWords.get(findIndexOfMax()) + " " + myFreqs.get(findIndexOfMax()));
    }

}
