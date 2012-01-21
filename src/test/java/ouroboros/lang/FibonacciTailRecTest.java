package ouroboros.lang;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ouroboros.lang.Comp.equal;
import static ouroboros.lang.Const.constant;
import static ouroboros.lang.FunCall.funCall;
import static ouroboros.lang.Moins.moins;
import static ouroboros.lang.Plus.plus;
import static ouroboros.lang.VarCall.varCall;
import static ouroboros.lang.VarDecl.varDecl;

import org.junit.Before;
import org.junit.Test;

public class FibonacciTailRecTest {
    private static final Const C_1 = constant(1);
    private static final Const C_0 = constant(0);
    //
    private static final String Current   = "c";
    private static final String Next      = "n";
    private static final String Remaining = "r";
    private static final String FIB = "fib";
    //
    private FunDecl fibonacci;
    
    @Before
    public void setup () {
        Expr fibonacciExpr = new If(//
                equal(varCall(Remaining), C_0),//
                varCall(Current),//
                funCall(FIB, 
                        varCall(Next), 
                        plus(varCall(Next), varCall(Current)), 
                        moins(varCall(Remaining), C_1)));
        fibonacci = new FunDecl(FIB, fibonacciExpr, varDecl(Current), varDecl(Next), varDecl(Remaining));
    }
    
    @Test
    public void fib_0() {
        EvalContext context = new EvalContext();
        context.declareFunction(FIB, fibonacci);
        context.push(0);
        context.push(1);
        context.push(0);
        fibonacci.eval(context);
        assertThat((Integer)context.pop(), equalTo(0));
    }
    
    @Test
    public void fib_1() {
        EvalContext context = new EvalContext();
        context.declareFunction(FIB, fibonacci);
        context.push(1);
        context.push(1);
        context.push(0);
        fibonacci.eval(context);
        assertThat((Integer)context.pop(), equalTo(1));
    }
    
    @Test
    public void fib_2() {
        parametrizedFib(2, 1);
    }
    
    @Test
    public void fib_x() {
        parametrizedFib(3, 2);
        parametrizedFib(4, 3);
        parametrizedFib(5, 5);
        parametrizedFib(6, 8);
    }
    
    @Test
    public void fib_15() {
        parametrizedFib(15, 610);
        System.out.println(EvalContext.maxDepth);
    }
    
    private void parametrizedFib(int n, int expected) {
        EvalContext context = new EvalContext();
        context.declareFunction(FIB, fibonacci);
        context.push(n);
        context.push(1);
        context.push(0);
        fibonacci.eval(context);
        assertThat((Integer)context.pop(), equalTo(expected));
    }
    
}
