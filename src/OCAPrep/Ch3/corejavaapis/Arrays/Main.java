package OCAPrep.Ch3.Arrays;
/*
Arrays do not physically store data content, rather it stores the reference point of where the data can be located
 */
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        //Examples of array declaration
        int[] ids, types;               //declares two int arrays: ids and types.
        ids = new int[2];
        types = new int[3];
        int incNumber = 2;
        for (int i = 0; i < ids.length; i++) {
            ids[i] = incNumber;
            incNumber++;
        }
        System.out.println(ids);                        //prints the type of object and the hashcode(where the data of the array is stored) rather than the contents
        System.out.println(Arrays.toString(ids));       //Java has a built-in method that prints arrays nicely

        int abc[], type;        //declares an int[] abc and declares an int variable type

        String[] birds = new String[6];
        System.out.println(birds.length);
    }
}
