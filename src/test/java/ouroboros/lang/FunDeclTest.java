package ouroboros.lang;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ouroboros.lang.VarDecl.varDecl;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class FunDeclTest {
    
    private static final String FUN = "f";
    private static final String X = "x";
    private static final String Y = "y";
    private static final String Z = "z";
    
    //
    private Expr expr;
    private EvalContext context;
    
    @Before
    public void setUp () {
        expr = Mockito.mock(Expr.class);
        context = new EvalContext();
    }
    
    @Test
    public void parameters_are_popped_in_order () {
        FunDecl decl = new FunDecl(FUN, expr, varDecl(X), varDecl(Y), varDecl(Z));
        context.declareFunction(FUN, decl);
        context.push(0);
        context.push(1);
        context.push(2);
        assertThat(context.getStack(), equalTo(Arrays.<Object>asList(0, 1, 2)));
        decl.eval(context);
        assertThat(context.getVariable(X), equalTo((Object)2)); //pop()-> x
        assertThat(context.getVariable(Y), equalTo((Object)1)); //pop()-> y
        assertThat(context.getVariable(Z), equalTo((Object)0)); //pop()-> z
    }
}
