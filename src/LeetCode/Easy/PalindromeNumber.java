package LeetCode.Easy;

public class PalindromeNumber {

    public static void main (String[] args) {
        test();
    }

    public static boolean isPalindrome(int x) {

        int temp = x;
        int r = 0;
        int sum = 0;
        while (temp > 0) {
            r = temp % 10;
            sum = (sum * 10) + r;
            temp = temp / 10;
        }
        return x == sum;
    }

    public static void test() {
        int x = 121;
        System.out.println(isPalindrome(x));
        System.out.println("Expected outcome is: true");
    }
}
