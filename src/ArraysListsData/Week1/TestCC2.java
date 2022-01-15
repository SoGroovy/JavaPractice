import edu.duke.*;
/**
 * Write a description of TestCaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestCaesarCipherTwo {
    public String halfOfString (String message, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < message.length(); i = i + 2) {
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }

    public int[] countLetters (String input) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] count = new int[26];

        for (int i = 0; i < input.length(); i++) {
            int idx = alpha.indexOf(Character.toUpperCase(input.charAt(i)));
            if (idx != -1) {
                count[idx]++;
            }
        }

        return count;
    }

    public int maxIndex (int[] values) {
        int max = values[0];
        int maxIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if (max < values[i]) {
                max = values[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int getKey (String s) {
        int[] freqs = countLetters(s);
        int maxIdx = maxIndex(freqs);
        int dkey = maxIdx - 4;
        if (maxIdx < 4) {
            dkey = 26 - (4 - maxIdx);
        }
        return dkey;
    }

    public String breakCaesarCipher (String encrypted) {
        CaesarCipher cc1 = new CaesarCipher();
        CaesarCipher cc2 = new CaesarCipher();

        String firstHalf = halfOfString(encrypted, 0);
        String secondHalf = halfOfString(encrypted, 1);

        int firstKey = getKey(firstHalf);
        int secondKey = getKey(secondHalf);

        CaesarCipherTwo cc3 = new CaesarCipherTwo(firstKey, secondKey);
        System.out.println(firstKey + ", " + secondKey);
        return cc3.decrypt(encrypted);
    }

    public void simpleTests () {
        FileResource fr = new FileResource();
        //String message = fr.asString();
        String message = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        CaesarCipherTwo cc = new CaesarCipherTwo(26-14, 26-24);
        message = cc.encrypt(message);
        System.out.println(message);
        System.out.println(cc.decrypt(message));

        String m1 = fr.asString();
        System.out.println(breakCaesarCipher(m1));

    }
}
