package ouroboros.lang;

public class Plus implements Expr {

    public static Plus plus(Expr left, Expr right) {
        return new Plus(left, right);
    }
    
    public final Expr left;
    public final Expr right;
    public Plus(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }
    
    public void eval(EvalContext context) {
        right.eval(context);
        Integer rightV = (Integer)context.pop();
        left.eval(context);
        Integer leftV = (Integer)context.pop();
        context.push(leftV + rightV);
    }
    
}
