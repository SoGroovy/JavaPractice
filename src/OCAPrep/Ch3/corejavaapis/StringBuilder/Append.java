package OCAPrep.Ch3.StringBuilder;

public class Append {
    public void methodAppend() {
        //append() - adds a character or string to the end of the StringBuilder
        StringBuilder sb = new StringBuilder("Tin");
        sb.append("+").append(false);
        System.out.println(sb);
    }
}
