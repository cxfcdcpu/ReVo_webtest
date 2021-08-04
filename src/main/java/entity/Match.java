package entity;

import java.sql.Timestamp;
import java.util.Arrays;
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
	private List<String> attrSizes;
	private byte[] k_is;
	private List<String> revoNodes;
	private List<String> revoNodeSizes;
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
	
	public void setUserTreeID(int nID) {
		this.user_tree_id = nID;
		this.keyGen();
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
	
	
	public void assignPrivateKey(byte[] l, String attrs, String attrSizes, byte[] kis, String nodes, String nodeSizes, byte[] kys) {
		this.L = l;
		this.k_is = kis;
		this.k_ys = kys;
		this.attributes = Match.stringToStringList(attrs);
		this.attrSizes = Match.stringToStringList(attrSizes);
		this.revoNodes = Match.stringToStringList(nodes);
		this.revoNodeSizes = Match.stringToStringList(nodeSizes);
		
	}
	
	
	public int getMissionID() {
		return this.ms.getMissionID();
	}
	
	public int getUserID() {
		return this.ur.getUserID();
	}
	
	public int getUserTreeID(){
		return this.user_tree_id;
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
	
	public List<String> attrSizes(){
		return this.attrSizes;
	}
	
	public String getAttrSizesString() {
		return String.join(",", this.attrSizes);
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
	
	public List<String> getReVoNodeSizes(){
		return this.revoNodeSizes;
	}
	
	public String getReVoNodeSizesString() {

		return String.join(",", this.revoNodeSizes);
	}
	
	public byte[] getKYs() {
		return this.k_ys;
	}
	
	public Timestamp getRegisterationTime() {
		return this.registerationTime;
	}
	
	public static List<String> stringToStringList(String str){
		return Arrays.asList(str.split(","));
	}
	
	public void printMatch() {
		System.out.println("Mission: "+this.ms.getMissionName());
		System.out.println("User: "+this.ur.getUsername());
	}
	

	
}
