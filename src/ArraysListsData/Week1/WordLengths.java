package ArraysListsData.Week1;
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class WordLengths {
    public String[] getCommon() {
        FileResource resource = new FileResource("/common.txt");
        String[] common = new String[20];
        int index = 0;
        for (String s: resource.words()) {
            common[index] = s;
            index += 1;
        }
        return common;
    }

    public int indexOf (String [] list, String word) {
        for (int k = 0; k < list.length; k++) {
            if (list[k].equals(word)) {
                return k;
            }
        }
        return -1;
    }

    public void countWordLengths(FileResource resource, int[] counts) {
        for (String word: resource.words()) {
            int adjustedLength = word.length();
            for (int k = 0; k < word.length(); k++) {
                if (k == 0 || (k == (word.length()-1)) ) {
                    if (!Character.isLetter(word.charAt(k))) {
                        adjustedLength--;
                    }
                }
            }
            counts[adjustedLength]++;
        }
    }

    public void testCountWorthLengths() {
        String[] plays = {"smallHamlet.txt"};
        int[] counts = new int[31];
        for (int i = 0; i < plays.length; i++) {
            FileResource fr = new FileResource("data/" + plays[i]);
            countWordLengths(fr, counts);
            System.out.println("done with " + plays[i]);
        }

        for (int k = 0; k < counts.length; k++) {
            System.out.println(k + " " + counts[k]);
        }

        System.out.println("The most common word length is " + indexOfMax(counts));
    }

    public int indexOfMax (int[] values) {
        int currentMax = Integer.MIN_VALUE;
        int indexOfCurrentMax = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > currentMax) {
                currentMax = values[i];
                indexOfCurrentMax = i;
            }
        }
        return indexOfCurrentMax;
    }
}
