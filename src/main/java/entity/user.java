package entity;

import java.util.ArrayList;
import java.util.List;

public class user {
	private String username;
	private String password;
	private List<String> attributes;
	private String firstname;
	private String lastname;
	
	public user(String un, String pw) {
		this.username = un;
		this.password = pw;
		this.attributes=new ArrayList<String>();
	}
	
	public void setFirstname(String first) {
		this.firstname = first;
	}
	public void setLastname(String last) {
		this.lastname = last;
	}
	
	public void addAttributes(String attr) {
		this.attributes.add(attr);
	}
	
	public void setAttributes(String attrs) {
		for(String attr: attrs.split(",")) {
			this.addAttributes(attr);
		}
	}
	
	
	public String getHashedPassword() {
		return this.password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getAttributes() {
		StringBuilder sb = new StringBuilder();
		for(String attr:attributes) {
			sb.append(attr);
			sb.append(",");
		}
		if (sb.length()<=0) {
			return "";
		}
		return sb.substring(0, sb.length()-1);
	}
	
	
}
