package ArraysListsData.Week2;

import edu.duke.*;
import java.util.*;
/**
 * Write a description of CharactersInPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CharactersInPlay {
    private ArrayList<String> characterNames;
    private ArrayList<Integer> nameFreqs;

    public CharactersInPlay () {
        characterNames = new ArrayList<String>();
        nameFreqs = new ArrayList<Integer>();
    }

    public void update (String person) {
        int index = characterNames.indexOf(person);
        if (!characterNames.contains(person)) {
            characterNames.add(person);
            nameFreqs.add(1);
        } else {
            int value = nameFreqs.get(index);
            nameFreqs.set(index, value + 1);
        }
    }

    public void findAllCharacters () {
        characterNames.clear();
        nameFreqs.clear();
        FileResource fr = new FileResource();
        for (String line: fr.lines()) {
            if (line.indexOf(".") != -1) {
                String possibleName = line.substring(0, line.indexOf("."));
                update(possibleName);
            }
        }
    }

    public void tester() {
        findAllCharacters();
        for (int i = 0; i < characterNames.size(); i++) {
            if (nameFreqs.get(i) > 1) {
                System.out.println("The main character is: " + characterNames.get(i) + " with " + nameFreqs.get(i) + " lines of dialog.");
            }
        }
        charactersWithNumParts(10, 15);
    }

    public void charactersWithNumParts (int num1, int num2) {
        for (int i = 0; i < nameFreqs.size(); i++) {
            if (nameFreqs.get(i) >= num1 && nameFreqs.get(i) <= num2) {
                System.out.println(characterNames.get(i));
            }
        }
    }
}

