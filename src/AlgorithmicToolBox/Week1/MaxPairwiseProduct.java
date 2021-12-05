package AlgorithmicToolBox.Week1;



import java.util.Arrays;
import java.util.Scanner;

/*public class MaxPairwiseProduct {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input size of the array");
        System.out.print("n = ");
        int n = scanner.nextInt();
        long[] arr = new long[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = scanner.nextInt();
//        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (long)Math.floor(Math.random() * (100 * n));
        }

        long time0 = System.nanoTime();
        long result1 = calculateMaxPair1(arr);
        long time1 = System.nanoTime();
        System.out.println("Processing Time 1: " + (time1 - time0));

        time1 = System.nanoTime();
        long result2 = calculateMaxPair2(arr);
        long time2 = System.nanoTime();
        System.out.println("Processing Time 2: " + (time2 - time1));

        System.out.println(result1 + " : " + result2);
    }

    public static long calculateMaxPair1(long[] arr) {
        long findMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > findMax) {
                secondMax = findMax;
                findMax = arr[i];

            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        return findMax * secondMax;
    }

    public static long calculateMaxPair2(long[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1] * arr[arr.length - 2];
    }
}*/

public class MaxPairwiseProduct{
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int lengthOfArray = scanner.nextInt();
        long arr[] = new long [lengthOfArray];

        for (int i = 0; i < arr.length; i++){
            arr[i] = scanner.nextInt();
        }
        long result = calculateMaxPair(arr);
        System.out.println(result);

    }

    public static long calculateMaxPair (long[] arr){
        long max = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        return (max * secondMax);
    }
}