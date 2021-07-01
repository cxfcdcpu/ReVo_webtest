package test;
import db.*;
import db.mysql.*;
public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection connection = DBConnectionFactory.getConnection();
		if(connection.insertUser("dummy1", "1234", "dummy", "mm", "dd")) {
			System.out.println("insert successfully");
		}
		else {
			System.out.println("Fail to insert");
		}
	}

}
