package managerAPI;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import db.DBConnection;
import db.DBConnectionFactory;
import entity.mission;

/**
 * Servlet implementation class UpdateMission
 */
@WebServlet("/UpdateMission")
public class UpdateMission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OutputStream os = response.getOutputStream();
		DBConnection conn = DBConnectionFactory.getConnection();
		try {
				JSONObject input = HelperFunctions.readJsonObject(request);
				String missionName = input.getString("OldMissionName").trim();
				String newMissionName = input.getString("NewMissionName").trim();
				int capacity = input.getInt("capacity");
				String startTime = input.getString("startTime").trim();
				String endTime = input.getString("endTime").trim();
				Timestamp ts_startTime = HelperFunctions.convertStringToTimestamp(startTime);
				Timestamp ts_endTime = HelperFunctions.convertStringToTimestamp(endTime);
				System.out.println(String.format("%s,%d,%s,%s",missionName,capacity,startTime,endTime));
				
				mission curMission = new mission(newMissionName,capacity,ts_startTime,ts_endTime);
				mission existingMission = conn.searchMission(missionName);
				
				if (existingMission == null && conn.insertMission(curMission)) {
					
					System.out.println("Old mission not exists but new mission insert successfully added");
					response.sendError(204);
				}
				else {
					existingMission.setMissionName(newMissionName);
					existingMission.setStartTime(ts_startTime);
					existingMission.setEndTime(ts_endTime);
					if(existingMission.getCapacity()!=capacity) {
						existingMission.setMissionCapacity(capacity);
						//existingMission.revo_ABE_setup();
					}
					
					conn.updateMission(existingMission);
					System.out.println("mission update successfully");
					response.sendError(200);
				}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(500);
			
		}finally {
			conn.close();
			os.close();
		}
	}

}
