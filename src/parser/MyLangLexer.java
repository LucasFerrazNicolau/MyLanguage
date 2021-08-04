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
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MyLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, AP=9, 
		FP=10, SC=11, OP=12, ATTR=13, VIR=14, ACH=15, FCH=16, OPREL=17, ID=18, 
		NUMBER=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "AP", 
			"FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprograma'", "'numero'", "'texto'", "'leia'", 
			"'escreva'", "'se'", "'senao'", "'('", "')'", "';'", null, "'='", "','", 
			"'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "AP", "FP", "SC", 
			"OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", "WS"
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
		
		public void verificaID(String id) {
			if (!symbolTable.exists(id)) {
				throw new MyLangSemanticException("Symbol " + id + " not declared");
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


	public MyLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MyLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0096\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22}\n\22\3\23\3\23\7\23\u0081\n\23\f"+
		"\23\16\23\u0084\13\23\3\24\6\24\u0087\n\24\r\24\16\24\u0088\3\24\3\24"+
		"\6\24\u008d\n\24\r\24\16\24\u008e\5\24\u0091\n\24\3\25\3\25\3\25\3\25"+
		"\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26\3\2\b\5\2,-//\61\61\4\2>>@@\3\2c|\5"+
		"\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u009d\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\3+\3\2\2\2\5\64\3\2\2\2\7@\3\2\2\2\tG\3\2\2\2\13M\3\2"+
		"\2\2\rR\3\2\2\2\17Z\3\2\2\2\21]\3\2\2\2\23c\3\2\2\2\25e\3\2\2\2\27g\3"+
		"\2\2\2\31i\3\2\2\2\33k\3\2\2\2\35m\3\2\2\2\37o\3\2\2\2!q\3\2\2\2#|\3\2"+
		"\2\2%~\3\2\2\2\'\u0086\3\2\2\2)\u0092\3\2\2\2+,\7r\2\2,-\7t\2\2-.\7q\2"+
		"\2./\7i\2\2/\60\7t\2\2\60\61\7c\2\2\61\62\7o\2\2\62\63\7c\2\2\63\4\3\2"+
		"\2\2\64\65\7h\2\2\65\66\7k\2\2\66\67\7o\2\2\678\7r\2\289\7t\2\29:\7q\2"+
		"\2:;\7i\2\2;<\7t\2\2<=\7c\2\2=>\7o\2\2>?\7c\2\2?\6\3\2\2\2@A\7p\2\2AB"+
		"\7w\2\2BC\7o\2\2CD\7g\2\2DE\7t\2\2EF\7q\2\2F\b\3\2\2\2GH\7v\2\2HI\7g\2"+
		"\2IJ\7z\2\2JK\7v\2\2KL\7q\2\2L\n\3\2\2\2MN\7n\2\2NO\7g\2\2OP\7k\2\2PQ"+
		"\7c\2\2Q\f\3\2\2\2RS\7g\2\2ST\7u\2\2TU\7e\2\2UV\7t\2\2VW\7g\2\2WX\7x\2"+
		"\2XY\7c\2\2Y\16\3\2\2\2Z[\7u\2\2[\\\7g\2\2\\\20\3\2\2\2]^\7u\2\2^_\7g"+
		"\2\2_`\7p\2\2`a\7c\2\2ab\7q\2\2b\22\3\2\2\2cd\7*\2\2d\24\3\2\2\2ef\7+"+
		"\2\2f\26\3\2\2\2gh\7=\2\2h\30\3\2\2\2ij\t\2\2\2j\32\3\2\2\2kl\7?\2\2l"+
		"\34\3\2\2\2mn\7.\2\2n\36\3\2\2\2op\7}\2\2p \3\2\2\2qr\7\177\2\2r\"\3\2"+
		"\2\2s}\t\3\2\2tu\7@\2\2u}\7?\2\2vw\7>\2\2w}\7?\2\2xy\7?\2\2y}\7?\2\2z"+
		"{\7#\2\2{}\7?\2\2|s\3\2\2\2|t\3\2\2\2|v\3\2\2\2|x\3\2\2\2|z\3\2\2\2}$"+
		"\3\2\2\2~\u0082\t\4\2\2\177\u0081\t\5\2\2\u0080\177\3\2\2\2\u0081\u0084"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083&\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0085\u0087\t\6\2\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0090\3\2\2\2\u008a"+
		"\u008c\7\60\2\2\u008b\u008d\t\6\2\2\u008c\u008b\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090"+
		"\u008a\3\2\2\2\u0090\u0091\3\2\2\2\u0091(\3\2\2\2\u0092\u0093\t\7\2\2"+
		"\u0093\u0094\3\2\2\2\u0094\u0095\b\25\2\2\u0095*\3\2\2\2\t\2|\u0080\u0082"+
		"\u0088\u008e\u0090\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}