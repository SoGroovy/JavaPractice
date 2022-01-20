package ArraysListsData.Week2;

import edu.duke.*;
import java.util.*;
import java.io.*;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> wordList;

    public WordsInFiles() {
        wordList = new HashMap<String, ArrayList<String>>();

    }

    private void addWordsFromFile (File f) {
        FileResource fr = new FileResource(f);
        String fileName = f.getName();
        for (String element : fr.words()) {
            if (!wordList.containsKey(element)) {
                ArrayList<String> newList = new ArrayList<String>();
                newList.add(fileName);
                wordList.put(element, newList);
            } else if (wordList.containsKey(element) && !wordList.get(element).contains(fileName)) {
                ArrayList<String> currentList = wordList.get(element);
                currentList.add(fileName);
                wordList.put(element, currentList);
            }
        }
    }

    public void buildWordFileMap () {
        wordList.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            addWordsFromFile(f);
        }
    }

    public int maxNumber () {
        int max = 0;
        ArrayList<String> newList = new ArrayList<String>();
        for (String element : wordList.keySet()) {
            ArrayList<String> currentList = wordList.get(element);
            int currentNum = currentList.size();
            if (max < currentNum) {
                max = currentNum;
            }
        }
        return max;
    }

    public ArrayList wordsInNumFiles(int number) {
        ArrayList<String> newList = new ArrayList<String>();
        for (String element : wordList.keySet()) {
            ArrayList<String> currentList = wordList.get(element);
            int currentNum = currentList.size();
            if (currentNum == number) {
                newList.add(element);
            }
        }
        return newList;
    }

    public void printFilesIn(String word) {
        ArrayList<String> fileNames = wordList.get(word);
        for (int i = 0; i < fileNames.size(); i++) {
            System.out.println(fileNames.get(i));
        }
    }

    public void tester() {
        buildWordFileMap();
        int fileNum = maxNumber();
        System.out.println("Max number of files any word is in: " + fileNum);
        ArrayList<String> newList = wordsInNumFiles(fileNum);
        System.out.println("Total words in all files: " + newList.size());
        newList = wordsInNumFiles(4);
        System.out.println("Total words in 4 files: " + newList.size());
        printFilesIn("sad");
        printFilesIn("red");
        System.out.println("\n");
    }
}
