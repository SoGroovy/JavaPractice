package OCAPrep.Ch3;
/*
What is a String? A sequence of characters
String is a class, but very special. It does not require new to initialize it.
They are immutable; this means that you cannot change it. The string cannot be large or smaller. It is fixed.
***********RULES*********
1) If both operands are numeric, + means numeric addition; - means numeric subtraction, etc
2) If either operand is a String, + means concatenation
3) The expression is evaluated left to right.
 */
public class Main {
    public static void main(String[] args) {
        Concatenation c = new Concatenation();
        c.methodA();

        int three = 3;
        String four = "4";
        System.out.println(1 + 2 + three + four);

        String s = "1";
        s += "2";
        s += 3;
        System.out.println(s);
    }


}

