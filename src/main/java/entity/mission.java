package entity;

import java.sql.Timestamp;

public class mission {
	private String missionName;
	private String missionCode;
	private Timestamp startTime;
	private Timestamp endTime;
	private String masterKeys;
	private String publicKeys;
	private int capacity;
	
	public mission(String missionName, int capacity) {
		this.missionName = missionName;
		this.capacity = capacity;
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
	

}