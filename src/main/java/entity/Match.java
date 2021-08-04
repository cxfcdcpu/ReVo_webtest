package entity;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import it.unisa.dia.gas.jpbc.Element;
import revoabe.MasterKey;
import revoabe.PrivateKey;
import revoabe.PublicKey;
import revoabe.ReVo_ABE;

public class Match {
	
	private mission ms;
	private user ur;
	private int user_tree_id;
	private Timestamp registerationTime;
	private byte[] L;
	private List<String> attributes;
	private List<Integer> attrSizes;
	private byte[] k_is;
	private List<String> revoNodes;
	private List<Integer> revoNodeSizes;
	private byte[] k_ys;
	
	public Match(mission m, user u, int treeID) {
		this.ms = m;
		this.ur = u;
		this.user_tree_id = treeID;
		this.keyGen();
	}
	
	public Match(mission m, user u, int treeID, PrivateKey pk) {
		this.ms = m;
		this.ur = u;
		this.user_tree_id = treeID;
		this.assignPrivateKey(pk);
		
	}
	
	public void keyGen() {
		PublicKey pk = this.ms.getPublicKey();
		MasterKey mk = this.ms.getMasterKey();
		this.assignPrivateKey(ReVo_ABE.keyGen(pk, mk, this.ur.getAttributes(), this.user_tree_id));
	}
	
	public void setTimestamp(Timestamp ts) {
		this.registerationTime = ts;
	}

	public void assignPrivateKey(PrivateKey pk) {
		if (pk == null) {
			this.L = null;
			this.attributes = null;
			this.attrSizes = null;
			this.k_is = null;
			this.revoNodes = null;
			this.revoNodeSizes = null;
			this.k_ys = null;
		}
		
		this.attributes = pk.getAttributes();
		this.L = pk.getL();
		this.attrSizes = pk.getAttrSizes();
		this.k_is = pk.getKIs();
		this.revoNodes = pk.getReVoNodes();
		this.revoNodeSizes = pk.getReVoNodeSizes();
		this.k_ys = pk.getKYs();
	}
	
	public int getMissionID() {
		return this.ms.getMissionID();
	}
	
	public int getUserID() {
		return this.ur.getUserID();
	}
	
	public byte[] getL() {
		return this.L;
	}
	
	public List<String> getAttributes(){
		return this.attributes;
	}
	
	public String getAttributesString() {
		return String.join(",", this.attributes);
	}
	
	public List<Integer> attrSizes(){
		return this.attrSizes;
	}
	
	public String getAttrSizesString() {
		String ret = "";
		for(int size : this.attrSizes) {
			ret+=size;
			ret+=",";
		}
		return ret.substring(0, ret.length()-1);
	}
	
	public byte[] getKIs() {
		return this.k_is;
	}
	
	public List<String> getReVoNodes(){
		return this.revoNodes;
	}
	
	public String getReVoNodesString() {
		return String.join(",", this.revoNodes);
	}
	
	public List<Integer> getReVoNodeSizes(){
		return this.revoNodeSizes;
	}
	
	public String getReVoNodeSizesString() {
		String ret = "";
		for(int size: this.revoNodeSizes) {
			ret+=size;
			ret+=",";
		}
		return ret.substring(0, ret.length()-1);
	}
	
	public byte[] getKYs() {
		return this.k_ys;
	}
	
	public Timestamp getRegisterationTime() {
		return this.registerationTime;
	}
}
