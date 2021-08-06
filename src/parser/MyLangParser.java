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
		AP=10, FP=11, SC=12, OP=13, ATTR=14, VIR=15, ACH=16, FCH=17, OPREL=18, 
		ID=19, NUMBER=20, TEXT=21, WS=22;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_comando = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_cmdrepeticao = 10, RULE_expr = 11, RULE_termo = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "declaravar", "tipo", "bloco", "comando", "cmdleitura", 
			"cmdescrita", "cmdattrib", "cmdselecao", "cmdrepeticao", "expr", "termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprograma'", "'numero'", "'texto'", "'leia'", 
			"'escreva'", "'se'", "'senao'", "'enquanto'", "'('", "')'", "';'", null, 
			"'='", "','", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "AP", "FP", 
			"SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", "TEXT", 
			"WS"
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
			setState(26);
			match(T__0);
			setState(27);
			decl();
			setState(28);
			bloco();
			setState(29);
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
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				declaravar();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__3 );
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
			setState(37);
			tipo();
			setState(38);
			match(ID);

							_varName = _input.LT(-1).getText();
							_varValue = null;
							symbol = new MyLangVariable(_varName, _tipo, _varValue);
							if (!symbolTable.exists(_varName)) {
								symbolTable.add(symbol);
							} else {
								throw new MyLangSemanticException("Symbol " + _varName + " already declared");
							}
						
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(40);
				match(VIR);
				setState(41);
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
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
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
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(T__2);
				 _tipo = MyLangVariable.NUMBER; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				match(T__3);
				 _tipo = MyLangVariable.TEXT; 
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
					
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				comando();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
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
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				cmdleitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				cmdattrib();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				cmdselecao();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				cmdrepeticao();
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
			setState(69);
			match(T__4);
			setState(70);
			match(AP);
			setState(71);
			match(ID);

							verificaID(_input.LT(-1).getText());
							_readID = _input.LT(-1).getText();
						
			setState(73);
			match(FP);
			setState(74);
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
			setState(77);
			match(T__5);
			setState(78);
			match(AP);
			setState(79);
			match(ID);

							verificaID(_input.LT(-1).getText());
							marcaVariavelUsada(_input.LT(-1).getText());
							_writeID = _input.LT(-1).getText();
						
			setState(81);
			match(FP);
			setState(82);
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
			setState(85);
			match(ID);

							verificaID(_input.LT(-1).getText());
							_exprID = _input.LT(-1).getText();
						
			setState(87);
			match(ATTR);

							_exprContent = "";
						
			setState(89);
			expr();
			setState(90);
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
			setState(93);
			match(T__6);
			setState(94);
			match(AP);
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(95);
				match(ID);

								verificaID(_input.LT(-1).getText());
								marcaVariavelUsada(_input.LT(-1).getText());
							
				}
				break;
			case NUMBER:
				{
				setState(97);
				match(NUMBER);
				}
				break;
			case TEXT:
				{
				setState(98);
				match(TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 _exprSelection = _input.LT(-1).getText(); 
			setState(102);
			match(OPREL);
			 _exprSelection += _input.LT(-1).getText(); 
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(104);
				match(ID);

								verificaID(_input.LT(-1).getText());
								marcaVariavelUsada(_input.LT(-1).getText());
							
				}
				break;
			case NUMBER:
				{
				setState(106);
				match(NUMBER);
				}
				break;
			case TEXT:
				{
				setState(107);
				match(TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 _exprSelection += _input.LT(-1).getText(); 
			setState(111);
			match(FP);
			setState(112);
			match(ACH);

							currentThread = new ArrayList<AbstractCommand>();
							stack.push(currentThread);
						
			setState(115); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(114);
				comando();
				}
				}
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
			setState(119);
			match(FCH);

							listaTrue = stack.pop();
						
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(121);
				match(T__7);
				setState(122);
				match(ACH);

									currentThread = new ArrayList<AbstractCommand>();
									stack.push(currentThread);
								
				setState(125); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(124);
					comando();
					}
					}
					setState(127); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
				setState(129);
				match(FCH);

									listaFalse = stack.pop();
									CommandSelecao cmd = new CommandSelecao(_exprSelection, listaTrue, listaFalse);
									stack.peek().add(cmd);
								
				}
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
			setState(134);
			match(T__8);
			setState(135);
			match(AP);
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(136);
				match(ID);

									verificaID(_input.LT(-1).getText());
									marcaVariavelUsada(_input.LT(-1).getText());
								
				}
				break;
			case NUMBER:
				{
				setState(138);
				match(NUMBER);
				}
				break;
			case TEXT:
				{
				setState(139);
				match(TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 _exprRepetition = _input.LT(-1).getText(); 
			setState(143);
			match(OPREL);
			 _exprRepetition += _input.LT(-1).getText(); 
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(145);
				match(ID);

									verificaID(_input.LT(-1).getText());
									marcaVariavelUsada(_input.LT(-1).getText());
								
				}
				break;
			case NUMBER:
				{
				setState(147);
				match(NUMBER);
				}
				break;
			case TEXT:
				{
				setState(148);
				match(TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 _exprRepetition += _input.LT(-1).getText(); 
			setState(152);
			match(FP);
			setState(153);
			match(ACH);

								currentThread = new ArrayList<AbstractCommand>();
								stack.push(currentThread);
							
			setState(156); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(155);
				comando();
				}
				}
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
			setState(160);
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
		enterRule(_localctx, 22, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			termo();
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(164);
				match(OP);

							_exprContent += _input.LT(-1).getText();
						
				setState(166);
				termo();
				}
				}
				setState(171);
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
		enterRule(_localctx, 24, RULE_termo);
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(ID);

							verificaID(_input.LT(-1).getText());
							marcaVariavelUsada(_input.LT(-1).getText());
							_exprContent += _input.LT(-1).getText();
						
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(NUMBER);

							_exprContent += _input.LT(-1).getText();
							verificaVarType(_exprID, MyLangVariable.NUMBER);
						
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				match(TEXT);

							_exprContent += _input.LT(-1).getText();
							verificaVarType(_exprID, MyLangVariable.TEXT);
						
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u00b7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6\3$\n\3\r"+
		"\3\16\3%\3\4\3\4\3\4\3\4\3\4\3\4\7\4.\n\4\f\4\16\4\61\13\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\5\59\n\5\3\6\3\6\6\6=\n\6\r\6\16\6>\3\7\3\7\3\7\3\7\3\7\5"+
		"\7F\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"f\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13o\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\6\13v\n\13\r\13\16\13w\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u0080"+
		"\n\13\r\13\16\13\u0081\3\13\3\13\3\13\5\13\u0087\n\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u008f\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0098\n\f\3\f\3"+
		"\f\3\f\3\f\3\f\6\f\u009f\n\f\r\f\16\f\u00a0\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\7\r\u00aa\n\r\f\r\16\r\u00ad\13\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u00b5\n\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\2\2\u00c0\2"+
		"\34\3\2\2\2\4#\3\2\2\2\6\'\3\2\2\2\b8\3\2\2\2\n:\3\2\2\2\fE\3\2\2\2\16"+
		"G\3\2\2\2\20O\3\2\2\2\22W\3\2\2\2\24_\3\2\2\2\26\u0088\3\2\2\2\30\u00a5"+
		"\3\2\2\2\32\u00b4\3\2\2\2\34\35\7\3\2\2\35\36\5\4\3\2\36\37\5\n\6\2\37"+
		" \7\4\2\2 !\b\2\1\2!\3\3\2\2\2\"$\5\6\4\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2"+
		"\2%&\3\2\2\2&\5\3\2\2\2\'(\5\b\5\2()\7\25\2\2)/\b\4\1\2*+\7\21\2\2+,\7"+
		"\25\2\2,.\b\4\1\2-*\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3"+
		"\2\2\2\61/\3\2\2\2\62\63\7\16\2\2\63\7\3\2\2\2\64\65\7\5\2\2\659\b\5\1"+
		"\2\66\67\7\6\2\2\679\b\5\1\28\64\3\2\2\28\66\3\2\2\29\t\3\2\2\2:<\b\6"+
		"\1\2;=\5\f\7\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?\13\3\2\2\2@F\5"+
		"\16\b\2AF\5\20\t\2BF\5\22\n\2CF\5\24\13\2DF\5\26\f\2E@\3\2\2\2EA\3\2\2"+
		"\2EB\3\2\2\2EC\3\2\2\2ED\3\2\2\2F\r\3\2\2\2GH\7\7\2\2HI\7\f\2\2IJ\7\25"+
		"\2\2JK\b\b\1\2KL\7\r\2\2LM\7\16\2\2MN\b\b\1\2N\17\3\2\2\2OP\7\b\2\2PQ"+
		"\7\f\2\2QR\7\25\2\2RS\b\t\1\2ST\7\r\2\2TU\7\16\2\2UV\b\t\1\2V\21\3\2\2"+
		"\2WX\7\25\2\2XY\b\n\1\2YZ\7\20\2\2Z[\b\n\1\2[\\\5\30\r\2\\]\7\16\2\2]"+
		"^\b\n\1\2^\23\3\2\2\2_`\7\t\2\2`e\7\f\2\2ab\7\25\2\2bf\b\13\1\2cf\7\26"+
		"\2\2df\7\27\2\2ea\3\2\2\2ec\3\2\2\2ed\3\2\2\2fg\3\2\2\2gh\b\13\1\2hi\7"+
		"\24\2\2in\b\13\1\2jk\7\25\2\2ko\b\13\1\2lo\7\26\2\2mo\7\27\2\2nj\3\2\2"+
		"\2nl\3\2\2\2nm\3\2\2\2op\3\2\2\2pq\b\13\1\2qr\7\r\2\2rs\7\22\2\2su\b\13"+
		"\1\2tv\5\f\7\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\7\23"+
		"\2\2z\u0086\b\13\1\2{|\7\n\2\2|}\7\22\2\2}\177\b\13\1\2~\u0080\5\f\7\2"+
		"\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2"+
		"\2\u0082\u0083\3\2\2\2\u0083\u0084\7\23\2\2\u0084\u0085\b\13\1\2\u0085"+
		"\u0087\3\2\2\2\u0086{\3\2\2\2\u0086\u0087\3\2\2\2\u0087\25\3\2\2\2\u0088"+
		"\u0089\7\13\2\2\u0089\u008e\7\f\2\2\u008a\u008b\7\25\2\2\u008b\u008f\b"+
		"\f\1\2\u008c\u008f\7\26\2\2\u008d\u008f\7\27\2\2\u008e\u008a\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\b\f"+
		"\1\2\u0091\u0092\7\24\2\2\u0092\u0097\b\f\1\2\u0093\u0094\7\25\2\2\u0094"+
		"\u0098\b\f\1\2\u0095\u0098\7\26\2\2\u0096\u0098\7\27\2\2\u0097\u0093\3"+
		"\2\2\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009a\b\f\1\2\u009a\u009b\7\r\2\2\u009b\u009c\7\22\2\2\u009c\u009e\b"+
		"\f\1\2\u009d\u009f\5\f\7\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7\23"+
		"\2\2\u00a3\u00a4\b\f\1\2\u00a4\27\3\2\2\2\u00a5\u00ab\5\32\16\2\u00a6"+
		"\u00a7\7\17\2\2\u00a7\u00a8\b\r\1\2\u00a8\u00aa\5\32\16\2\u00a9\u00a6"+
		"\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\31\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7\25\2\2\u00af\u00b5\b\16"+
		"\1\2\u00b0\u00b1\7\26\2\2\u00b1\u00b5\b\16\1\2\u00b2\u00b3\7\27\2\2\u00b3"+
		"\u00b5\b\16\1\2\u00b4\u00ae\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b4\u00b2\3"+
		"\2\2\2\u00b5\33\3\2\2\2\21%/8>Eenw\u0081\u0086\u008e\u0097\u00a0\u00ab"+
		"\u00b4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}