package OCAPrep.Ch4;

public class ProtectedAccess {
    /*
    Protected access allows everything that default access allows and also can be called from subclasses

    package pond.shore;
    public class Bird {
        protected String text = "floating"; // protected access
        protected void floatInWater() { // protected access
        System.out.println(text);
        }
    }
**Next we create a subclass:
    package pond.goose;
    import pond.shore.Bird; // in a different package
    public class Gosling extends Bird { // extends means create subclass
        public void swim() {
            floatInWater(); // calling protected member
            System.out.println(text); // calling protected member
        }
     }
     */
}
