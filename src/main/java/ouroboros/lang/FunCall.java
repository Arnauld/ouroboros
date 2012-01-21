package ouroboros.lang;

public class FunCall implements Expr  {
    public static FunCall funCall(String name, Expr...params) {
        return new FunCall(name, params);
    }
    
    public final String name;
    public final Expr[] params;

    public FunCall(String name, Expr...params) {
        this.name = name;
        this.params = params;
    }
    
    public void eval(EvalContext context) {
        int stmtId = context.newStmtId();
        context.logEntering("Calling function <" + name + ">@" + stmtId + " ctx@" + context.id);
        int len = params.length;
        for(int i=len-1; i>=0; i--) {
            params[i].eval(context);
        }
        context.invokeFunc(name, len);
        context.logLeaving("FunCall<" + name + ">@" + stmtId + " done!");
    }
}
