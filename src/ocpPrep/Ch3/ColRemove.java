package ocpPrep.Ch3;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.valueOf;

public class ColRemove {
    public static void main(String[] args) {
        List<String> birds = new ArrayList<>();
        birds.add("hawk");                               //[hawk]
        birds.add("hawk");                               //[hawk, hawk]
        System.out.println(birds.remove("cardinal")); //prints false
        System.out.println(birds.remove("hawk"));     //prints true
        System.out.println(birds);                       //[hawk]
//        System.out.println(birds.remove(100));     //throws IndexOutOfBounds exception

        List<Integer> numbers = new ArrayList<>();
        numbers.add(100);                               //[100]
        numbers.add(50);                                //[100, 50]
        System.out.println(numbers.remove(valueOf(100)));     //[50]
       //System.out.println(numbers.remove(new Integer(100))); also does the same thing as line 22
    }
}

/*
remove() on Line 15 looks for an index not number literal
To remove a specific integer element, we need to use "new Integer()" or valueOf()
 */