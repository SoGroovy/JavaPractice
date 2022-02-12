package OCAPrep.Ch3.Arrays;

public class ArraysWithRefVariables {
    /*
    //All are legal
    String[] strings = {"String value"};
    Object[] objects = new String[2];                             //objects are broader type than String, no cast necessary
    String[] againStrings = (String[]) objects;             //Since String is more specific, a cast is needed

    //Not legal
    againStrings[0] = new StringBuilder();                  //does not compile; String[] cannot store StringBuilder, only strings
    objects[0] = new StringBuilder();                       //objects is actually a String[], so an ArrayStoreException is thrown
     */
}
