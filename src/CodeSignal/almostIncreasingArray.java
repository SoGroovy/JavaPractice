package CodeSignal;
//Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing sequence
// by removing no more than one element from the array.
//
//Note: sequence a0, a1, ..., an is considered to be a strictly increasing if a0 < a1 < ... < an. Sequence containing
// only one element is also considered to be strictly increasing.

public class almostIncreasingArray {

    public static void main(String[] args) {
        test();
    }

    public static boolean solution(int[] sequence) {
        int count1 = 0, count2 = 0;
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] >= sequence[i + 1]) count1++;
        }

        for (int i = 0; i < sequence.length - 2; i++) {
            if (sequence[i] >= sequence[i + 2]) count2++;
        }
        return (count1 <= 1) && (count2 <= 1);
    }

    public static void test() {
        int[] a = {1, 3, 2, 1};
        System.out.println(solution(a));
        System.out.println("Expected outcome is: false");

        int[] b = {10, 1, 2, 3, 4, 5};
        System.out.println(solution(b));
        System.out.println("Expected outcome is: true");
    }
}

