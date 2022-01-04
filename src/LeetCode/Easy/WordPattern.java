package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> mapP = new HashMap<>();
        Map<String, Character> mapS = new HashMap<>();
        String[] values = s.split(" ");
        if (pattern.length() != values.length) {
            return false;
        }

        for (int j = 0; j < pattern.length(); j++) {
            mapP.put(pattern.charAt(j), values[j]);
            mapS.put(values[j], pattern.charAt(j));
        }

        for (int k = 0; k < pattern.length(); k++) {
            if (!mapP.get(pattern.charAt(k)).equals(values[k]) || !mapS.get(values[k]).equals(pattern.charAt(k))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
}
