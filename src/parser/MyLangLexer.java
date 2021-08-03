// Generated from ../MyLang.g4 by ANTLR 4.9.2
package parser;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, AP=7, FP=8, SC=9, OP=10, 
		ATTR=11, VIR=12, ID=13, NUMBER=14, WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "AP", "FP", "SC", "OP", 
			"ATTR", "VIR", "ID", "NUMBER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprograma'", "'numero'", "'texto'", "'leia'", 
			"'escreva'", "'('", "')'", "';'", null, "'='", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "AP", "FP", "SC", "OP", "ATTR", 
			"VIR", "ID", "NUMBER", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21t\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\7\16_\n\16\f\16\16\16b\13\16\3\17\6\17e\n\17\r\17\16"+
		"\17f\3\17\3\17\6\17k\n\17\r\17\16\17l\5\17o\n\17\3\20\3\20\3\20\3\20\2"+
		"\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21\3\2\7\5\2,-//\61\61\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17"+
		"\"\"\2w\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2\2"+
		"\5*\3\2\2\2\7\66\3\2\2\2\t=\3\2\2\2\13C\3\2\2\2\rH\3\2\2\2\17P\3\2\2\2"+
		"\21R\3\2\2\2\23T\3\2\2\2\25V\3\2\2\2\27X\3\2\2\2\31Z\3\2\2\2\33\\\3\2"+
		"\2\2\35d\3\2\2\2\37p\3\2\2\2!\"\7r\2\2\"#\7t\2\2#$\7q\2\2$%\7i\2\2%&\7"+
		"t\2\2&\'\7c\2\2\'(\7o\2\2()\7c\2\2)\4\3\2\2\2*+\7h\2\2+,\7k\2\2,-\7o\2"+
		"\2-.\7r\2\2./\7t\2\2/\60\7q\2\2\60\61\7i\2\2\61\62\7t\2\2\62\63\7c\2\2"+
		"\63\64\7o\2\2\64\65\7c\2\2\65\6\3\2\2\2\66\67\7p\2\2\678\7w\2\289\7o\2"+
		"\29:\7g\2\2:;\7t\2\2;<\7q\2\2<\b\3\2\2\2=>\7v\2\2>?\7g\2\2?@\7z\2\2@A"+
		"\7v\2\2AB\7q\2\2B\n\3\2\2\2CD\7n\2\2DE\7g\2\2EF\7k\2\2FG\7c\2\2G\f\3\2"+
		"\2\2HI\7g\2\2IJ\7u\2\2JK\7e\2\2KL\7t\2\2LM\7g\2\2MN\7x\2\2NO\7c\2\2O\16"+
		"\3\2\2\2PQ\7*\2\2Q\20\3\2\2\2RS\7+\2\2S\22\3\2\2\2TU\7=\2\2U\24\3\2\2"+
		"\2VW\t\2\2\2W\26\3\2\2\2XY\7?\2\2Y\30\3\2\2\2Z[\7.\2\2[\32\3\2\2\2\\`"+
		"\t\3\2\2]_\t\4\2\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\34\3\2\2\2"+
		"b`\3\2\2\2ce\t\5\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2gn\3\2\2\2"+
		"hj\7\60\2\2ik\t\5\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2"+
		"\2nh\3\2\2\2no\3\2\2\2o\36\3\2\2\2pq\t\6\2\2qr\3\2\2\2rs\b\20\2\2s \3"+
		"\2\2\2\b\2^`fln\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}