package AlgorithmicToolBox.Week4;

public class BinarySearch1 {
    public static void main(String[] args) {
        test();
    }

    public static int binarySearch (int[] a, int target, int l, int r) {

        if (a.length == 0) return -1;
        int mid = l + ((r - l) / 2);
        if (r < l) {
            return -1;
        }

        if (a[mid] == target) {
            System.out.println("Found!");
            System.out.println(mid);
            return mid;
        } else if (a[mid] < target) return binarySearch(a, target, mid + 1, r);

        else return binarySearch(a, target, l, mid - 1);

    }

    public static void test() {
        int[] a = {1, 2, 3, 3, 5, 6, 6, 8, 9, 9, 9};
        binarySearch(a, 8, 0, 10);
    }
}
