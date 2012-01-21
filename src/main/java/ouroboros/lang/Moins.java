package ouroboros.lang;

public class Moins implements Expr {

    public static Moins moins(Expr left, Expr right) {
        return new Moins(left, right);
    }
    
    public final Expr left;
    public final Expr right;
    public Moins(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }
    
    public void eval(EvalContext context) {
        int stmtId = context.newStmtId();
        context.logEntering("Calling Minus@" + stmtId);
        right.eval(context);
        Integer rightV = (Integer)context.pop();
        left.eval(context);
        Integer leftV = (Integer)context.pop();
        int res = leftV - rightV;
        context.log("Calling Minus@" + stmtId + " // " + res + "=" + leftV + " - " +  rightV);
        context.push(res);
        context.logLeaving("Calling Minus@" + stmtId + " res: " + res);
    }
    
}
