package LeetCode.Easy;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsoMorphicStrings {
    public static void main(String[] args) {
        testisIsomorphic();
        testisIsomorphic1();
        testisIsomorphic2();
        testisIsomorphic3();
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charMapF = new HashMap<>();
        Map<Character, Character> charMapB = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charMapF.put(s.charAt(i), t.charAt(i));
            charMapB.put(t.charAt(i), s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            if (charMapF.get(s.charAt(i)) != t.charAt(i) || charMapB.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void testisIsomorphic() {
        String s = "egg";
        String t = "add";
        System.out.println("Actual: " + isIsomorphic(s, t));
        System.out.println("Expected: true");
    }

    public static void testisIsomorphic1() {
        String s = "foo";
        String t = "bar";
        System.out.println("Actual: " + isIsomorphic(s, t));
        System.out.println("Expected: false");
    }

    public static void testisIsomorphic2() {
        String s = "paper";
        String t = "title";
        System.out.println("Actual: " + isIsomorphic(s, t));
        System.out.println("Expected: true");
    }

    public static void testisIsomorphic3() {
        String s = "babc";
        String t = "baba";
        System.out.println("Actual: " + isIsomorphic(s, t));
        System.out.println("Expected: false");
    }
}