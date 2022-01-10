package AlgorithmicToolBox.Week5;

public class FibonacciSequenceDynamic {
    public static void main (String[] args) {
        test();
    }

    public static int FibonacciSequence (int nthTerm) {
        int[] fib = new int[nthTerm];
        fib[0] = 1;
        fib[1] = fib[0];
        for (int i = 2; i < nthTerm; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[nthTerm - 1];
    }

    public static void test() {
        int x = 6;
        System.out.println(FibonacciSequence(x));

        int y = 20;
        System.out.println(FibonacciSequence(y));
    }
}
