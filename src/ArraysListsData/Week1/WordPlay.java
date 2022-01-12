package ArraysListsData.Week1;

public class WordPlay {
    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        } else {
            return false;
        }

    }

    public void testIsVowel() {
        System.out.println(isVowel('F'));
        System.out.println(isVowel('a'));
    }

    public String replaceVowels(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder();
        phrase = phrase.toLowerCase();
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == 'a' || phrase.charAt(i) == 'e' ||
                    phrase.charAt(i) == 'i' || phrase.charAt(i) == 'o' ||
                    phrase.charAt(i) == 'u') {
                newPhrase.append(ch);
            } else {
                newPhrase.append(phrase.charAt(i));
            }

        }
        return newPhrase.toString();
    }

    public void testReplaceVowels() {
        System.out.println(replaceVowels("Hello World", '*'));
        System.out.println(replaceVowels("Hello World", 'z'));
    }

    public String emphasize(String phrase, char ch) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == Character.toLowerCase(ch) ||
                    phrase.charAt(i) == Character.toUpperCase(ch)) {
                if (i % 2 == 0) {
                    newString.append('+');
                } else {
                    newString.append('*');
                }
            } else {
                newString.append(phrase.charAt(i));
            }
        }
        return newString.toString();
    }

    public void testEmphasize() {
        String x = "Mary Bella Abracadabra";
        System.out.println(emphasize(x, 'a'));
    }
}

