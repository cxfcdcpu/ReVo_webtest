package rpc;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class RpcHelper {
	public static JSONObject readJsonObject(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = request.getReader();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			return new JSONObject(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}
	
	public static Timestamp convertStringToTimestamp(String strDate) {
	    try {
	      DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
	       // you can change format of date
	      Date date = formatter.parse(strDate);
	      Timestamp timeStampDate = new Timestamp(date.getTime());

	      return timeStampDate;
	    } catch (Exception e) {
	      System.out.println("Exception :" + e);
	      
	      return null;
	    }
	  }
	
	
	public static void writeJsonString(HttpServletResponse response, String obj) {
		try {
			response.setContentType("application/json");
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter out = response.getWriter();
			out.print(obj);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeJsonObject(HttpServletResponse response, JSONObject obj) {
		try {
			response.setContentType("application/json");
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter out = response.getWriter();
			out.print(obj);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static String dummyPrivateKey() {
		return "this is a dummy PrivateKey";
	}
	
	public static String dummyPublicKey() {
		return "this is a dummy public key";
	}
	

	
}
