package test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import policy_msp.MSP_Listener;
import policy_msp.PolicyLexer;
import policy_msp.PolicyParser;

public class TestPolicyMSP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String policyString = "a and (b or c)";
		CharStream cs = CharStreams.fromString(policyString);
		PolicyLexer lexer = new PolicyLexer(cs);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PolicyParser parser = new PolicyParser(tokens);
		ParseTree tree = parser.expr();
		
		MSP_Listener listener = new MSP_Listener();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener, tree);
		
	}

}
