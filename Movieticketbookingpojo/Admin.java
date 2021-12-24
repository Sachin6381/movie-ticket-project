package com.Movieticketbookingpojo;

public class Admin {
	private String email_id;
	private String password;
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [email_id=" + email_id + ", password=" + password + "]";
	}
	public Admin(String email_id, String password) {
		super();
		this.email_id = email_id;
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String string, String email_id2, String password2) {
		// TODO Auto-generated constructor stub
	}
}