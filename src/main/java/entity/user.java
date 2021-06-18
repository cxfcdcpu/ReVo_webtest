package entity;

public class user {
	private String username;
	private String password;
	private String attributes;
	private String firstname;
	private String lastname;
	
	public user(String un, String pw) {
		this.username = un;
		this.password = pw;
	}
	
	public void setFirstname(String first) {
		this.firstname = first;
	}
	public void setLastname(String last) {
		this.lastname = last;
	}
	
	public void setAttributes(String attr) {
		this.attributes = attr;
	}
	
	
	public String getHashedPassword() {
		return this.password;
	}
}
