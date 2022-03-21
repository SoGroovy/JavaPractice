package OCAPrep.Ch4;

public class WorkingWithVarargs {
    /*
    Internally, the Varargs method is implemented by using the single dimensions arrays concept.
    Hence, in the Varrargs method, we can differentiate arguments by using Index. A variable-length argument is specified by three periods or dots(...).

    This syntax tells the compiler that fun( ) can be called with zero or more arguments.
    As a result, here, a is implicitly declared as an array of type int[].
    This also means that Varargs uses array indexing.

    Vararg parameters have to be last in the declaration of parameters; this also implies there can only be one vararg parameter per method.
     */

    /*
    public static void walk(int start, int... nums) {
        System.out.println(nums.length);
    }
    public static void main(String[] args) {
        walk(1);                        //0, only start is initialized
        walk(1, 2);                     //1, one parameter for nums
        walk(1, 2, 3);                  //2, two parameter for nums
        walk(1, new int[] {4, 5});      //2, two parameters for nums; different format, but legal
    }
     */

    // A method that takes variable
    // number of integer arguments.
    static void fun(int... a)
    {
        System.out.println("Number of arguments: "
                + a.length);

        // using for each loop to display contents of a
        for (int i : a)
            System.out.print(i + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[])
    {
        // Calling the varargs method with
        // different number of parameters

        // one parameter
        fun(100);

        // four parameters
        fun(1, 2, 3, 4);

        // no parameter
        fun();
    }


}
