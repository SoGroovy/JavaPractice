package OCAPrep.Ch3.ArrayList;
/*
When you type the primitive type and Java will automatically convert it to its wrapper class. IE int --> Integer
 */
import OCAPrep.Ch3.CreatingAndManipulatingStrings.Main;

import java.util.ArrayList;
import java.util.List;

public class Autoboxing {
    public static void methodA() {
        List<Integer> ages = new ArrayList<>();
        ages.add(Integer.parseInt("5"));
        ages.add(Integer.valueOf("6"));
        ages.add(7);
//        ages.add(null);
        for (int age : ages) {
            System.out.print(age);
        }
    }
    public static void main (Main[] args) {
        methodA();
    }
}
