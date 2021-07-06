package rpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.DBConnection;
import db.DBConnectionFactory;
import entity.mission;

/**
 * Servlet implementation class Bootstrap
 */
@WebServlet("/Bootstrap")
public class Bootstrap extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Bootstrap() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();

		out.print("The get is doing nothing right now");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OutputStream os = response.getOutputStream();
		DBConnection conn = DBConnectionFactory.getConnection();
		try {
				JSONObject input = RpcHelper.readJsonObject(request);
				String username = input.getString("username");
				String password = input.getString("password");
				String missionCode = input.getString("missionCode");
				
				mission curMission = conn.searchMissionByCode(missionCode);
				if (conn.verifyLogin(username, password) && curMission !=null) {
					response.setContentType("keys");
					byte[] res = curMission.toPublicKeyByteArray();
					response.setContentLength(res.length);
					os.write(res);
				}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("*.*failed to get keys");
		}finally {
			conn.close();
			os.close();
		}
		
		

	}
	


}
