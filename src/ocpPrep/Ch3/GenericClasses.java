package ocpPrep.Ch3;

//Generic type T is available anywhere within the class
public class GenericClasses <T>{
    private T contents;
    public T emptyCrate() {
        return contents;
    }

    public void packCrate(T contents){
        this.contents = contents;
    }
}
