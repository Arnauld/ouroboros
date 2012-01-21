grammar Ouroboros;

options {
  language = Java;
}

tokens {
    PLUS    = '+' ;
    MINUS   = '-' ;
    MULT    = '*' ;
    DIV     = '/' ;
}

@header {
  package ouroboros;
}

@lexer::header {
  package ouroboros;
}

@members{               
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
 
expr    : term ( ( PLUS | MINUS )  term )* 
        | ifExpr
        ;

ifExpr  : 'if' '(' expr ')' '{' 
              expr 
           '}' 
           'else' '{' 
              expr 
           '}'
        ;
 
term    : factor ( ( MULT | DIV ) factor )* ;
 
factor  : NUMBER | ID | funCall ;

funDef  : 'def' ID '(' ID ')' '=' expr ;

funCall : ID '(' args? ')' ;

args    : expr (',' expr)* ;


/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
  
fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT  : '0'..'9' ;
NUMBER  : (DIGIT)+ ;
ID      :       LETTER (LETTER | DIGIT | '_')*;
WS      :       (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
