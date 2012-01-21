package ouroboros.lang;

public class Const implements Expr {
    
    public static final Const C0 = new Const(0);
    public static final Const C1 = new Const(1);
    public static final Const C2 = new Const(2);

    public static Const constant(int value) {
        switch(value) {
            case 0: return C0;
            case 1: return C1;
            case 2: return C2;
        }
        return new Const(value);
    }

    public final int value;
    public Const(int value) {
        this.value = value;
    }
    
    public void eval(EvalContext context) {
        context.logEntering("Evaluating const " + value);
        context.push(value);
        context.logLeaving("Evaluating const " + value);
    }
}
