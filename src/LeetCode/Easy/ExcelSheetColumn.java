package LeetCode.Easy;

public class ExcelSheetColumn {
    public static void main(String[] args){
        test();
    }
      int x = 'A';
    public static String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return "Not a valid number!";
        }
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            int r = columnNumber % 26;
            if(r == 0) {
                columnNumber = columnNumber / 26 - 1;
                r += 26;
            } else {
                columnNumber = columnNumber / 26;
            }
            char ch = (char) (r + 'A' - 1);
            sb.append(ch);
        }
        sb.reverse();
        return sb.toString();
    }

    public static void test() {

        int x = 1;
        System.out.println("The string is: " + convertToTitle(x));
        System.out.println("    Expected string: A");
         x = 26;
        System.out.println("The string is: " + convertToTitle(x));
        System.out.println("    Expected string: Z");

        x = 28;
        System.out.println("The string is: " + convertToTitle(x));
        System.out.println("    Expected string: AB");

        x = 701;
        System.out.println("The string is: " + convertToTitle(x));
        System.out.println("    Expected string: ZY");
    }
}
