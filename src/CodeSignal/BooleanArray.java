package CodeSignal;
//12/20/2021
public class BooleanArray {

    public static void main (String[] args) {
        test();
    }

    public static boolean[] tOrF(int[] a, int l, int r) {

        boolean[] b = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            int x = a[i] / (i + 1);
            b[i] = (x >= l && x <= r && a[i] % (i + 1) == 0);
        }
        return b;
    }

    public static void test() {
        int[] a = {8, 5, 6, 16, 5};
        int l = 1;
        int r = 3;
        boolean[] b = tOrF(a, l, r);
        for (boolean element : b) {

            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("Expected outcome is: [false false true false true]");
    }

}
