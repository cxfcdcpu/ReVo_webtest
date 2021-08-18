package entity;

public class MissionInfo {
	public String MissionName;
	public String MissionCode;
	public int MissionCapacity;
	public String StartTime;
	public String EndTime;
	
	public MissionInfo(String name, String code, int capacity, String start, String end) {
		MissionName = name;
		MissionCode = code;
		MissionCapacity = capacity;
		StartTime = start;
		EndTime = end;
	}
	
	public String toString() {
		return "["+MissionName+" "+MissionCode+" "+MissionCapacity+" "+StartTime+" "+EndTime+"]";
	}
}
