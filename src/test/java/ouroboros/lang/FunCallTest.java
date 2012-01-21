package ouroboros.lang;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class FunCallTest {
    private static final String FUN = "f";
    private static final Const C0 = Const.C0;
    private static final Const C1 = Const.C1;
    private static final Const C2 = Const.C2;
    
    //
    private EvalContext context;
    private FunDecl funDecl;
    
    @Before
    public void setUp () {
        context = new EvalContext();
        funDecl = mock(FunDecl.class);
    }
    
    @Test
    public void parameters_are_pushed_in_order () {
        // FunDecl: varDecl(X), varDecl(Y), varDecl(Z)
        context.declareFunction(FUN, funDecl);
        when(funDecl.arity()).thenReturn(3);
        
        FunCall call = new FunCall(FUN, C0, C1, C2);
        call.eval(context);
        assertThat(context.getStack(), equalTo(Arrays.<Object>asList(2, 1, 0)));
        assertThat(context.popInteger(), equalTo(0));
        assertThat(context.popInteger(), equalTo(1));
        assertThat(context.popInteger(), equalTo(2));
    }
}
