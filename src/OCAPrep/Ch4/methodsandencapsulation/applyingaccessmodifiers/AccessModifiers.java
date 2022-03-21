package OCAPrep.Ch4;

public class AccessModifiers {
    /*
    Four choices of access modifiers (from least to most restrictive)
    public - called from any class
    protected - called from classes in same package or subclasses in another package
    Default (Package Private) Access - only called from classes in same package. *Special case* no keyword; you omit access modifier to declare default access
    private - method can only be called within same class



    Examples:
    public void walk1() {} (compiles)
    default void walk2() {} (does not compile because default is not valid access modifier)
    void public walk3() {} (does not compile because access modifier is declared after return type)
    void walk4() {} (compiles)

     */
}
