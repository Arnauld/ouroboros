package ouroboros.lang;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class EvalContext {
    private static AtomicInteger idGen = new AtomicInteger();
    
    private final Map<String, Object> variables = new HashMap<String, Object>();
    private final Map<String, FunDecl> funDecls = new HashMap<String, FunDecl>();
    private final Stack<Object> stack;
    private final EvalContext parent;
    public boolean debug = true;
    public final int id;
    
    public EvalContext() {
        this(null, new Stack<Object>());
    }
    
    public EvalContext(EvalContext parent, Stack<Object> stack) {
        this.parent = parent;
        this.stack = stack;
        this.id    = idGen.incrementAndGet();
        checkDepth(this);
    }
    
    public static int maxDepth = 0;
    private static void checkDepth(EvalContext evalContext) {
        int depth = evalContext.depth();
        if(depth>maxDepth)
            maxDepth = depth;
    }
    
    public int depth() {
        EvalContext p = this;
        int depth = 0;
        while(p!=null) {
            depth++;
            p = p.parent;
        }
        return depth;
    }

    public boolean isDebug() {
        return debug;
    }

    public Object pop() {
        Object pop = stack.pop();
        log("[E]Popped from stack: " + pop);
        return pop;
    }

    public void push(Object o) {
        log("[E]Pushed into stack: " + o);
        stack.push(o);
        log("[E]Stack: " + stack);
    }
    
    public Object getVariable(String name) {
        if(variables.containsKey(name)) {
            return variables.get(name);
        }
        else if(parent!=null) {
            return parent.getVariable(name);
        }
        else
            throw new RuntimeException("Variable <" + name + "> undefined");
    }
    
    public void setVariable(String name, Object value) {
        log("[E]Variable defined <" + name + "> with value <" + value + ">");
        if(variables.containsKey(name))
            throw new RuntimeException("Variable <" + name + "> already defined in current context");
        variables.put(name, value);
    }

    public void declareFunction(String name, FunDecl funDecl) {
        if(funDecls.containsKey(name)) {
            throw new RuntimeException("Function <" + name + "> already defined current context");
        }
        funDecls.put(name, funDecl);
    }

    public FunDecl lookupFunc(String name, int len) {
        FunDecl funDecl = funDecls.get(name);
        if(funDecl==null) {
            if(parent!=null) {
                return parent.lookupFunc(name, len);
            }
            else {
                throw new RuntimeException("Function <" + name + "> undefined");
            }
        }
        return funDecl;
    }
    
    public void invokeFunc(String name, int len) {
        FunDecl funDecl = lookupFunc(name, len);
        if(funDecl.arity() != len)
            throw new RuntimeException("Wrong arity expected: " + funDecl.arity() + ", got: " + len);
        EvalContext subContext = subContext();
        log("...>>InvokeFunc(" + name + ") depth: " + subContext.depth() + " // " + id + "@" + subContext.id);
        funDecl.eval(subContext);
        log("...<<InvokeFunc(" + name + ") depth: " + subContext.depth() + " // " + id + "@" + subContext.id);
        subContext.release();
    }

    public void release() {
        funDecls.clear();
        variables.clear();
    }

    public EvalContext subContext() {
        EvalContext sub = new EvalContext(this, stack);
        sub.indent = indent;
        return sub;
    }

    public Boolean popBoolean() {
        return (Boolean)stack.pop();
    }
    
    public Integer popInteger() {
        return (Integer)stack.pop();
    }

    public boolean isStackEmpty() {
        return stack.isEmpty();
    }
    
    public Stack<Object> getStack() {
        return stack;
    }

    private AtomicInteger indent = new AtomicInteger();
    public void logEntering(String message) {
        if(debug) {
            int i = indent.getAndIncrement();
            System.out.println(indent(i) + ">" + message);
        }
    }
    
    public void logLeaving(String message) {
        if(debug) {
            int i = indent.decrementAndGet();
            System.out.println(indent(i) + "<" + message);
        }
    }
    
    public void log(String message) {
        if(debug) {
            int i = indent.get();
            System.out.println(indent(i) + message);
        }
    }

    private static String indent(int n) {
        StringBuilder b = new StringBuilder ();
        for(int i=0;i<n;i++) {
            b.append("  ");
        }
        return b.toString();
    }

    private static AtomicInteger stmtIdGen = new AtomicInteger();
    public int newStmtId () {
        return stmtIdGen.incrementAndGet();
    }
}
