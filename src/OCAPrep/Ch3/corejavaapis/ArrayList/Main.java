package OCAPrep.Ch3.ArrayList;
/*
List is an interface and ArrayList implements it.
This is why List cannot be instantiated.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(10);
        ArrayList<String> list3 = new ArrayList<>(list2);
        //ArrayList<String> list1 = new List<>();               //DOES NOT COMPILE

        String[] array = {"hawk", "robin"};
        List<String> list = Arrays.asList(array);
        System.out.println(list.size());
        list.set(1, "test");
        array[0] = "new";
        for (String b : array) System.out.println(b + " ");
//        list.remove(1);                                       //UnsupportedOperation Exception
        //can't change the size of the list because it is fixed, since the list was assigned as a fixed array from String[] array
    }
}
