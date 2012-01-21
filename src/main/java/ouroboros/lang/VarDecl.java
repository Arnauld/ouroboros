package ouroboros.lang;

public class VarDecl {

    public static VarDecl varDecl(String name) {
        return new VarDecl(name);
    }
    
    public final String name;

    public VarDecl(String name) {
        super();
        this.name = name;
    }

}
