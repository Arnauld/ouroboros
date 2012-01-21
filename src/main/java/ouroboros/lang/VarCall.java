package ouroboros.lang;

public class VarCall implements Expr {
    public static VarCall varCall(String name) {
        return new VarCall(name);
    }
    
    public final String name;

    public VarCall(String name) {
        super();
        this.name = name;
    }
    
    public void eval(EvalContext context) {
        Object variable = context.getVariable(name);
        context.push(variable);
    }
}
