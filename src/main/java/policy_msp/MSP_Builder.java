package policy_msp;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import it.unisa.dia.gas.jpbc.Pairing;
import policy_msp.BinNode.OpType;

import java.util.*;
public class MSP_Builder {

	int len_longest_row;
	Pairing group;
	
	public MSP_Builder() {
		this.len_longest_row = 1;
	}
	
	public BinNode createPolicy(String policyString) {
		CharStream cs = CharStreams.fromString(policyString);
		
		PolicyLexer lexer = new PolicyLexer(cs);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PolicyParser parser = new PolicyParser(tokens);
		ParseTree tree = parser.policy();
		
		MSP_Listener listener = new MSP_Listener();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener, tree);
		listener.findDuplications(listener.parseTreeRoot);
		listener.updateLabelDict();
		listener.labelDuplicates(listener.parseTreeRoot);
		return listener.parseTreeRoot;
	}
	
	public Hashtable<String,List<Integer>> convert_policy_to_msp(BinNode tree){
		List<Integer> root_vector= new ArrayList<Integer>();
		root_vector.add(1);
		this.len_longest_row = 1;
		return _convert_policy_to_msp(tree, root_vector);
	}
	
	public Hashtable<String,List<Integer>> _convert_policy_to_msp(BinNode subtree, List<Integer> curr_vector){
		
		if (subtree == null) {
			return null;
		}
		
		OpType type = subtree.getNodeType();
		//System.out.println(type);
		if (type == OpType.ATTR) {
			Hashtable<String,List<Integer>> ret = new Hashtable<String,List<Integer>>();
			ret.put(subtree.getAttributeAndIndex(), curr_vector);
			return ret;
		}
		
		if (type == OpType.OR) {
			Hashtable<String,List<Integer>> left_list = this._convert_policy_to_msp(subtree.getLeft(), curr_vector);
			Hashtable<String,List<Integer>> right_list = this._convert_policy_to_msp(subtree.getRight(), curr_vector);
			left_list.putAll(right_list);
			return left_list;
		}
		
		if (type == OpType.AND) {
			int length = curr_vector.size();
			List<Integer> left_vector = createLeftVector(curr_vector,length);
			List<Integer> right_vector = createRightVector(curr_vector,length);
			this.len_longest_row+=1;
			Hashtable<String,List<Integer>> left_list = this._convert_policy_to_msp(subtree.getLeft(), left_vector);
			Hashtable<String,List<Integer>> right_list = this._convert_policy_to_msp(subtree.getRight(), right_vector);
			left_list.putAll(right_list);
			return left_list;
		}
		
		return null;
	}
	
	public List<Integer> createLeftVector(List<Integer> curr_vector,int length){
		List<Integer> ret = new ArrayList<Integer>();
		ret.addAll(curr_vector);
		for (int i = 0; i<this.len_longest_row-length;i++) {
			ret.add(0);
		}
		ret.add(1);
		return ret;		
	}
	
	public List<Integer> createRightVector(List<Integer> curr_vector,int length){
		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i<this.len_longest_row; i++) {
			ret.add(0);
		}
		ret.add(-1);
		return ret;		
	}
	
	public String strip_index(String attr) {
		if(attr.lastIndexOf("_")!=-1) {
			return attr.substring(0, attr.lastIndexOf("_"));
		}
		return attr;
	}
	
	
	public int getLongestRow() {
		return this.len_longest_row;
	}
	
	
	
	
}
