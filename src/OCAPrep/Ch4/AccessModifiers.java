package OCAPrep.Ch4;

public class AccessModifiers {
    /*
    Four choices of access modifiers
    public - called from any class
    private - method can only be called within same class
    protected - called from classes in same package or subclasses
    Default (Package Private) Access - only called from classes in same package. *Special case* no keyword; you omit access modifier to declare default access

    Examples:
    public void walk1() {} (compiles)
    default void walk2() {} (does not compile because default is not valid access modifier)
    void public walk3() {} (does not compile because access modifier is declared after return type)
    void walk4() {} (compiles)

     */
}
