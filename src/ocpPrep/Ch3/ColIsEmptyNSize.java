package ocpPrep.Ch3;

import java.util.ArrayList;
import java.util.List;

public class ColIsEmptyNSize {
    public static void main(String[] args){
        List<String> birds = new ArrayList<>();
        System.out.println(birds.isEmpty());            //prints true
        System.out.println(birds.size());               //0
        birds.add("hawk");                              //[hawk]
        birds.add("hawk");                              //[hawk, hawk]
        System.out.println(birds.isEmpty());            //prints false
        System.out.println(birds.size());               //2
    }
}
