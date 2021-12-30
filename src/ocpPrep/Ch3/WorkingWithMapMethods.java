package ocpPrep.Ch3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WorkingWithMapMethods {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String food = map.get("koala");             //bamboo
        for (String key: map.keySet()) {
            System.out.println(key + ",");          //koala, giraffe, lion
        }

        Map<String, String> mapT = new TreeMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String foodT = map.get("koala");             //bamboo
        for (String key: map.keySet()) {
            System.out.println(key + ",");          //giraffe, koala, lion
        }

//        System.out.println(map.contains("lion"));       //DOES NOT COMPILE because contains isn't a method in map interface, but works in Collections
        System.out.println(map.containsKey("lion"));      //true
        System.out.println(map.containsValue("lion"));    //false
        System.out.println(map.size());                   //3
    }
}
