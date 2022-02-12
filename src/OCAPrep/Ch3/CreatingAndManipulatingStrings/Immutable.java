package OCAPrep.Ch3;
/*
Immutables only have getters.
No way to change the value once it has been set.
Immutable classes are final and subclasses cannot have mutable behavior.
 */
final class Immutable {
    private String s = "name";
    public String getS() {
        return s;
    }
}
