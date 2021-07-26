// Generated from Policy.g4 by ANTLR 4.9.2

package policy_msp;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PolicyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, Operator=2, WHITESPACE=3, LPAR=4, RPAR=5, BinOperator=6, NUM=7, 
		WORD=8;
	public static final int
		RULE_policy = 0, RULE_atom = 1, RULE_term = 2, RULE_expr = 3, RULE_leafNode = 4, 
		RULE_leafCondition = 5, RULE_node = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"policy", "atom", "term", "expr", "leafNode", "leafCondition", "node"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'!'", null, null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "Operator", "WHITESPACE", "LPAR", "RPAR", "BinOperator", 
			"NUM", "WORD"
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
	public String getGrammarFileName() { return "Policy.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PolicyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PolicyContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PolicyParser.EOF, 0); }
		public PolicyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_policy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterPolicy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitPolicy(this);
		}
	}

	public final PolicyContext policy() throws RecognitionException {
		PolicyContext _localctx = new PolicyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_policy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			expr();
			setState(15);
			match(EOF);
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

	public static class AtomContext extends ParserRuleContext {
		public NodeContext node() {
			return getRuleContext(NodeContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PolicyParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PolicyParser.RPAR, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case NUM:
			case WORD:
				{
				setState(17);
				node();
				}
				break;
			case LPAR:
				{
				setState(18);
				match(LPAR);
				setState(19);
				expr();
				setState(20);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TermContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<TerminalNode> Operator() { return getTokens(PolicyParser.Operator); }
		public TerminalNode Operator(int i) {
			return getToken(PolicyParser.Operator, i);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_term);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			atom();
			setState(29);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(25);
					match(Operator);
					setState(26);
					term();
					}
					} 
				}
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class ExprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> Operator() { return getTokens(PolicyParser.Operator); }
		public TerminalNode Operator(int i) {
			return getToken(PolicyParser.Operator, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			term();
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Operator) {
				{
				{
				setState(33);
				match(Operator);
				setState(34);
				term();
				}
				}
				setState(39);
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

	public static class LeafNodeContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(PolicyParser.WORD, 0); }
		public TerminalNode NUM() { return getToken(PolicyParser.NUM, 0); }
		public LeafNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leafNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterLeafNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitLeafNode(this);
		}
	}

	public final LeafNodeContext leafNode() throws RecognitionException {
		LeafNodeContext _localctx = new LeafNodeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_leafNode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(40);
				match(T__0);
				}
			}

			setState(43);
			_la = _input.LA(1);
			if ( !(_la==NUM || _la==WORD) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class LeafConditionContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(PolicyParser.WORD, 0); }
		public TerminalNode BinOperator() { return getToken(PolicyParser.BinOperator, 0); }
		public TerminalNode NUM() { return getToken(PolicyParser.NUM, 0); }
		public LeafConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leafCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterLeafCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitLeafCondition(this);
		}
	}

	public final LeafConditionContext leafCondition() throws RecognitionException {
		LeafConditionContext _localctx = new LeafConditionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_leafCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(WORD);
			setState(46);
			match(BinOperator);
			setState(47);
			match(NUM);
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

	public static class NodeContext extends ParserRuleContext {
		public LeafNodeContext leafNode() {
			return getRuleContext(LeafNodeContext.class,0);
		}
		public LeafConditionContext leafCondition() {
			return getRuleContext(LeafConditionContext.class,0);
		}
		public NodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).enterNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PolicyListener ) ((PolicyListener)listener).exitNode(this);
		}
	}

	public final NodeContext node() throws RecognitionException {
		NodeContext _localctx = new NodeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_node);
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				leafNode();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				leafCondition();
				}
				break;
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\n8\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\5\3\31\n\3\3\4\3\4\3\4\7\4\36\n\4\f\4\16\4!\13\4\3\5\3\5\3\5\7\5"+
		"&\n\5\f\5\16\5)\13\5\3\6\5\6,\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\5\b"+
		"\66\n\b\3\b\2\2\t\2\4\6\b\n\f\16\2\3\3\2\t\n\2\65\2\20\3\2\2\2\4\30\3"+
		"\2\2\2\6\32\3\2\2\2\b\"\3\2\2\2\n+\3\2\2\2\f/\3\2\2\2\16\65\3\2\2\2\20"+
		"\21\5\b\5\2\21\22\7\2\2\3\22\3\3\2\2\2\23\31\5\16\b\2\24\25\7\6\2\2\25"+
		"\26\5\b\5\2\26\27\7\7\2\2\27\31\3\2\2\2\30\23\3\2\2\2\30\24\3\2\2\2\31"+
		"\5\3\2\2\2\32\37\5\4\3\2\33\34\7\4\2\2\34\36\5\6\4\2\35\33\3\2\2\2\36"+
		"!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \7\3\2\2\2!\37\3\2\2\2\"\'\5\6\4\2"+
		"#$\7\4\2\2$&\5\6\4\2%#\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\t\3\2"+
		"\2\2)\'\3\2\2\2*,\7\3\2\2+*\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\t\2\2\2.\13"+
		"\3\2\2\2/\60\7\n\2\2\60\61\7\b\2\2\61\62\7\t\2\2\62\r\3\2\2\2\63\66\5"+
		"\n\6\2\64\66\5\f\7\2\65\63\3\2\2\2\65\64\3\2\2\2\66\17\3\2\2\2\7\30\37"+
		"\'+\65";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}