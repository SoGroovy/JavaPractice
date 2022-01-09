package AlgoBook.Chapter1;

public class SumRecursive {
    public static void main (String[] args) {
        int result = sum(10);
        System.out.println(result);

        int[] arr = randomArray(10, 100);
        displayArray(arr);
        System.out.println(findBiggestElement(arr));
        System.out.println(findBiggestElementRecursive(arr));
    }

    public static int sum (int k) {
        if(k > 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }

    public static int[] randomArray (int size, int topLimit) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * topLimit) + 1;
        }
        return arr;
    }

    public static void displayArray(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++){
            if (i == a.length - 1) {
                System.out.print(a[i]);
            } else {
                System.out.print(a[i] + ",");
            }
        }
        System.out.println("]");
    }

    public static int findBiggestElement(int[] a) {
        int currentMax = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > currentMax) {
                currentMax = a[i];
            }
        }
        return currentMax;
    }

    public static int findBiggestElement(int[] a, int left, int right) {
        if (left != right) {
            int mid = (left + right) / 2;
            int x = findBiggestElement(a, left, mid);
            int y = findBiggestElement(a, mid + 1, right);
            return Math.max(x, y);
        } else {
            return a[left];
        }
    }

    public static int findBiggestElementRecursive(int[] a) {
        return findBiggestElement(a, 0, a.length - 1);
    }
}
