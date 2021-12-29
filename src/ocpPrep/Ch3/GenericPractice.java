package ocpPrep.Ch3;

import java.util.ArrayList;
import java.util.List;

public class GenericPractice {
    static void printNames(List list) {
        for (int i = 0; i < list.size(); i++) {
            String name = (String) list.get(i); // class cast exception here
            System.out.println(name);
        }
    }

    public static void main (String[] args){
//        List names = new ArrayList();
        List<String> names = new ArrayList<String>(); //error StringBuilder cannot be converted to String
//        names.add(new StringBuilder("Webby"));
        names.add(new String("Webby"));
        printNames(names);
    }


}
