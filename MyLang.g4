grammar MyLang;

prog	: 'programa' decl bloco 'fimprograma'
		;

decl	: (declaravar)+
		;

declaravar	: tipo ID (VIR ID)* SC
			;

tipo	: 'numero' | 'texto'
		;

bloco	: (comando)+
		;

comando	: cmdleitura | cmdescrita | cmdattrib
		;

cmdleitura	: 'leia' AP ID FP SC
			;

cmdescrita	: 'escreva' AP ID FP SC
			;

cmdattrib	: ID ATTR expr SC
			;

expr	: termo ( OP termo )*
		;

termo	: ID | NUMBER
		;

AP	: '('
	;

FP	: ')'
	;

SC	: ';'
	;

OP	: '+' | '-' | '*' | '/'
	;

ATTR	: '='
	;

VIR	: ','
	;

ID	: [a-z] ( [a-z] | [A-Z] | [0-9] )*
	;

NUMBER	: [0-9]+ ('.' [0-9]+)?
	;

WS	: ( ' ' | '\t' | '\n' | '\r' ) -> skip
	;