package OCAPrep.Ch3;

import java.util.Locale;

/*
What is a String? A sequence of characters
String is a class, but very special. It does not require new to initialize it.
They are immutable; this means that you cannot change it. The string cannot be large or smaller. It is fixed.
***********RULES*********
1) If both operands are numeric, + means numeric addition; - means numeric subtraction, etc
2) If either operand is a String, + means concatenation
3) The expression is evaluated left to right.

String pool aka intern pool is located in the JVM (collects all strings). It contains literal values (synthetic representation of string, boolean, numeric data)
myObject.toString() goes into garbage collection, not string pool.

 */
public class Main {
    public static void main(String[] args) {
        //Examples of concatenation
        Concatenation c = new Concatenation();
        c.methodA();
        //Ex. 2
        int three = 3;
        String four = "4";
        System.out.println(1 + 2 + three + four);
        //Ex. 3
        String s = "1";
        s += "2";
        s += 3;
        System.out.println(s);

        //Showing how immutability works
        String s1 = "1";
        String s2 = s1.concat("2");
        s2.concat("3");
        System.out.println(s2);             //returns 12 because String is immutable

        //What goes into string pool
        String name1 = "Fluffy";                        //goes into string pool
        String name2 = new String("Fluffy");    //this is allowed, this line tells the java to create a new String object

        //String methods:
        //length() - returns the number of characters in String
        System.out.println("Tin".length());

        //charAt() - finds what character is at a specific index
        String string = "animals";
        System.out.println(string.charAt(0));
        System.out.println(string.charAt(6));
//        System.out.println(string.charAt(7));       //throws exception; length of string is only 6

        /*indexOf() - looks for character/s in string and finds the first index that matches the value
        first parameter is the desired value to be found, the second parameter tells the method what index to start from
        Method signatures:
        1) int indexOf(char ch)
        2) int indexOf(char ch, index fromIndex)
        3) int indexOf(String str)
        4) int indexOf(String str, index fromIndex)
         */

        String string2 = "animals";
        System.out.println(string.indexOf('a'));
        System.out.println(string.indexOf("al"));
        System.out.println(string.indexOf('a', 4));
        System.out.println(string.indexOf("al", 5));            //returns -1, because it couldn't find valid index

        /*substring() - looks for characters in a string and returns parts of string
        if there is no end index, then it will start with the beginning index and go until the end of string
        Method signatures:
        1) int substring(int beginIndex)
        2) int substring(int beginIndex, int endIndex)
         */

        String string3 = "father";
        System.out.println(string3.substring(3));
        System.out.println(string3.substring(string3.indexOf('t')));
        System.out.println(string3.substring(3, 4));
        System.out.println(string3.substring(3, 5));
        System.out.println(string3.substring(3, 3));            //returns empty string

//        System.out.println(string3.substring(3, 2));            //throws exception; Java knows if you start from three, you will never go to 2
//        System.out.println(string3.substring(3, 7));            //throws exception; out of bounds

        /*toLowerCase(); toUpperCase() - change all characters to lower case and upper case respectively
        This does not affect original string
        Method signatures:
        1) String toLowerCase(String str)
        2) String toUpperCase(String str)
         */

        System.out.println("ABCDEF".toLowerCase());
        System.out.println("abcdef".toUpperCase());
    }


}

