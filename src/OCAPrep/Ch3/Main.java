package OCAPrep.Ch3;
/*
What is a String? A sequence of characters
String is a class, but very special. It does not require new to initialize it.
They are immutable; this means that you cannot change it. The string cannot be large or smaller. It is fixed.
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

