package ouroboros;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

public class SimpleParserTest {
    public static void main(String[] args) throws Exception {
        OuroborosLexer lex = new OuroborosLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);
 
        OuroborosParser parser = new OuroborosParser(tokens);
 
        try {
            parser.expr();
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
    }
}
