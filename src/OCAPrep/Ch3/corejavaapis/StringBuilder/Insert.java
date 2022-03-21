package OCAPrep.Ch3.StringBuilder;

//insert() - adds characters to StringBuilder at requested index
public class Insert {
    public void methodInsert(){
        StringBuilder sb = new StringBuilder("animals");
        sb.insert(0, "-");
        sb.insert(4, "+");
        System.out.println(sb);
    }
}
