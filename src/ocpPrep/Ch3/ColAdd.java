package ocpPrep.Ch3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ColAdd {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(list.add("Sparrow")); //true
        System.out.println(list.add("Sparrow")); //true

        Set<String> set = new HashSet<>();
        System.out.println(set.add("Sparrow")); //true
        System.out.println(set.add("Sparrow")); //false
    }
}
/*
Lists allows duplicates while Sets do not
 */