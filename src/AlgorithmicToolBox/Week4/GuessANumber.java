package AlgorithmicToolBox.Week4;

public class GuessANumber {
    public static void main (String[] args) {
        test();
    }

    public static String query (int y) {
        int x = 1618235;
        if (x == y) {
            return "equal";
        } else if (x < y) {
            return "smaller";
        } else return "greater";
    }

    public static int guess (int lower, int upper) {
        int middle = (lower + upper) / 2;
        String answer = query(middle);
        System.out.println("Is x = " + middle + "? It is " + answer + ".");
        if (answer.equals("equal")) {
            return middle;
        } else if (answer.equals("smaller")) {
            guess(lower, middle - 1);
        } else {
            guess(middle + 1, upper);
        }
        return middle;
    }

    public static void test() {
        guess(1, 2097151);
    }
}
