package LeetCode.Easy;

public class LengthOfLastWord {

    public static void main (String[] args){
        test();
    }

    public static int lengthOfLastWord(String s) {
        int count = 0;

        if (s.length() == 0) return 0;
        int currLength = s.length() - 1;

        while (currLength > 0){
            if (s.charAt(currLength) != ' ') {
                break;
            }
            currLength--;
        }

        for (int i = currLength; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }

    public static void test() {
        String s = "Hello World";
        System.out.println("Actual outcome is: " + lengthOfLastWord(s));
        System.out.println("Expected outcome is: 5");

        String b = " fly me   to the moon   ";
        System.out.println("Actual outcome is: " + lengthOfLastWord(b));
        System.out.println("Expected outcome is: 4");
    }
}
