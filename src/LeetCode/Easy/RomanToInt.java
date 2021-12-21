package LeetCode.Easy;

public class RomanToInt {

    public static void main (String[] args){
        test();
    }

    public static int romanToInt(String s) {
        int result = 0;
        char[] roman = s.toCharArray();

        for (int i = 0; i < roman.length; i++) {
            switch(roman[i]) {
                case 'I':
                    result += 1;
                    break;

                case 'V':
                    result += 5;
                    if (i != 0 && roman[i - 1] == 'I') result -= 2;
                    break;

                case 'X':
                    result += 10;
                    if (i != 0 && roman[i - 1] == 'I') result -= 2;
                    break;

                case 'L':
                    result += 50;
                    if (i != 0 && roman[i - 1] == 'X') result -= 20;
                    break;

                case 'C':
                    result += 100;
                    if (i != 0 && roman[i - 1] == 'X') result -= 20;
                    break;

                case 'D':
                    result += 500;
                    if (i != 0 && roman[i - 1] == 'C') result -= 200;
                    break;

                case 'M':
                    result += 1000;
                    if (i != 0 && roman[i - 1] == 'C') result -= 200;
            }
        }
        return result;
    }

    public static void test() {
        String s = "XLVIII";
        System.out.println(romanToInt(s));
        System.out.println("Expected outcome is: 48");

        String x = "CMXCIX";
        System.out.println(romanToInt(x));
        System.out.println("Expected outcome is: 999");
    }
}
