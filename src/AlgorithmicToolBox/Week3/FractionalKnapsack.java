package AlgorithmicToolBox.Week3;

import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
//        double maxLoot = 0.0;
//        int m = 0;
//        List<Integer> valuesL = new ArrayList<Integer>(values.length);
//        for (int i: values){
//            valuesL.add(values[i]);
//        }
//
//        List<Integer> weightsL = new ArrayList<Integer>(weights.length);
//        for (int i: weights){
//            weightsL.add(weights[i]);
//        }
//        //creating return condition where there is no capacity or there are no items
//        if (capacity == 0 || weights.length == 0) return 0.0;
//        for (int i = 1; i < weights.length; i++) {
//            if(values[i]/weights[i] > values[m] / weights[m]) {
//                m = 1;
//            }
//        }
//        int amount = Math.min(weightsL.get(m), capacity);
//        maxLoot = ((double)valuesL.get(m) * amount) / weightsL.get(m);
//
//        valuesL.remove(m);
//        weightsL.remove(m);
//        capacity -= amount;
//
//        return maxLoot + getOptimalValue(capacity, values, weights);
//    }
        ItemValue[] iVal = new ItemValue[weights.length];

        for (int i = 0; i < weights.length; i++) {
            iVal[i] = new ItemValue(weights[i], values[i], i);
        }

        // sorting items by value;
        Arrays.sort(iVal, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });

        double totalValue = 0d;

        for (ItemValue i : iVal) {

            int curWt = (int) i.wt;
            int curVal = (int) i.val;

            if (capacity - curWt >= 0) {
                // this weight can be picked while
                capacity = capacity - curWt;
                totalValue += curVal;
            } else {
                // item cant be picked whole
                double fraction
                        = ((double) capacity / (double) curWt);
                totalValue += (curVal * fraction);
                capacity
                        = (int) (capacity - (curWt * fraction));
                break;
            }
        }

        return totalValue;
    }

    // item value class
    static class ItemValue {
        Double cost;
        double wt, val, ind;

        // item value function
        public ItemValue(int wt, int val, int ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = new Double((double) val / (double) wt);
        }
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
