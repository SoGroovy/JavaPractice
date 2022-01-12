package ArraysListsData.Week1;

public class CaesarCipher {
    public String encrypt (String input, int key) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlpha = alphabet.substring(key) + alphabet.substring(0, key);
        StringBuilder encryptedM = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char currentChar = encryptedM.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currentChar));

            if (idx != -1) {
                char newChar = shiftedAlpha.charAt(idx);
                if(Character.isLowerCase(currentChar)) newChar = Character.toLowerCase(newChar);
                if(Character.isUpperCase(currentChar)) newChar = Character.toUpperCase(newChar);
                encryptedM.setCharAt(i, newChar);
            }
        }
        return encryptedM.toString();
    }

//    public void testEncrypt() {
//        int key = 17;
//        FileResource fr = new FileResource();
//        String message = fr.asString();
//        String encrypted = encrypt(message, key);
//        System.out.println(encrypted);
//        String decrypted = encrypt(encrypted, 26-key);
//        System.out.println(decrypted);
//
//        String message1 = "First Legion";
//        int key1 = 23;
//        String encrypted1 = encrypt(message1, key1);
//        System.out.println(encrypted1);
//        String decrypted1 = encrypt(encrypted1, 26-key1);
//        System.out.println(decrypted1);
//    }

    public String encryptTwoKeys (String input, int key1, int key2) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedA = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedB = alphabet.substring(key2) + alphabet.substring(0, key2);
        StringBuilder newPhrase = new StringBuilder(input);

        for (int i = 0; i < input.length(); i++) {
            char currentChar = newPhrase.charAt(i);
            int currentIndex = alphabet.indexOf(Character.toUpperCase(currentChar));

            if (currentIndex != -1) {
                if (i % 2 == 0){
                    char newChar = shiftedA.charAt(currentIndex);
                    if (Character.isLowerCase(currentChar)) newChar = Character.toLowerCase(shiftedA.charAt(currentIndex));
                    if (Character.isUpperCase(currentChar)) newChar = Character.toUpperCase(shiftedA.charAt(currentIndex));
                    newPhrase.setCharAt(i, newChar);
                } else {
                    char newChar = shiftedB.charAt(currentIndex);
                    if (Character.isLowerCase(currentChar)) newChar = Character.toLowerCase(shiftedB.charAt(currentIndex));
                    if (Character.isUpperCase(currentChar)) newChar = Character.toUpperCase(shiftedB.charAt(currentIndex));
                    newPhrase.setCharAt(i, newChar);
                }
            }
        }
        return newPhrase.toString();
    }

//    public void testEncryptTwoKeys() {
//        int key1 = 23, key2 = 17;
//        FileResource fr = new FileResource();
//        String message = fr.asString();
//        String encrypted = encryptTwoKeys(message, key1, key2);
//        System.out.println(encrypted);
//        String decrypted = encryptTwoKeys(encrypted, 26-key1, 26-key2);
//        System.out.println(decrypted);
//    }
}
