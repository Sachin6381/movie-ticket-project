package com.Movieticketbookingpojo;

public class User {
	  private int user_id;
  
	private String user_name ;
      private String gender;
      private String email_id;
      private long mobile_num;
      private String e_password;
      private int wallet;
      public int getwallet() {
		return wallet;
	}
	
	public int getUser_id() {
  		return user_id;
  	}
  	public void setUser_id(int user_id) {
  		this.user_id = user_id;
  	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public long getMobile_num() {
		return mobile_num;
	}
	public void setMobile_num(long mobile_num) {
		this.mobile_num = mobile_num;
	}
	public String getE_password() {
		return e_password;
	}
	public void setE_password(String e_password) {
		this.e_password = e_password;
	}
	@Override
	public String toString() {
		return "Mv4project [user_name=" + user_name + ", gender=" + gender + ", email_id="
				+ email_id + ", mobile_num=" + mobile_num + ", e_password=" + e_password + "]";
	}
	public User(String user_name, String gender, String email_id, long mobile_num,
			String e_password) {
		super();
		this.user_name = user_name;
		this.gender = gender;
		this.email_id = email_id;
		this.mobile_num = mobile_num;
		this.e_password = e_password;
	}
	
	public User(String user_name, String email_id, String e_password) {
		super();
		this.user_name = user_name;
		this.email_id = email_id;
		this.e_password = e_password;
	}
	public User(String user_name,int userId, String email_id, String e_password) {
		super();
		this.user_name = user_name;
		this.user_id=userId;
		this.email_id = email_id;
		this.e_password = e_password;
	}
	public User(int userId) {
		
		this.user_id=userId;
		
	}
	

	public User(int user_id,
			int wallet) {
		super();
		this.user_id = user_id;
		
		this.wallet = wallet;
	}

	public User(int user_id, String user_name, String gender, String email_id, long mobile_num, String e_password,
			int wallet) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.gender = gender;
		this.email_id = email_id;
		this.mobile_num = mobile_num;
		this.e_password = e_password;
		this.wallet = wallet;
	}

	public User(long mobile, String email) {
		// TODO Auto-generated constructor stub
		this.mobile_num = mobile;
		this.email_id = email;
	}
	public User(String email1, String password) {
		// TODO Auto-generated constructor stub
		this.email_id=email1;
		this.e_password=password;
	}
	public User(String  user_name) {
		// TODO Auto-generated constructor stub
		this.user_name = user_name;
	}

	public User(String string, int int1, String string2, String string3, int int2, String string4, int int3) {
		// TODO Auto-generated constructor stub
	}

	public User( String user_name, String gender, String email_id, long mobile_num, String e_password,
			int wallet) {
		super();
	
		this.user_name = user_name;
		this.gender = gender;
		this.email_id = email_id;
		this.mobile_num = mobile_num;
		this.e_password = e_password;
		this.wallet = wallet;
	}

		

	}
      
