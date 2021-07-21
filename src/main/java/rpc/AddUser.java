package rpc;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import db.DBConnection;
import db.DBConnectionFactory;
import entity.MissionInfo;
import entity.mission;
import entity.user;
import qrcode.QRCodeHelper;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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
				JSONObject input = RpcHelper.readJsonObject(request);
				String username = input.getString("username").trim();
				String password = input.getString("password").trim();
				String firstname = input.getString("firstname").trim();
				String lastname = input.getString("lastname").trim();
				JSONArray attributes = input.getJSONArray("attributes");
				System.out.println(attributes);
				List<String> attr = new ArrayList<String>();
				if (attributes != null) { 
					   for (int i=0;i<attributes.length();i++){
						   //System.out.println(attributes.getString(i));
						   attr.add(attributes.getString(i));
					   } 
				} 
		        
				System.out.println(String.format("%s,%s,%s,%s",username,password,firstname,lastname));
				
				user curUser = new user(username,password,firstname,lastname, attr);
				user existingUser = conn.searchUser(username);
				if (existingUser == null && conn.insertUser(curUser)) {
					
					System.out.println("user successfully added");
					response.sendError(200);
				}
				else {
					System.out.println("user can't be added");
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
