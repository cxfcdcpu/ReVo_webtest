package managerAPI;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import db.DBConnection;
import db.DBConnectionFactory;
import entity.mission;
import entity.user;

/**
 * Servlet implementation class AddMission
 */
@WebServlet("/AddMission")
public class AddMission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
    
    
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OutputStream os = response.getOutputStream();
		DBConnection conn = DBConnectionFactory.getConnection();
		try {
				JSONObject input = HelperFunctions.readJsonObject(request);
				String missionName = input.getString("missionName").trim();
				int capacity = input.getInt("capacity");
				String startTime = input.getString("startTime").trim();
				String endTime = input.getString("endTime").trim();
				Timestamp ts_startTime = HelperFunctions.convertStringToTimestamp(startTime);
				Timestamp ts_endTime = HelperFunctions.convertStringToTimestamp(endTime);
				System.out.println(String.format("%s,%d,%s,%s",missionName,capacity,startTime,endTime));
				
				mission curMission = new mission(missionName,capacity,ts_startTime,ts_endTime);
				mission existingMission = conn.searchMission(missionName);
				if (existingMission == null && conn.insertMission(curMission)) {
					
					System.out.println("mission successfully added");
					response.sendError(200);
				}
				else {
					System.out.println("mission can't be added");
					response.sendError(204);
				}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			conn.close();
			os.close();
		}
	}

}
