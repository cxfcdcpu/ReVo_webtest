package db;
import java.util.List;
import java.util.Set;

import java.sql.*;

import entity.MissionInfo;
import entity.mission;
import entity.user;
public interface DBConnection {

	public void close();
	
	public user searchUser(String username);
	
	public List<MissionInfo> getAllMissions();
	
	public boolean verifyLogin(String username, String password);
	
	public boolean insertUser(user us);

	public boolean insertMission(mission ms);

	public mission searchMission(String missionName);
	
	public mission searchMissionByCode(String missionCode);
}
