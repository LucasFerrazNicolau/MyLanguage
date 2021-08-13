// Generated from ../MyLang.g4 by ANTLR 4.9.2
package parser;

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
	import ast.CommandPara;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, AP=15, FP=16, SC=17, 
		OP=18, ATTR=19, VIR=20, ACH=21, FCH=22, OPREL=23, INTEGER=24, NUMBER=25, 
		TEXT=26, BOOLEAN=27, ID=28, WS=29;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_comando = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_cmdrepeticao = 10, RULE_cmdpara = 11, RULE_expr = 12, 
		RULE_termo = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "declaravar", "tipo", "bloco", "comando", "cmdleitura", 
			"cmdescrita", "cmdattrib", "cmdselecao", "cmdrepeticao", "cmdpara", "expr", 
			"termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprograma'", "'numero'", "'texto'", "'logico'", 
			"'inteiro'", "'leia'", "'escreva'", "'se'", "'senao'", "'enquanto'", 
			"'para'", "'de'", "'ate'", "'('", "')'", "';'", null, "'='", "','", "'{'", 
			"'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "AP", "FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", 
			"OPREL", "INTEGER", "NUMBER", "TEXT", "BOOLEAN", "ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MyLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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
		private String _forID;
		private String _initialIndex;
		private String _finalIndex;
		private ArrayList<AbstractCommand> listaFor;
		
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
				case MyLangVariable.BOOLEAN:
					typeName = "BOOLEAN";
					break;
				case MyLangVariable.INTEGER:
					typeName = "INTEGER";
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

	public MyLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			decl();
			setState(30);
			bloco();
			setState(31);
			match(T__1);

						program.setVarTable(symbolTable);
						program.setComandos(stack.pop());
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				declaravar();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(MyLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MyLangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(MyLangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(MyLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(MyLangParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			tipo();
			setState(40);
			match(ID);

							_varName = _input.LT(-1).getText();
							_varValue = null;
							symbol = new MyLangVariable(_varName, _tipo, _varValue);
							if (!symbolTable.exists(_varName)) {
								symbolTable.add(symbol);
							} else {
								throw new MyLangSemanticException("Symbol " + _varName + " already declared");
							}
						
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(42);
				match(VIR);
				setState(43);
				match(ID);

								_varName = _input.LT(-1).getText();
								_varValue = null;
								symbol = new MyLangVariable(_varName, _tipo, _varValue);
								if (!symbolTable.exists(_varName)) {
									symbolTable.add(symbol);
								} else {
									throw new MyLangSemanticException("Symbol " + _varName + " already declared");
								}
							
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(T__2);
				 _tipo = MyLangVariable.NUMBER; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(T__3);
				 _tipo = MyLangVariable.TEXT; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				match(T__4);
				 _tipo = MyLangVariable.BOOLEAN; 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(58);
				match(T__5);
				 _tipo = MyLangVariable.INTEGER; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

						currentThread = new ArrayList<AbstractCommand>();
						stack.push(currentThread);
					
			setState(64); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(63);
				comando();
				}
				}
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdrepeticaoContext cmdrepeticao() {
			return getRuleContext(CmdrepeticaoContext.class,0);
		}
		public CmdparaContext cmdpara() {
			return getRuleContext(CmdparaContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_comando);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				cmdleitura();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				cmdattrib();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				cmdselecao();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				cmdrepeticao();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 6);
				{
				setState(73);
				cmdpara();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MyLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(MyLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(MyLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(MyLangParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__6);
			setState(77);
			match(AP);
			setState(78);
			match(ID);

							verificaID(_input.LT(-1).getText());
							_readID = _input.LT(-1).getText();
						
			setState(80);
			match(FP);
			setState(81);
			match(SC);

							MyLangVariable var = (MyLangVariable)symbolTable.get(_readID);
							CommandLeitura cmd = new CommandLeitura(_readID, var);
							stack.peek().add(cmd);
						
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MyLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(MyLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(MyLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(MyLangParser.SC, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__7);
			setState(85);
			match(AP);
			setState(86);
			match(ID);

							verificaID(_input.LT(-1).getText());
							marcaVariavelUsada(_input.LT(-1).getText());
							_writeID = _input.LT(-1).getText();
						
			setState(88);
			match(FP);
			setState(89);
			match(SC);

							CommandEscrita cmd = new CommandEscrita(_writeID);
							stack.peek().add(cmd);
						
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MyLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(MyLangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(MyLangParser.SC, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(ID);

							verificaID(_input.LT(-1).getText());
							_exprID = _input.LT(-1).getText();
						
			setState(94);
			match(ATTR);

							_exprContent = "";
						
			setState(96);
			expr();
			setState(97);
			match(SC);

							CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
							stack.peek().add(cmd);
						
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MyLangParser.AP, 0); }
		public TerminalNode OPREL() { return getToken(MyLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(MyLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(MyLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(MyLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(MyLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(MyLangParser.FCH, i);
		}
		public List<TerminalNode> ID() { return getTokens(MyLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MyLangParser.ID, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(MyLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(MyLangParser.NUMBER, i);
		}
		public List<TerminalNode> TEXT() { return getTokens(MyLangParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(MyLangParser.TEXT, i);
		}
		public List<TerminalNode> BOOLEAN() { return getTokens(MyLangParser.BOOLEAN); }
		public TerminalNode BOOLEAN(int i) {
			return getToken(MyLangParser.BOOLEAN, i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__8);
			setState(101);
			match(AP);
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(102);
				match(ID);

								verificaID(_input.LT(-1).getText());
								marcaVariavelUsada(_input.LT(-1).getText());
							
				}
				break;
			case NUMBER:
				{
				setState(104);
				match(NUMBER);
				 _exprSelection = _input.LT(-1).getText(); 
				}
				break;
			case TEXT:
				{
				setState(106);
				match(TEXT);
				 _exprSelection = _input.LT(-1).getText(); 
				}
				break;
			case BOOLEAN:
				{
				setState(108);
				match(BOOLEAN);
				 _exprSelection = (_input.LT(-1).getText().equals("verdadeiro") ? "true" : "false"); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(112);
			match(OPREL);
			 _exprSelection += _input.LT(-1).getText(); 
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(114);
				match(ID);

								verificaID(_input.LT(-1).getText());
								marcaVariavelUsada(_input.LT(-1).getText());
							
				}
				break;
			case NUMBER:
				{
				setState(116);
				match(NUMBER);
				 _exprSelection = _input.LT(-1).getText(); 
				}
				break;
			case TEXT:
				{
				setState(118);
				match(TEXT);
				 _exprSelection = _input.LT(-1).getText(); 
				}
				break;
			case BOOLEAN:
				{
				setState(120);
				match(BOOLEAN);
				 _exprSelection = (_input.LT(-1).getText().equals("verdadeiro") ? "true" : "false"); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(124);
			match(FP);
			setState(125);
			match(ACH);

							currentThread = new ArrayList<AbstractCommand>();
							stack.push(currentThread);
						
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(127);
				comando();
				}
				}
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << ID))) != 0) );
			setState(132);
			match(FCH);

							listaTrue = stack.pop();
							listaFalse = new ArrayList<AbstractCommand>();
						
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(134);
				match(T__9);
				setState(135);
				match(ACH);

									currentThread = new ArrayList<AbstractCommand>();
									stack.push(currentThread);
								
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(137);
					comando();
					}
					}
					setState(140); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << ID))) != 0) );
				setState(142);
				match(FCH);

									listaFalse = stack.pop();
								
				}
			}


							CommandSelecao cmd = new CommandSelecao(_exprSelection, listaTrue, listaFalse);
							stack.peek().add(cmd);
						
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdrepeticaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MyLangParser.AP, 0); }
		public TerminalNode OPREL() { return getToken(MyLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(MyLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(MyLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(MyLangParser.FCH, 0); }
		public List<TerminalNode> ID() { return getTokens(MyLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MyLangParser.ID, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(MyLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(MyLangParser.NUMBER, i);
		}
		public List<TerminalNode> TEXT() { return getTokens(MyLangParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(MyLangParser.TEXT, i);
		}
		public List<TerminalNode> BOOLEAN() { return getTokens(MyLangParser.BOOLEAN); }
		public TerminalNode BOOLEAN(int i) {
			return getToken(MyLangParser.BOOLEAN, i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdrepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdrepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterCmdrepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitCmdrepeticao(this);
		}
	}

	public final CmdrepeticaoContext cmdrepeticao() throws RecognitionException {
		CmdrepeticaoContext _localctx = new CmdrepeticaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdrepeticao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__10);
			setState(150);
			match(AP);
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(151);
				match(ID);

									verificaID(_input.LT(-1).getText());
									marcaVariavelUsada(_input.LT(-1).getText());
								
				}
				break;
			case NUMBER:
				{
				setState(153);
				match(NUMBER);
				}
				break;
			case TEXT:
				{
				setState(154);
				match(TEXT);
				}
				break;
			case BOOLEAN:
				{
				setState(155);
				match(BOOLEAN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 _exprRepetition = _input.LT(-1).getText(); 
			setState(159);
			match(OPREL);
			 _exprRepetition += _input.LT(-1).getText(); 
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(161);
				match(ID);

									verificaID(_input.LT(-1).getText());
									marcaVariavelUsada(_input.LT(-1).getText());
								
				}
				break;
			case NUMBER:
				{
				setState(163);
				match(NUMBER);
				}
				break;
			case TEXT:
				{
				setState(164);
				match(TEXT);
				}
				break;
			case BOOLEAN:
				{
				setState(165);
				match(BOOLEAN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 _exprRepetition += _input.LT(-1).getText(); 
			setState(169);
			match(FP);
			setState(170);
			match(ACH);

								currentThread = new ArrayList<AbstractCommand>();
								stack.push(currentThread);
							
			setState(173); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(172);
				comando();
				}
				}
				setState(175); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << ID))) != 0) );
			setState(177);
			match(FCH);

								listaWhile = stack.pop();
								CommandRepeticao cmd = new CommandRepeticao(_exprRepetition, listaWhile);
								stack.peek().add(cmd);
							
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdparaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(MyLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(MyLangParser.ID, 0); }
		public List<TerminalNode> INTEGER() { return getTokens(MyLangParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(MyLangParser.INTEGER, i);
		}
		public TerminalNode FP() { return getToken(MyLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(MyLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(MyLangParser.FCH, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdparaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdpara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterCmdpara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitCmdpara(this);
		}
	}

	public final CmdparaContext cmdpara() throws RecognitionException {
		CmdparaContext _localctx = new CmdparaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdpara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__11);
			setState(181);
			match(AP);
			setState(182);
			match(ID);

						_forID = _input.LT(-1).getText();
						verificaID(_forID);
						verificaVarType(_forID, MyLangVariable.INTEGER);
						marcaVariavelUsada(_forID);
					
			setState(184);
			match(T__12);
			setState(185);
			match(INTEGER);
			 _initialIndex =  _input.LT(-1).getText(); 
			setState(187);
			match(T__13);
			setState(188);
			match(INTEGER);
			 _finalIndex =  _input.LT(-1).getText(); 
			setState(190);
			match(FP);
			setState(191);
			match(ACH);

						currentThread = new ArrayList<AbstractCommand>();
						stack.push(currentThread);
					
			setState(194); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(193);
				comando();
				}
				}
				setState(196); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << ID))) != 0) );
			setState(198);
			match(FCH);

						listaFor = stack.pop();
						CommandPara cmd = new CommandPara(_forID, _initialIndex, _finalIndex, listaFor);
						stack.peek().add(cmd);
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(MyLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(MyLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			termo();
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(202);
				match(OP);

							_exprContent += _input.LT(-1).getText();
						
				setState(204);
				termo();
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MyLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(MyLangParser.NUMBER, 0); }
		public TerminalNode TEXT() { return getToken(MyLangParser.TEXT, 0); }
		public TerminalNode BOOLEAN() { return getToken(MyLangParser.BOOLEAN, 0); }
		public TerminalNode INTEGER() { return getToken(MyLangParser.INTEGER, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLangListener ) ((MyLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termo);
		try {
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				match(ID);

							verificaID(_input.LT(-1).getText());
							marcaVariavelUsada(_input.LT(-1).getText());
							_exprContent += _input.LT(-1).getText();
						
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				match(NUMBER);

							_exprContent += _input.LT(-1).getText();
							verificaVarType(_exprID, MyLangVariable.NUMBER);
						
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				match(TEXT);

							_exprContent += _input.LT(-1).getText();
							verificaVarType(_exprID, MyLangVariable.TEXT);
						
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
				match(BOOLEAN);

							_exprContent += (_input.LT(-1).getText().equals("verdadeiro") ? "true" : "false");
							verificaVarType(_exprID, MyLangVariable.BOOLEAN);
						
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 5);
				{
				setState(218);
				match(INTEGER);

							_exprContent += _input.LT(-1).getText();
							verificaVarType(_exprID, MyLangVariable.INTEGER);
						
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u00e1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\6\3&\n\3\r\3\16\3\'\3\4\3\4\3\4\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5?\n\5\3\6\3\6\6\6C\n\6\r"+
		"\6\16\6D\3\7\3\7\3\7\3\7\3\7\3\7\5\7M\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13q\n\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13}\n\13\3\13\3\13\3\13\3\13"+
		"\6\13\u0083\n\13\r\13\16\13\u0084\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u008d"+
		"\n\13\r\13\16\13\u008e\3\13\3\13\3\13\5\13\u0094\n\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f\u009f\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u00a9\n\f\3\f\3\f\3\f\3\f\3\f\6\f\u00b0\n\f\r\f\16\f\u00b1\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u00c5"+
		"\n\r\r\r\16\r\u00c6\3\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u00d0\n\16\f"+
		"\16\16\16\u00d3\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u00df\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\2\2"+
		"\u00f3\2\36\3\2\2\2\4%\3\2\2\2\6)\3\2\2\2\b>\3\2\2\2\n@\3\2\2\2\fL\3\2"+
		"\2\2\16N\3\2\2\2\20V\3\2\2\2\22^\3\2\2\2\24f\3\2\2\2\26\u0097\3\2\2\2"+
		"\30\u00b6\3\2\2\2\32\u00cb\3\2\2\2\34\u00de\3\2\2\2\36\37\7\3\2\2\37 "+
		"\5\4\3\2 !\5\n\6\2!\"\7\4\2\2\"#\b\2\1\2#\3\3\2\2\2$&\5\6\4\2%$\3\2\2"+
		"\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\5\3\2\2\2)*\5\b\5\2*+\7\36\2\2+\61"+
		"\b\4\1\2,-\7\26\2\2-.\7\36\2\2.\60\b\4\1\2/,\3\2\2\2\60\63\3\2\2\2\61"+
		"/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\7\23\2\2\65"+
		"\7\3\2\2\2\66\67\7\5\2\2\67?\b\5\1\289\7\6\2\29?\b\5\1\2:;\7\7\2\2;?\b"+
		"\5\1\2<=\7\b\2\2=?\b\5\1\2>\66\3\2\2\2>8\3\2\2\2>:\3\2\2\2><\3\2\2\2?"+
		"\t\3\2\2\2@B\b\6\1\2AC\5\f\7\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2"+
		"E\13\3\2\2\2FM\5\16\b\2GM\5\20\t\2HM\5\22\n\2IM\5\24\13\2JM\5\26\f\2K"+
		"M\5\30\r\2LF\3\2\2\2LG\3\2\2\2LH\3\2\2\2LI\3\2\2\2LJ\3\2\2\2LK\3\2\2\2"+
		"M\r\3\2\2\2NO\7\t\2\2OP\7\21\2\2PQ\7\36\2\2QR\b\b\1\2RS\7\22\2\2ST\7\23"+
		"\2\2TU\b\b\1\2U\17\3\2\2\2VW\7\n\2\2WX\7\21\2\2XY\7\36\2\2YZ\b\t\1\2Z"+
		"[\7\22\2\2[\\\7\23\2\2\\]\b\t\1\2]\21\3\2\2\2^_\7\36\2\2_`\b\n\1\2`a\7"+
		"\25\2\2ab\b\n\1\2bc\5\32\16\2cd\7\23\2\2de\b\n\1\2e\23\3\2\2\2fg\7\13"+
		"\2\2gp\7\21\2\2hi\7\36\2\2iq\b\13\1\2jk\7\33\2\2kq\b\13\1\2lm\7\34\2\2"+
		"mq\b\13\1\2no\7\35\2\2oq\b\13\1\2ph\3\2\2\2pj\3\2\2\2pl\3\2\2\2pn\3\2"+
		"\2\2qr\3\2\2\2rs\7\31\2\2s|\b\13\1\2tu\7\36\2\2u}\b\13\1\2vw\7\33\2\2"+
		"w}\b\13\1\2xy\7\34\2\2y}\b\13\1\2z{\7\35\2\2{}\b\13\1\2|t\3\2\2\2|v\3"+
		"\2\2\2|x\3\2\2\2|z\3\2\2\2}~\3\2\2\2~\177\7\22\2\2\177\u0080\7\27\2\2"+
		"\u0080\u0082\b\13\1\2\u0081\u0083\5\f\7\2\u0082\u0081\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0087\7\30\2\2\u0087\u0093\b\13\1\2\u0088\u0089\7\f\2\2\u0089\u008a\7"+
		"\27\2\2\u008a\u008c\b\13\1\2\u008b\u008d\5\f\7\2\u008c\u008b\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0091\7\30\2\2\u0091\u0092\b\13\1\2\u0092\u0094\3\2\2\2\u0093"+
		"\u0088\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\b\13"+
		"\1\2\u0096\25\3\2\2\2\u0097\u0098\7\r\2\2\u0098\u009e\7\21\2\2\u0099\u009a"+
		"\7\36\2\2\u009a\u009f\b\f\1\2\u009b\u009f\7\33\2\2\u009c\u009f\7\34\2"+
		"\2\u009d\u009f\7\35\2\2\u009e\u0099\3\2\2\2\u009e\u009b\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\b\f"+
		"\1\2\u00a1\u00a2\7\31\2\2\u00a2\u00a8\b\f\1\2\u00a3\u00a4\7\36\2\2\u00a4"+
		"\u00a9\b\f\1\2\u00a5\u00a9\7\33\2\2\u00a6\u00a9\7\34\2\2\u00a7\u00a9\7"+
		"\35\2\2\u00a8\u00a3\3\2\2\2\u00a8\u00a5\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\b\f\1\2\u00ab\u00ac\7\22"+
		"\2\2\u00ac\u00ad\7\27\2\2\u00ad\u00af\b\f\1\2\u00ae\u00b0\5\f\7\2\u00af"+
		"\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\30\2\2\u00b4\u00b5\b\f\1\2\u00b5"+
		"\27\3\2\2\2\u00b6\u00b7\7\16\2\2\u00b7\u00b8\7\21\2\2\u00b8\u00b9\7\36"+
		"\2\2\u00b9\u00ba\b\r\1\2\u00ba\u00bb\7\17\2\2\u00bb\u00bc\7\32\2\2\u00bc"+
		"\u00bd\b\r\1\2\u00bd\u00be\7\20\2\2\u00be\u00bf\7\32\2\2\u00bf\u00c0\b"+
		"\r\1\2\u00c0\u00c1\7\22\2\2\u00c1\u00c2\7\27\2\2\u00c2\u00c4\b\r\1\2\u00c3"+
		"\u00c5\5\f\7\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\7\30\2\2\u00c9"+
		"\u00ca\b\r\1\2\u00ca\31\3\2\2\2\u00cb\u00d1\5\34\17\2\u00cc\u00cd\7\24"+
		"\2\2\u00cd\u00ce\b\16\1\2\u00ce\u00d0\5\34\17\2\u00cf\u00cc\3\2\2\2\u00d0"+
		"\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\33\3\2\2"+
		"\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\7\36\2\2\u00d5\u00df\b\17\1\2\u00d6"+
		"\u00d7\7\33\2\2\u00d7\u00df\b\17\1\2\u00d8\u00d9\7\34\2\2\u00d9\u00df"+
		"\b\17\1\2\u00da\u00db\7\35\2\2\u00db\u00df\b\17\1\2\u00dc\u00dd\7\32\2"+
		"\2\u00dd\u00df\b\17\1\2\u00de\u00d4\3\2\2\2\u00de\u00d6\3\2\2\2\u00de"+
		"\u00d8\3\2\2\2\u00de\u00da\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\35\3\2\2"+
		"\2\22\'\61>DLp|\u0084\u008e\u0093\u009e\u00a8\u00b1\u00c6\u00d1\u00de";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}