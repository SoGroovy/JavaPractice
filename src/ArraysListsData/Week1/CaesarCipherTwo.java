import edu.duke.*;
/**
 * Write a description of CaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet;
    private String shiftedAlphabet2;
    private int mainKey1, mainKey2;
    public CaesarCipherTwo (int key1, int key2) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }

    public String halfOfString(String message, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < message.length(); i = i + 2) {
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }

    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        String inputEven = halfOfString(input, 0);
        String inputOdd = halfOfString(input, 1);
        OOCaesarCipher ccEven = new OOCaesarCipher(mainKey1);
        OOCaesarCipher ccOdd = new OOCaesarCipher(mainKey2);
        String outputEven = ccEven.encrypt(inputEven);
        String outputOdd = ccOdd.encrypt(inputOdd);


        for (int k = 0; k < (inputEven.length()); k++) {
            encrypted.setCharAt((2 * k), outputEven.charAt(k));
        }

        for (int k = 0; k < (inputOdd.length()); k++) {
            encrypted.setCharAt((2 * k) + 1, outputOdd.charAt(k));
        }
        return encrypted.toString();
    }

    public String decrypt(String input) {
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
        return cc.encrypt(input);
    }


}