package ouroboros.lang;

public class Comp implements Expr {
    enum Op {
        Greater,
        GreaterOrEqual,
        Equal,
        Lower,
        LowerOrEqual
    }
    
    public static Comp comp(Expr left, Op operator, Expr right) {
        return new Comp(left, operator, right);
    }
    
    public static Comp equal(Expr left, Expr right) {
        return new Comp(left, Op.Equal, right);
    }
    
    public final Expr left;
    public final Expr right;
    public final Op operator;
    public Comp(Expr left, Op operator, Expr right) {
        super();
        this.left = left;
        this.right = right;
        this.operator = operator;
    }
    
    @SuppressWarnings("unchecked")
    public void eval(EvalContext context) {
        context.logEntering("Comparaison " + operator);
        
        right.eval(context);
        Object rightB = context.pop();
        context.log("Evaluating right operand: " + rightB);
        //
        left.eval(context);
        Object leftB = context.pop();
        context.log("Evaluating left operand: " + rightB);
        //
        int val = ((Comparable<Object>)leftB).compareTo(rightB);
        boolean res;
        if(val==0) {
            res = operator==Op.GreaterOrEqual || operator==Op.Equal || operator==Op.LowerOrEqual;
        }
        else if(val>0) {
            res = operator==Op.GreaterOrEqual || operator==Op.Greater;
        }
        else {
            res = operator==Op.LowerOrEqual || operator==Op.Lower;
        }
        context.push(res);
        context.logLeaving("Comparaison " + operator +" res: " + res);
    }
}
