package policy_msp;

import java.util.Hashtable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import policy_msp.PolicyParser.AtomContext;
import policy_msp.PolicyParser.ExprContext;
import policy_msp.PolicyParser.LeafConditionContext;
import policy_msp.PolicyParser.LeafNodeContext;
import policy_msp.PolicyParser.NodeContext;
import policy_msp.PolicyParser.PolicyContext;
import policy_msp.PolicyParser.TermContext;

public class MSP_Listener implements PolicyListener {

	Hashtable<String, Integer> attrDict = new Hashtable<String, Integer>();
	
	@Override
	public void enterEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterPolicy(PolicyContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitPolicy(PolicyContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterAtom(AtomContext ctx) {
		// TODO Auto-generated method stub
		System.out.println("rule entered: " + ctx.getText()); 
	

	}

	@Override
	public void exitAtom(AtomContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterTerm(TermContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitTerm(TermContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExpr(ExprContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExpr(ExprContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterLeafNode(LeafNodeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitLeafNode(LeafNodeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterLeafCondition(LeafConditionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitLeafCondition(LeafConditionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterNode(NodeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitNode(NodeContext ctx) {
		// TODO Auto-generated method stub

	}

}
