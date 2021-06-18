package db;
import java.util.List;
import java.util.Set;

import java.sql.*;

import entity.mission;
import entity.user;
public interface DBConnection {

	public void close();
	
	public user searchUser(String username);
	
	public boolean verifyLogin(String username, String password);
	
	public boolean insertUser(String username,String password,String attributes, String firstname, String lastname);

	public boolean insertMission(String missionName, String missionCode, String endTime, int capacity, String masterKeys, String publicKeys);

	public mission searchMission(String missionName);
	
	public mission searchMissionByCode(String missionCode);
}
