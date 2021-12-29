package ocpPrep.Ch3;

//GenericClasses
//Generic type T is available anywhere within the class
//Naming conventions for generics is UPPERCASE SINGLE letters
public class Crate <T>{
    private T contents;
    public T emptyCrate() {
        return contents;
    }

    public void packCrate(T contents){
        this.contents = contents;
    }
}
