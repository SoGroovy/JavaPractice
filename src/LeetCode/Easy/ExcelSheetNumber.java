package LeetCode.Easy;

public class ExcelSheetNumber {
    public static void main(String[] args) {
        test();
    }

    public static int titleToNumber(String columnTitle) {
        int result = 0;
        double n = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--){
            int ch = ((columnTitle.charAt(i) - 'A' + 1) * ((int) Math.pow(26, n)));
            n++;
            result += ch;
        }
        return result;
    }

    public static void test(){
        String str = "A";
        int actual = titleToNumber(str);
        int expected = 1;
        System.out.println("Actual: " + actual);
        System.out.println("Expected: " + expected);
        if (actual == expected) {
            System.out.println("    Accepted");
        } else {
            System.out.println("    Failed");
        }

        str = "Z";
        actual = titleToNumber(str);
        expected = 26;
        System.out.println("Actual: " + actual);
        System.out.println("Expected: " + expected);
        if (actual == expected) {
            System.out.println("    Accepted");
        } else {
            System.out.println("    Failed");
        }

        str = "AA";
        actual = titleToNumber(str);
        expected = 27;
        System.out.println("Actual: " + actual);
        System.out.println("Expected: " + expected);
        if (actual == expected) {
            System.out.println("    Accepted");
        } else {
            System.out.println("    Failed");
        }

        str = "ZY";
        actual = titleToNumber(str);
        expected = 701;
        System.out.println("Actual: " + actual);
        System.out.println("Expected: " + expected);
        if (actual == expected) {
            System.out.println("    Accepted");
        } else {
            System.out.println("    Failed");
        }

        str = "FXSHRXW";
        actual = titleToNumber(str);
        expected = 2147483647;
        System.out.println("Actual: " + actual);
        System.out.println("Expected: " + expected);
        if (actual == expected) {
            System.out.println("    Accepted");
        } else {
            System.out.println("    Failed");
        }


    }
}
