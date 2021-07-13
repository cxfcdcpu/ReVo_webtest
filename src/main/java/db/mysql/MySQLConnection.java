/**
 * 
 */
package db.mysql;
import db.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.MissionInfo;
import entity.mission;
import entity.user;

/**
 * @author XiaofeiCao
 *
 */
public class MySQLConnection implements DBConnection{

	
	private Connection conn;

	public MySQLConnection() {
	// Step 1 Connect to MySQL.
		try {
			System.out.println("Connecting to " + MySQLDBUtil.URL);
			Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
			conn = DriverManager.getConnection(MySQLDBUtil.URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Override
	public boolean verifyLogin(String username, String password) {
		// TODO Auto-generated method stub
		
		user curUser= searchUser(username);
		if(curUser!=null && curUser.getHashedPassword().equals(password)) {
			return true;
		}
		
		return false;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public user searchUser(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user WHERE username = '"+username+"';";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				user curUser = new user(rs.getString("username"),rs.getString("password")
						);
				curUser.setAttributes(rs.getString("attributes"));
				//curUser.setFirstname("first");
				//curUser.setLastname("Last");
				return curUser;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	

	@Override
	public boolean insertUser(user us) {
		

		String sql = "INSERT INTO user (username,password,attributes,firstname,lastname)"
				+ "VALUES (?,?,?,?,?);";
		try {
			
			user curUser = searchUser(us.getUsername());
			if(curUser == null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, us.getUsername());
				stmt.setString(2, us.getPassword());
				stmt.setString(3, us.getAttributes());
				stmt.setString(4, us.getFirstname());
				stmt.setString(5, us.getLastname());
				stmt.executeUpdate();
				return true;
			}
			else {
				
				System.out.println("User already exisits");
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;
	}

	@Override
	public boolean insertMission(mission ms) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO mission (missionName,missionCode,endTime,capacity,g1_alpha,beta,g1,g2,g2_beta,e_gg_alpha,g1_a)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		try {
			mission curMission1 = searchMission(ms.getMissionName());
			mission curMission2 = searchMissionByCode(ms.getMissionCode());
			if(curMission1 == null && curMission2 == null) {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, ms.getMissionName());
				stmt.setString(2, ms.getMissionCode());
				stmt.setTimestamp(3, ms.getEndTime());
				stmt.setInt(4, ms.getCapacity());
				stmt.setBytes(5, ms.getG1_alpha());
				stmt.setBytes(6, ms.getBeta());
				stmt.setBytes(7, ms.getG1());
				stmt.setBytes(8, ms.getG2());
				stmt.setBytes(9, ms.getG2_beta());
				stmt.setBytes(10, ms.getE_gg_alpha());
				stmt.setBytes(11, ms.getG1a());
				stmt.executeUpdate();
				return true;
			}
			else {
				System.out.println("Mission already exisits");
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public mission searchMission(String missionName) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM mission WHERE missionName = '"+missionName+"';";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				mission curMission = new mission(rs.getString("missionName"),rs.getInt("capacity")
						);
				curMission.setMissionCode(rs.getString("missionCode"));
				curMission.setStartTime(rs.getTimestamp("startTime"));
				curMission.setEndTime(rs.getTimestamp("endTime"));
				return curMission;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public mission searchMissionByCode(String missionCode) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM mission WHERE missionCode = '"+missionCode+"';";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				mission curMission = new mission(rs.getString("missionName"),rs.getInt("capacity")
						);
				curMission.setMissionCode(rs.getString("missionCode"));
				curMission.setStartTime(rs.getTimestamp("startTime"));
				curMission.setEndTime(rs.getTimestamp("endTime"));
				curMission.setupPublicKey(rs.getBytes("g1"), rs.getBytes("g2"), rs.getBytes("g2_beta"), rs.getBytes("g1_a"), rs.getBytes("e_gg_alpha"));
				return curMission;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<MissionInfo> getAllMissions() {
		String sql = "SELECT * FROM mission";
		List<MissionInfo> res = new ArrayList<MissionInfo>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				res.add(new MissionInfo(rs.getString("missionName"),rs.getString("missionCode"),rs.getInt("capacity")));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public List<user> getAllUsers() {
		String sql = "SELECT * FROM user";
		List<user> res = new ArrayList<user>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				res.add(new user(rs.getString("username"),rs.getString("firstname"),rs.getString("lastname")));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	

}
