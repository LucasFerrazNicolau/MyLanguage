grammar MyLang;

@header {
	import datastructures.MyLangSymbol;
	import datastructures.MyLangVariable;
	import datastructures.MyLangSymbolTable;
	import exceptions.MyLangSemanticException;
	import java.util.ArrayList;
}

@members {
	private int _tipo;
	private String _varName;
	private String _varValue;
	private MyLangSymbolTable symbolTable = new MyLangSymbolTable();
	private MyLangSymbol symbol;
	
	public void verificaID(String id) {
		if (!symbolTable.exists(id)) {
			throw new MyLangSemanticException("Symbol " + id + " not declared");
		}
	}
}

prog	: 'programa' decl bloco 'fimprograma'
		;

decl	: (declaravar)+
		;

declaravar	: tipo ID {
						_varName = _input.LT(-1).getText();
						_varValue = null;
						symbol = new MyLangVariable(_varName, _tipo, _varValue);
						if (!symbolTable.exists(_varName)) {
							symbolTable.add(symbol);
						} else {
							throw new MyLangSemanticException("Symbol " + _varName + " already declared");
						}
					}
				(VIR ID {
							_varName = _input.LT(-1).getText();
							_varValue = null;
							symbol = new MyLangVariable(_varName, _tipo, _varValue);
							if (!symbolTable.exists(_varName)) {
								symbolTable.add(symbol);
							} else {
								throw new MyLangSemanticException("Symbol " + _varName + " already declared");
							}
						}
				)* SC
			;

tipo	: 'numero' { _tipo = MyLangVariable.NUMBER; }
		| 'texto' { _tipo = MyLangVariable.TEXT; }
		;

bloco	: (comando)+
		;

comando	: cmdleitura | cmdescrita | cmdattrib
		;

cmdleitura	: 'leia' AP ID { verificaID(_input.LT(-1).getText()); }
				FP SC
			;

cmdescrita	: 'escreva' AP ID { verificaID(_input.LT(-1).getText()); }
				FP SC
			;

cmdattrib	: ID { verificaID(_input.LT(-1).getText()); }
				ATTR expr SC
			;

expr	: termo ( OP termo )*
		;

termo	: ID { verificaID(_input.LT(-1).getText()); }
		| NUMBER
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