package ocpPrep.Ch3;

//Crate class can deal with Elephant without knowing anything about it
public class Elephant {
    Elephant elephant = new Elephant();
    Crate<Elephant> crateForElephant = new Crate<>();
    crateForElephant.packCrate(elephant);
    Elephant inNewHome = crateForElephant.emptyCrate();

    Crate<Zebra> crateForZebra = new Crate<>();
}
