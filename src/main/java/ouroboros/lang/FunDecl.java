package ouroboros.lang;

public class FunDecl implements Expr {
    
    public static FunDecl funDecl(String name, Expr expr, VarDecl... params) {
        return new FunDecl(name, expr, params);
    }
    
    public final String name;
    public final Expr expr;
    public final VarDecl[] params;

    public FunDecl(String name, Expr expr, VarDecl... params) {
        this.name = name;
        this.expr = expr;
        this.params = params;
    }
    
    public int arity () {
        return params.length;
    }
    
    public void eval(EvalContext context) {
        int stmtId = context.newStmtId();
        context.logEntering("Evaluating Fun<" + name + ">@" + stmtId + " ctx@" + context.id);
        StringBuilder builder = new StringBuilder();
        int len = params.length;
        for(int i=0; i<len; i++) {
            String varName = params[i].name;
            Object pop = context.pop();
            builder.append(varName).append(":").append(pop).append(", ");
            context.log("Fun<" + name + ">@" + stmtId + " parameter: " + varName + " = " + pop);
            context.setVariable(varName, pop);
        }
        context.log("Evaluating Fun<" + name + ">@" + stmtId + ": " + builder);
        expr.eval(context);
        context.logLeaving("Fun<" + name + ">@" + stmtId + " done!");
    }

}
