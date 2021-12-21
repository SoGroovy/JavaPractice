package LeetCode.Easy;

public class TwoSum {

    public static void main(String[] args) {
        test();
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }

    public static void test() {
        int[] x = {2, 7, 11, 15};
        System.out.println(arrayToStr(twoSum(x, 26)));
        System.out.println("Expected outcome is: [0, 1]");

        int[] y = {3, 2, 3};
        System.out.println(arrayToStr(twoSum(y, 6)));
        System.out.println("Expected outcome is: [0, 2]");
    }
//TODO: Using StringBuilder (OCA Ch. 3)
    public static String arrayToStr (int[] s) {
        String array = "[";
        for (int i = 0; i < s.length - 1; i++) {
            array = array + s[i] + ", ";
        }
        array = array + s[s.length - 1] + "]";
        return array;
    }
}
