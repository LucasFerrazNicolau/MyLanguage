grammar MyLang;

@header {
	import datastructures.MyLangSymbol;
	import datastructures.MyLangVariable;
	import datastructures.MyLangSymbolTable;
	import exceptions.MyLangSemanticException;
	import ast.MyLangProgram;
	import ast.AbstractCommand;
	import ast.CommandLeitura;
	import ast.CommandEscrita;
	import ast.CommandAtribuicao;
	import ast.CommandSelecao;
	import ast.CommandRepeticao;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members {
	private int _tipo;
	private String _varName;
	private String _varValue;
	private MyLangSymbolTable symbolTable = new MyLangSymbolTable();
	private MyLangSymbol symbol;
	private MyLangProgram program = new MyLangProgram();
	private ArrayList<AbstractCommand> currentThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _exprSelection;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	private String _exprRepetition;
	private ArrayList<AbstractCommand> listaWhile;
	
	public void verificaID(String id) {
		if (!symbolTable.exists(id)) {
			throw new MyLangSemanticException("Symbol " + id + " not declared");
		}
	}
	
	public void marcaVariavelUsada(String id) {
		if (symbolTable.exists(id)) {
			MyLangSymbol symbol = symbolTable.get(id);
			if (symbol instanceof MyLangVariable) {
				MyLangVariable _var = (MyLangVariable)symbol;
				_var.setUsed(true);
			}
		}
	}
	
	public void verificaVarType(String id, int type) {
		String typeName;
		
		switch (type) {
			case MyLangVariable.NUMBER:
				typeName = "NUMBER";
				break;
			case MyLangVariable.TEXT:
				typeName = "TEXT";
				break;
			default:
				typeName = "INDEFINED TYPE";
		}
		
		if (symbolTable.exists(id)) {
			MyLangSymbol symbol = symbolTable.get(id);
			if (symbol instanceof MyLangVariable) {
				MyLangVariable _var = (MyLangVariable)symbol;
				if (_var.getType() != type) {
					throw new MyLangSemanticException("Symbol " + id + " is not " + typeName + " type but is treated as " + typeName);
				}
			}
		}
	}
	
	public void exibeComandos() {
		for (AbstractCommand c : program.getComandos()) {
			System.out.println(c);
		}
	}
	
	public void generateCode() {
		program.generateTarget();
	}
	
	public void verificaVariaveisUtilizadas() {
		for (MyLangSymbol symbol : symbolTable.getAll()) {
			if (symbol instanceof MyLangVariable) {
				MyLangVariable _var = (MyLangVariable)symbol;
				if (!_var.isUsed()) {
					System.out.println("Warning - Symbol " + _var.getName() + " declared but not used");
				}
			}
		}
	}
}

prog	: 'programa' decl bloco 'fimprograma'
		{
			program.setVarTable(symbolTable);
			program.setComandos(stack.pop());
		}
		;

decl	: (declaravar)+
		;

declaravar	: tipo ID
			{
				_varName = _input.LT(-1).getText();
				_varValue = null;
				symbol = new MyLangVariable(_varName, _tipo, _varValue);
				if (!symbolTable.exists(_varName)) {
					symbolTable.add(symbol);
				} else {
					throw new MyLangSemanticException("Symbol " + _varName + " already declared");
				}
			}
			(VIR ID
			{
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

bloco	:
		{
			currentThread = new ArrayList<AbstractCommand>();
			stack.push(currentThread);
		}
		(comando)+
		;

comando	: cmdleitura | cmdescrita | cmdattrib | cmdselecao | cmdrepeticao
		;

cmdleitura	: 'leia' AP ID
			{
				verificaID(_input.LT(-1).getText());
				_readID = _input.LT(-1).getText();
			}
			FP SC
			{
				MyLangVariable var = (MyLangVariable)symbolTable.get(_readID);
				CommandLeitura cmd = new CommandLeitura(_readID, var);
				stack.peek().add(cmd);
			}
			;

cmdescrita	: 'escreva' AP ID
			{
				verificaID(_input.LT(-1).getText());
				marcaVariavelUsada(_input.LT(-1).getText());
				_writeID = _input.LT(-1).getText();
			}
			FP SC
			{
				CommandEscrita cmd = new CommandEscrita(_writeID);
				stack.peek().add(cmd);
			}
			;

cmdattrib	: ID
			{
				verificaID(_input.LT(-1).getText());
				_exprID = _input.LT(-1).getText();
			}
			ATTR
			{
				_exprContent = "";
			}
			expr SC
			{
				CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
				stack.peek().add(cmd);
			}
			;

cmdselecao	: 'se' AP
			( ID
			{
				verificaID(_input.LT(-1).getText());
				marcaVariavelUsada(_input.LT(-1).getText());
			}
			| NUMBER | TEXT ) { _exprSelection = _input.LT(-1).getText(); }
			OPREL { _exprSelection += _input.LT(-1).getText(); }
			( ID
			{
				verificaID(_input.LT(-1).getText());
				marcaVariavelUsada(_input.LT(-1).getText());
			}
			| NUMBER | TEXT ) { _exprSelection += _input.LT(-1).getText(); }
			FP ACH
			{
				currentThread = new ArrayList<AbstractCommand>();
				stack.push(currentThread);
			}
			(comando)+
			FCH
			{
				listaTrue = stack.pop();
			}
			( 'senao'
				ACH
				{
					currentThread = new ArrayList<AbstractCommand>();
					stack.push(currentThread);
				}
				(comando)+
				FCH
				{
					listaFalse = stack.pop();
					CommandSelecao cmd = new CommandSelecao(_exprSelection, listaTrue, listaFalse);
					stack.peek().add(cmd);
				}
			)?
			;

cmdrepeticao	: 'enquanto' AP
				( ID
				{
					verificaID(_input.LT(-1).getText());
					marcaVariavelUsada(_input.LT(-1).getText());
				}
				| NUMBER | TEXT ) { _exprRepetition = _input.LT(-1).getText(); }
				OPREL { _exprRepetition += _input.LT(-1).getText(); }
				( ID
				{
					verificaID(_input.LT(-1).getText());
					marcaVariavelUsada(_input.LT(-1).getText());
				}
				| NUMBER | TEXT ) { _exprRepetition += _input.LT(-1).getText(); }
				FP ACH
				{
					currentThread = new ArrayList<AbstractCommand>();
					stack.push(currentThread);
				}
				(comando)+
				FCH
				{
					listaWhile = stack.pop();
					CommandRepeticao cmd = new CommandRepeticao(_exprRepetition, listaWhile);
					stack.peek().add(cmd);
				}
				;

expr	: termo ( OP
		{
			_exprContent += _input.LT(-1).getText();
		}
		termo )*
		;

termo	: ID
		{
			verificaID(_input.LT(-1).getText());
			marcaVariavelUsada(_input.LT(-1).getText());
			_exprContent += _input.LT(-1).getText();
		}
		| NUMBER
		{
			_exprContent += _input.LT(-1).getText();
			verificaVarType(_exprID, MyLangVariable.NUMBER);
		}
		| TEXT
		{
			_exprContent += _input.LT(-1).getText();
			verificaVarType(_exprID, MyLangVariable.TEXT);
		}
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

ACH	: '{'
	;

FCH	: '}'
	;

OPREL	: '>' | '<' | '>=' | '<=' | '==' | '!='
		;

ID	: [a-z] ( [a-z] | [A-Z] | [0-9] )*
	;

NUMBER	: [0-9]+ ('.' [0-9]+)?
	;

TEXT	: '"' (.)*? '"'
		;

WS	: ( ' ' | '\t' | '\n' | '\r' ) -> skip
	;