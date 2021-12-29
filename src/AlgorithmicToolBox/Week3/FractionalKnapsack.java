package AlgorithmicToolBox.Week3;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double maxLoot = 0.0;
        int m = 0;
        List<Integer> valuesL = new ArrayList<Integer>(values.length);
        for (int i = 0; i < values.length; i++){
            valuesL.add(values[i]);
        }

        List<Integer> weightsL = new ArrayList<Integer>(weights.length);
        for (int i = 0; i < weights.length; i++){
            weightsL.add(weights[i]);
        }
        //creating return condition where there is no capacity or there are no items
        if (capacity == 0 || weightsL.size() == 0) return 0.0;
        while (capacity > 0) {
            for (int i = 1; i < weightsL.size(); i++) {
                if(valuesL.get(i) * weightsL.get(m) > valuesL.get(m) * weightsL.get(i)) {
                    m = i;
                }
            }
            int amount = Math.min(weightsL.get(m), capacity);
            maxLoot = maxLoot + ((double)valuesL.get(m) * amount) / weightsL.get(m);

            valuesL.remove(m);
            weightsL.remove(m);
            capacity -= amount;
            m = 0;
        }

        return maxLoot;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
