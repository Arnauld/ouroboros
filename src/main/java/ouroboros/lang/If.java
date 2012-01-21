package ouroboros.lang;


public class If implements Expr {

    public final Expr predicate;
    public final Expr consequent;
    public final Expr alternative;
    public If(Expr predicate, Expr consequent, Expr alternative) {
        super();
        this.predicate = predicate;
        this.consequent = consequent;
        this.alternative = alternative;
    }
    
    public void eval(EvalContext context) {
        int stmtId = context.newStmtId();
        context.logEntering("Evaluating If@"+stmtId + " ctx@" + context.id);
        predicate.eval(context);
        boolean value = context.popBoolean();
        context.log("If@"+stmtId + " - Predicate: " + value);
        if(value) {
            context.log("If@"+stmtId + " - consequent");
            consequent.eval(context);
        }
        else {
            context.log("If@"+stmtId + " - alternative");
            alternative.eval(context);
        }
        context.logLeaving("If@"+stmtId + " - done!");
    }
}
