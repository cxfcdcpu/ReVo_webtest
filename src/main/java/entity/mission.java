package entity;

import java.sql.Timestamp;
import java.util.Random;

import revoabe.MasterKey;
import revoabe.PublicKey;
import revoabe.ReVo_ABE;

public class mission {
	private String missionName;
	private String missionCode;
	private Timestamp startTime;
	private Timestamp endTime;
	private byte g1_alpha[];
	private byte beta[];
	private int capacity;
	private byte g1[];
	private byte g2[];
	private byte g2_beta[];
	private byte e_gg_alpha[];
	private byte g1_a[];
	
	public mission(String missionName, int capacity) {
		this.missionName = missionName;
		this.capacity = capacity;
		this.randomMissionCode();
	}
	
	public void randomMissionCode() {
		Random rand = new Random();
		this.missionCode = String.valueOf(rand.nextInt(2000000000));
	}
	
	public void setMissionCode(String code) {
		this.missionCode = code;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	public void setupKeysFromReVo(ReVo_ABE revoABE) {
		this.capacity=revoABE.getNodeCount();
		this.setupPublicKey(revoABE.getPublicKey());
		this.setupMasterKey(revoABE.getMasterKey());
	}
	
	public void setupPublicKey(PublicKey pk) {
		g1 = pk.getG1();
		g2 = pk.getG2();
		g1_a = pk.getG1a();
		g2_beta = pk.getG2_beta();
		e_gg_alpha = pk.getE_gg_alpha();
	}
	
	public void setupMasterKey(MasterKey mk) {
		beta = mk.getBeta();
		g1_alpha = mk.getG1_alpha();
	}
	
	public String getMissionName() {
		return missionName;
	}
	
	public String getMissionCode() {
		return missionCode;
	}
	
	public Timestamp getStartTime() {
		return startTime;
	}
	
	public Timestamp getEndTime() {
		return endTime;
	}
	
	public byte[] getG1() {
		return g1;
	}
	
	public byte[] getG2() {
		return g2;
	}
	public byte[] getG1a() {
		return g1_a;
	}
	public byte[] getG2_beta() {
		return g2_beta;
	}
	public byte[] getE_gg_alpha() {
		return e_gg_alpha;
	}
	
	
	public byte[] getG1_alpha() {
		return g1_alpha;
	}
	
	public byte[] getBeta() {
		return beta;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	
	

}