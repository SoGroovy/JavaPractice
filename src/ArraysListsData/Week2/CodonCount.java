package ArraysListsData.Week2;

import edu.duke.*;
import java.util.*;

public class CodonCount {
    private HashMap<String, Integer> dnaCodons;
    public CodonCount () {
        dnaCodons = new HashMap<String, Integer>();

    }

    public void buildCodonMap (int start, String dna) {
        for (int i = start; i < dna.length() - 3; i = i + 3) {
            String currentCodon = dna.substring(i, i + 3);
            if (!dnaCodons.containsKey(currentCodon)) {
                dnaCodons.put(currentCodon, 1);
            } else {
                dnaCodons.put(currentCodon, dnaCodons.get(currentCodon) + 1);
            }
        }
    }

    public String getMostCommonCodon() {
        String mostCommonCodon = "";
        int currentOccurence = Integer.MIN_VALUE;
        for (String element : dnaCodons.keySet()) {
            int currentCodonO = dnaCodons.get(element);
            if (currentOccurence < currentCodonO) {
                currentOccurence = currentCodonO;
                mostCommonCodon = element;
            }
        }
        return mostCommonCodon;
    }

    public void printCodonCounts (int start, int end) {
        for (String element : dnaCodons.keySet()) {
            if (dnaCodons.get(element) >= start && dnaCodons.get(element) <= end) {
                System.out.println(element + "\t" + dnaCodons.get(element));
            }
        }
    }

    public void test () {
        FileResource fr = new FileResource();
        String dnaStrand = fr.asString();
        dnaStrand = dnaStrand.toUpperCase();
        for (int i = 0; i <= 2; i ++) {
            buildCodonMap(i, dnaStrand);
            System.out.println("Reading frame starting with " + i + " results in " + dnaCodons.size() + " unique codons");
            String mostCommon = getMostCommonCodon();
            System.out.println("and most common codon is " + mostCommon + " with count " + dnaCodons.get(mostCommon));
            System.out.println("Counts of codons between 1 and 5 inclusive are: ");
            printCodonCounts(1,5);
        }
    }
}
