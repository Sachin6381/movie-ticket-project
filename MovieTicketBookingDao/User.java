package com.MovieTicketBookingDao;

import java.util.List;

public interface User {
	public void insert(User User);
	
	public  User validateUser(String useremail, String userpassword);
	
	public User updateUser(User user1) ;
	
	public User updateUser1(User user2);
	
	public void deleteUser2(User user3);
	
	public int getwallet(User user);
	
	public int updatewallet(User user);
	
	public List<User> showUser() ;

}
