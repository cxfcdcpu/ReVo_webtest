package revoabe;
import it.unisa.dia.gas.jpbc.*;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
public class MembershipTree{

	int m; //the maximum number of users for the mission
	int user_id_counter; //help to mark user's id through iteration
	Element g1; //points of the given elliptical curve
	Pairing group; //the pairing group
	TreeNode root; //root of the tree
	HashMap<Integer,TreeNode> user_id_to_leaf; //all leafnodes and ids
	
	public MembershipTree(int maxNodes, Element g, Pairing pairingFactory) {
		this.m = maxNodes;
		this.user_id_to_leaf = new HashMap<Integer, TreeNode>();
		this.g1 = g;
		this.group = pairingFactory;
		this.root = createTree();
	}
	
	public TreeNode createTree() {
		if(this.m<1) return null;
		this.user_id_counter = 1;
		return dfs(null,1,log2(this.m));
	}
	
	private TreeNode createTreeNode(TreeNode parent, int y_i) {
		TreeNode node = new TreeNode(y_i, this.g1.powZn(this.group.getZr().newRandomElement()),parent);
		return node;
	}
	
	
	private TreeNode dfs(TreeNode parent, int y_i, int h) {
		TreeNode node = createTreeNode(parent, y_i);
		if (h == 0) {
			node.user_id = this.user_id_counter;
			this.user_id_to_leaf.put(this.user_id_counter, node);
			this.user_id_counter+=1;
			return node;
		}
		else {
			node.left = dfs(node,2*y_i,h-1);
			node.right = dfs(node, 2*y_i+1,h-1);
			return node; 
		}
	}
	
	public List<TreeNode> getUserPath(int user_id){
		List<TreeNode> ret = new ArrayList<TreeNode>();
		if (!(user_id>=1 && user_id<= this.m)) {
			return ret;
		}
		TreeNode node= this.user_id_to_leaf.get(user_id);
		while (node!=null) {
			ret.add(node);
			node = node.parent;
		}
		return ret;
	}
	
	private void colorRED(TreeNode node) {
		while(node !=null && node.color == node.GREEN) {
			node.color = node.RED;
			node = node.parent;
		}
	}
	
	private List<TreeNode> getSubsetCoverNodesAndResetColor(TreeNode node) {
		
		LinkedList<TreeNode> bfsList = new LinkedList<TreeNode>();
		List<TreeNode> ret = new ArrayList<TreeNode>();
		if(node == null)return ret;
		bfsList.add(node);
		while(bfsList.size()!=0) {
			TreeNode curNode = bfsList.poll();
			if (curNode.color == curNode.GREEN) {
				ret.add(curNode);
			}
			else {
				curNode.color = curNode.GREEN;
				if(curNode.left != null)
					bfsList.add(curNode.left);
				if(curNode.right != null)
					bfsList.add(curNode.right);
			}
		}
		return ret;
				
	}
	
	public List<TreeNode> getSubsetCover(List<Integer> RL){
		List<TreeNode> res = new ArrayList<TreeNode>();
		
		if ( RL != null && RL.size() != 0) {
			for (int user_id : RL) {
				if(user_id>=1 && user_id <= m) {
					colorRED(this.user_id_to_leaf.get(user_id));
				}
			}
		}
		
		return getSubsetCoverNodesAndResetColor(this.root);
		
	}
	
	
	
	
	

	
	@Override
	public String toString() {
		return group.toString();
		
	}
	
	
	
	
	public int log2(int m) {
		return (int)Math.ceil(Math.log(m)/Math.log(2));
	}
	
	public void printAllNodesBFS() {
		LinkedList<TreeNode> treeList = new LinkedList<TreeNode>();
		treeList.add(root);
		while(treeList.size()!=0) {
			TreeNode cur = treeList.poll();
			cur.printNode();
			if(cur.left != null) {
				treeList.add(cur.left);
			}
			if(cur.right != null) {
				treeList.add(cur.right);
			}
		}
	}
	
}