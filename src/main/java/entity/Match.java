package entity;

import java.util.HashMap;
import java.util.List;

import it.unisa.dia.gas.jpbc.Element;
import revoabe.PrivateKey;

public class Match {
	
	private int missionID;
	private int userID;
	
	private byte[] L;
	private List<String> attributes;
	private List<Integer> attrSizes;
	private byte[] k_is;
	private List<String> revoNodes;
	private List<Integer> revoNodeSizes;
	private byte[] k_ys;
	
	public Match(int mID, int uID) {
		this.missionID = mID;
		this.userID = uID;
		this.assignPrivateKey(null);
	}
	
	public Match(int mID, int uID, PrivateKey pk) {
		this.missionID = mID;
		this.userID = uID;
		this.assignPrivateKey(pk);
	}
	
//	List<String> attr_list; //List of attributes
//	Element L; //An element of the pairing group
//	HashMap<String,Element> k_i; //Map of valid attributes and element
//	HashMap<Integer,Element> k_y;//Map of valid memberID and element
	
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
	
}
