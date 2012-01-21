package ouroboros.lang;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ConstTest {

    private EvalContext context;
    
    @Before
    public void setUp () {
        context = new EvalContext();
    }

    @Test
    public void eval() {
        Const c = new Const(4);
        c.eval(context);
        assertThat(context.popInteger(), equalTo(4));
        assertThat(context.isStackEmpty(), is(true));
    }
}
