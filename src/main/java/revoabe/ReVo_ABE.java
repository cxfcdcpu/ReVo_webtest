package revoabe;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import it.unisa.dia.gas.jpbc.*;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import policy_msp.BinNode;
import policy_msp.MSP_Builder;


public class ReVo_ABE {
	int nodeCount;

	Pairing group;
	PublicKey publicKey;
	MasterKey masterKey;
	
	
	public ReVo_ABE(Pairing pair, int m) {
		group = pair;
		nodeCount = m;
		setup(nodeCount);
	}
	
	public ReVo_ABE(int m, Pairing pair, PublicKey pk, MasterKey mk) {
		nodeCount = m;
		group = pair;
		publicKey = pk;
		masterKey = mk;
	}
	
	public PublicKey getPublicKey() {
		return publicKey;
	}
	
	public MasterKey getMasterKey() {
		return masterKey;
	}
	
	
	private void setup(int m) {
		nodeCount = m;
		Element g1 = group.getG1().newRandomElement();
		Element g2 = group.getG2().newRandomElement();
		Element alpha = group.getZr().newRandomElement();
		Element beta = group.getZr().newRandomElement();
		Element g1_alpha = g1.powZn(alpha);
		Element g2_beta = g2.powZn(beta);
		Element e_gg_alpha = group.pairing(g1_alpha, g2);
		Element a = group.getZr().newRandomElement();
		Element g1_a = g1.powZn(a);
		MembershipTree membership_tree = new MembershipTree(m,g1,group);
		
		publicKey = new PublicKey(membership_tree, g1,g2,g2_beta,e_gg_alpha,g1_a);
		masterKey = new MasterKey(g1_alpha, beta);
		
	}
	
	public PrivateKey keygen(List<String> attr_list, int user_id) {
		if (publicKey.membership_tree == null || user_id < 1 || user_id > nodeCount) {
			return null;
		}
		Element t = group.getZr().newRandomElement();
		Element g_alpha_at = masterKey.g1_alpha.mul(publicKey.g1_a.powZn(t));
		Element L = publicKey.g2.powZn(t);
		HashMap<String, Element> K_i = new HashMap<String, Element>();
		HashMap<Integer,Element> K_y = new HashMap<Integer, Element>();
		for(TreeNode node : publicKey.membership_tree.getUserPath(user_id)) {
			
			K_y.put(node.y_i, (g_alpha_at.mul(node.g_y_i)).powZn(masterKey.beta.invert()));
		}
		for(String attr : attr_list) {
			byte[] at = attr.getBytes();
			Element value = group.getG1().newElementFromHash(at, 0, at.length);
			
			K_i.put(attr, value.powZn(t));
		}
		return new PrivateKey(attr_list,K_i,L,K_y);
	}
	
	public Ciphertext encrypt(PublicKey pk, String msg, String policyString, List<Integer> RL) {
		MSP_Builder util = new MSP_Builder();
		BinNode policy = util.createPolicy(policyString);

		Hashtable<String,List<Integer>> mono_span_prog = util.convert_policy_to_msp(policy);
		int num_cols = util.getLongestRow();
		
		List<Element> u = new ArrayList<Element>();
		for (int i=0; i<num_cols; i++) {
			
			Element rand = this.group.getZr().newRandomElement();
			//System.out.println(rand);
			u.add(rand);
		}
		//shared secret
		Element s = u.get(0);
		Element r = this.group.getZr().newRandomElement();
		Element C_prime = pk.g2_beta.powZn(s);
		Element D = pk.g2.powZn(r);
		HashMap<Integer,Element> C_y = new HashMap<Integer,Element>();
		for (TreeNode node : pk.membership_tree.getSubsetCover(RL)) {
			C_y.put(node.y_i, node.g_y_i.powZn(s));
		}
		
		HashMap<String,Element> C_i = new HashMap<String,Element>();
		for (Map.Entry<String, List<Integer>> ele : mono_span_prog.entrySet()) {
			String attr = ele.getKey();
			List<Integer> row = ele.getValue();
			int cols = row.size();
			Element lambda_i = this.group.getZr().newZeroElement();
			System.out.println(attr);
			for (int i = 0; i<cols; i++) {
				lambda_i = lambda_i.add(u.get(i).mul(row.get(i)));
			}
			String attr_stripped = util.strip_index(attr);
			byte[] at = attr_stripped.getBytes();
			C_i.put(attr, (pk.g1_a.powZn(lambda_i)).div(this.group.getG1().newElementFromHash(at , 0, at.length).powZn(r)));
			
		}
		Element seed = this.group.getGT().newElementFromBytes(msg.getBytes());
//		System.out.println(seed.toString());
//		System.out.println(new String(seed.toCanonicalRepresentation(), StandardCharsets.UTF_8));
//		System.out.println(new String(seed.toBytes(), StandardCharsets.UTF_8));
		Element C = (pk.e_gg_alpha.powZn(s)).mul(seed);
		return new Ciphertext(policy, C, C_prime, D, C_y, C_i);	
		
	}
	
	
	
	
	public int getNodeCount() {
		return nodeCount;
	}
	


	
}
