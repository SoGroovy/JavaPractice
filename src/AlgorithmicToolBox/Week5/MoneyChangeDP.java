package AlgorithmicToolBox.Week5;

import java.util.Arrays;
import java.util.Scanner;

public class MoneyChangeDP {
    private static int getChange(int m) {
        int[] coins = {1, 3, 4};
        int[] minCoins = new int[m + 1];
        int numCoins = 0;
        Arrays.fill(minCoins, m + 1);
        minCoins[0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    numCoins = minCoins[i - coins[j]] + 1;
                    minCoins[i] = Math.min(minCoins[i], numCoins);
                }
            }
        }
        return minCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
