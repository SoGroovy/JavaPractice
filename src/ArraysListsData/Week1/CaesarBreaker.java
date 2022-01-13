package ArraysListsData.Week1;

public class CaesarBreaker {
    public int[] countLetters(String message) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] count = new int[26];

        for (int i = 0; i < message.length(); i++) {
            int currentLetter = Character.toLowerCase(message.charAt(i));
            int currentIndex = alpha.indexOf(currentLetter);
            if (currentIndex != -1) count[currentIndex]++;
        }
        return count;
    }

    public int maxIndex(int[] values) {
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

    public String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int key = getKey(encrypted);
        return cc.encrypt(encrypted, 26 - key);
    }

    public void testDecrypt() {
        FileResource resource = new FileResource("data/smallHamlet.txt");
        String message = resource.asString();

        CaesarCipher cc = new CaesarCipher();
        String encrypted = cc.encrypt(message, 20);
        String decrypted = decrypt(encrypted);
        System.out.println(encrypted + "    " + decrypted);
    }

    public void testCountLetters() {
        FileResource fr = new FileResource("data/smallHamlet.txt");
        String message = fr.asString();
        int[] counts = countLetters(message);

        System.out.println("The most common letter is " + maxIndex(counts));
    }

    public String halfOfString(String message, int start) {
        StringBuilder newMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i = i + 2) {
            newMessage.append(message.charAt(i));
        }
        return newMessage.toString();
    }

    public void testHalfOfString() {
        FileResource fr = new FileResource("data/smallhamlet.txt");
        String message = fr.asString();

        System.out.println(halfOfString(message, 0));
    }

    public int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }

    public String decryptTwoKeys(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        StringBuilder theMessage = new StringBuilder(encrypted);

        String firstHalf = halfOfString(encrypted, 0);
        String secondHalf = halfOfString(encrypted, 1);
        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);
        String dFirstHalf = cc.encrypt(firstHalf, 26 - key1);
        String dSecondHalf = cc.encrypt(secondHalf, 26 - key2);

        for (int i = 0; i < (firstHalf.length()); i++) {
            theMessage.setCharAt((2 * i), dFirstHalf.charAt(i));
        }

        for (int i = 0; i < secondHalf.length(); i++) {
            theMessage.setCharAt((2 * i) + 1, dSecondHalf.charAt(i));
        }
        System.out.println(key1 + "     " + key2 + "    " + theMessage.toString());
        return theMessage.toString();
    }
}