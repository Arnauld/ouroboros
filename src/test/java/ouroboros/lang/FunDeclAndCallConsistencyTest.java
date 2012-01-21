package ouroboros.lang;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ouroboros.lang.VarDecl.varDecl;

import org.junit.Before;
import org.junit.Test;

public class FunDeclAndCallConsistencyTest {
    private static final String FUN = "f";
    private static final String X = "x";
    private static final String Y = "y";
    private static final String Z = "z";
    
    //
    private Expr expr;
    //
    private static final Const C0 = Const.C0;
    private static final Const C1 = Const.C1;
    private static final Const C2 = Const.C2;
    
    //
    private EvalContext context;
    
    @Before
    public void setUp () {
        context = new EvalContext();
    }
    
    @Test
    public void parameters_are_pushed_in_order () {
        expr = new Expr () {
            public void eval(EvalContext context) {
                assertThat(context.getVariable(X), equalTo(o(0)));
                assertThat(context.getVariable(Y), equalTo(o(1)));
                assertThat(context.getVariable(Z), equalTo(o(2)));
            }
        };
        
        FunDecl decl = new FunDecl(FUN, expr, varDecl(X), varDecl(Y), varDecl(Z));
        context.declareFunction(FUN, decl);
        
        FunCall call = new FunCall(FUN, C0, C1, C2);
        call.eval(context);
    }
    
    public static Object o(Object o) {
        return o;
    }
}
