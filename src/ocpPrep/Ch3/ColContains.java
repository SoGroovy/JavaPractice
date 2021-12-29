package ocpPrep.Ch3;

import java.util.ArrayList;
import java.util.List;

public class ColContains {
    public static void main(String[] args) {
        List<String> birds = new ArrayList<>();
        birds.add("hawk");
        System.out.println(birds.contains("hawk"));             //true
        System.out.println(birds.contains("robin"));            //false
    }
}
