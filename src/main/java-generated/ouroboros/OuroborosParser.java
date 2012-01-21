// $ANTLR 3.4 ouroboros/Ouroboros.g 2012-01-21 18:29:11

  package ouroboros;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class OuroborosParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "DIV", "ID", "LETTER", "MINUS", "MULT", "NUMBER", "PLUS", "WS", "'('", "')'", "','", "'='", "'def'"
    };

    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int DIGIT=4;
    public static final int DIV=5;
    public static final int ID=6;
    public static final int LETTER=7;
    public static final int MINUS=8;
    public static final int MULT=9;
    public static final int NUMBER=10;
    public static final int PLUS=11;
    public static final int WS=12;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public OuroborosParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public OuroborosParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return OuroborosParser.tokenNames; }
    public String getGrammarFileName() { return "ouroboros/Ouroboros.g"; }

                   



    // $ANTLR start "expr"
    // ouroboros/Ouroboros.g:29:1: expr : term ( ( PLUS | MINUS ) term )* ;
    public final void expr() throws RecognitionException {
        try {
            // ouroboros/Ouroboros.g:29:9: ( term ( ( PLUS | MINUS ) term )* )
            // ouroboros/Ouroboros.g:29:11: term ( ( PLUS | MINUS ) term )*
            {
            pushFollow(FOLLOW_term_in_expr116);
            term();

            state._fsp--;


            // ouroboros/Ouroboros.g:29:16: ( ( PLUS | MINUS ) term )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case MINUS:
                case PLUS:
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // ouroboros/Ouroboros.g:29:18: ( PLUS | MINUS ) term
            	    {
            	    if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_term_in_expr131);
            	    term();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "expr"



    // $ANTLR start "term"
    // ouroboros/Ouroboros.g:31:1: term : factor ( ( MULT | DIV ) factor )* ;
    public final void term() throws RecognitionException {
        try {
            // ouroboros/Ouroboros.g:31:9: ( factor ( ( MULT | DIV ) factor )* )
            // ouroboros/Ouroboros.g:31:11: factor ( ( MULT | DIV ) factor )*
            {
            pushFollow(FOLLOW_factor_in_term147);
            factor();

            state._fsp--;


            // ouroboros/Ouroboros.g:31:18: ( ( MULT | DIV ) factor )*
            loop2:
            do {
                int alt2=2;
                switch ( input.LA(1) ) {
                case DIV:
                case MULT:
                    {
                    alt2=1;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // ouroboros/Ouroboros.g:31:20: ( MULT | DIV ) factor
            	    {
            	    if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_factor_in_term161);
            	    factor();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "term"



    // $ANTLR start "factor"
    // ouroboros/Ouroboros.g:33:1: factor : ( NUMBER | ID | funCall );
    public final void factor() throws RecognitionException {
        try {
            // ouroboros/Ouroboros.g:33:9: ( NUMBER | ID | funCall )
            int alt3=3;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt3=1;
                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case 13:
                    {
                    alt3=3;
                    }
                    break;
                case EOF:
                case DIV:
                case MINUS:
                case MULT:
                case PLUS:
                case 14:
                case 15:
                    {
                    alt3=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;

                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // ouroboros/Ouroboros.g:33:11: NUMBER
                    {
                    match(input,NUMBER,FOLLOW_NUMBER_in_factor175); 

                    }
                    break;
                case 2 :
                    // ouroboros/Ouroboros.g:33:20: ID
                    {
                    match(input,ID,FOLLOW_ID_in_factor179); 

                    }
                    break;
                case 3 :
                    // ouroboros/Ouroboros.g:33:25: funCall
                    {
                    pushFollow(FOLLOW_funCall_in_factor183);
                    funCall();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "factor"



    // $ANTLR start "funDef"
    // ouroboros/Ouroboros.g:35:1: funDef : 'def' ID '(' ID ')' '=' expr ;
    public final void funDef() throws RecognitionException {
        try {
            // ouroboros/Ouroboros.g:35:9: ( 'def' ID '(' ID ')' '=' expr )
            // ouroboros/Ouroboros.g:35:11: 'def' ID '(' ID ')' '=' expr
            {
            match(input,17,FOLLOW_17_in_funDef193); 

            match(input,ID,FOLLOW_ID_in_funDef195); 

            match(input,13,FOLLOW_13_in_funDef197); 

            match(input,ID,FOLLOW_ID_in_funDef199); 

            match(input,14,FOLLOW_14_in_funDef201); 

            match(input,16,FOLLOW_16_in_funDef203); 

            pushFollow(FOLLOW_expr_in_funDef205);
            expr();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "funDef"



    // $ANTLR start "funCall"
    // ouroboros/Ouroboros.g:37:1: funCall : ID '(' ( args )? ')' ;
    public final void funCall() throws RecognitionException {
        try {
            // ouroboros/Ouroboros.g:37:9: ( ID '(' ( args )? ')' )
            // ouroboros/Ouroboros.g:37:11: ID '(' ( args )? ')'
            {
            match(input,ID,FOLLOW_ID_in_funCall214); 

            match(input,13,FOLLOW_13_in_funCall216); 

            // ouroboros/Ouroboros.g:37:18: ( args )?
            int alt4=2;
            switch ( input.LA(1) ) {
                case ID:
                case NUMBER:
                    {
                    alt4=1;
                    }
                    break;
            }

            switch (alt4) {
                case 1 :
                    // ouroboros/Ouroboros.g:37:18: args
                    {
                    pushFollow(FOLLOW_args_in_funCall218);
                    args();

                    state._fsp--;


                    }
                    break;

            }


            match(input,14,FOLLOW_14_in_funCall221); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "funCall"



    // $ANTLR start "args"
    // ouroboros/Ouroboros.g:39:1: args : expr ( ',' expr )* ;
    public final void args() throws RecognitionException {
        try {
            // ouroboros/Ouroboros.g:39:9: ( expr ( ',' expr )* )
            // ouroboros/Ouroboros.g:39:11: expr ( ',' expr )*
            {
            pushFollow(FOLLOW_expr_in_args233);
            expr();

            state._fsp--;


            // ouroboros/Ouroboros.g:39:16: ( ',' expr )*
            loop5:
            do {
                int alt5=2;
                switch ( input.LA(1) ) {
                case 15:
                    {
                    alt5=1;
                    }
                    break;

                }

                switch (alt5) {
            	case 1 :
            	    // ouroboros/Ouroboros.g:39:17: ',' expr
            	    {
            	    match(input,15,FOLLOW_15_in_args236); 

            	    pushFollow(FOLLOW_expr_in_args238);
            	    expr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "args"

    // Delegated rules


 

    public static final BitSet FOLLOW_term_in_expr116 = new BitSet(new long[]{0x0000000000000902L});
    public static final BitSet FOLLOW_set_in_expr120 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_term_in_expr131 = new BitSet(new long[]{0x0000000000000902L});
    public static final BitSet FOLLOW_factor_in_term147 = new BitSet(new long[]{0x0000000000000222L});
    public static final BitSet FOLLOW_set_in_term151 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_factor_in_term161 = new BitSet(new long[]{0x0000000000000222L});
    public static final BitSet FOLLOW_NUMBER_in_factor175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_factor179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funCall_in_factor183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_funDef193 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_funDef195 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_funDef197 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_funDef199 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_funDef201 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_funDef203 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_expr_in_funDef205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_funCall214 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_funCall216 = new BitSet(new long[]{0x0000000000004440L});
    public static final BitSet FOLLOW_args_in_funCall218 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_funCall221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_args233 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_args236 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_expr_in_args238 = new BitSet(new long[]{0x0000000000008002L});

}