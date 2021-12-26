package com.MovieTicketBookingDaoImpl;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Movieticketbookingpojo.Movie;
import com.Movieticketbookingpojo.User;
import com.connection.Connectionmv4;
import com.MovieTicketBookingDao.*;



public class userdao {
	public void insert(User User) {
		String query = "insert into user_details(user_name,user_id,gender,email_id,mobile_num,e_password,wallet) values (?,?,?,?,?,?,?)";

		try {
			Connection con = Connectionmv4.DBConnection();
			PreparedStatement Pstmt1 = con.prepareStatement(query);
			Pstmt1.setString(1, User.getUser_name());
			Pstmt1.setString(2, User.getGender());
			Pstmt1.setString(3, User.getEmail_id());
			Pstmt1.setLong(4, User.getMobile_num());
			Pstmt1.setString(5, User.getE_password());
			int i = Pstmt1.executeUpdate();

			System.out.println("Registration Completed");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public  User validateUser(String useremail, String userpassword) {
		Statement stmt = null;
		User ob = null;
		Connection con = null;
		try {
			con = Connectionmv4.DBConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String query = "select * from user_details where email_id='" + useremail + "' and e_password='" + userpassword
				+ "'";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				ob = new User(rs.getString(1), rs.getInt(2), useremail, userpassword);
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ob;

	}

	public User updateUser(User user1)  {

		Connectionmv4 conect = new Connectionmv4();
		Connection con;
		try {
			con = conect.DBConnection();
		String updateQuery = "update user_details set email_id=? where mobile_num=?";
		PreparedStatement pstmt = con.prepareStatement(updateQuery);
		pstmt.setString(1, user1.getEmail_id());
		pstmt.setLong(2, user1.getMobile_num());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			System.out.println("Updated");
			User user = new User(rs.getString(1), rs.getString(3));
			return user;

		}}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public User updateUser1(User user2)  {
		// System.out.println(user2.getEmail_id());
		// System.out.println(user2.getE_password());
 try {
		Connectionmv4 conect = new Connectionmv4();

		Connection con = conect.DBConnection();
		String updateQuery = "update user_details set e_password=? where  email_id=?";
		PreparedStatement pstmt = con.prepareStatement(updateQuery);
		pstmt.setString(2, user2.getEmail_id());
		pstmt.setString(1, user2.getE_password());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			System.out.println("Updated");
			User user = new User(rs.getString(3), rs.getString(5));
			return user;

		}}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void deleteUser2(User user3) {
		Connectionmv4 conect = new Connectionmv4();
		Connection con;
		try {
			con = conect.DBConnection();
			String deleteQuery = "delete from user_details where user_name=?";
			PreparedStatement pstmt = con.prepareStatement(deleteQuery);
			pstmt.setString(1, user3.getUser_name());
			int rs = pstmt.executeUpdate();

			System.out.println("deleted");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// get wallet:
	public int getwallet(User user) {
		String query = "select wallet from user_details where user_id in ?";

		try {
			Connection con = Connectionmv4.DBConnection();
			PreparedStatement Pstmt1 = con.prepareStatement(query);
			Pstmt1.setInt(1, user.getUser_id());

			ResultSet rs = Pstmt1.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				return rs.getInt(1);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

//update wallet:
	public int updatewallet(User user) {
		String query = "update user_details set wallet = ? where user_id in ?";

		try {
			Connection con = Connectionmv4.DBConnection();
			PreparedStatement Pstmt1 = con.prepareStatement(query);
			Pstmt1.setInt(1, user.getwallet());
			Pstmt1.setInt(2, user.getUser_id());

			int rs = Pstmt1.executeUpdate();
			Pstmt1.executeUpdate("commit");

			return rs;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public List<User> showUser() throws ClassNotFoundException, SQLException {
		
		List<User> userList=new ArrayList<User>();
		User userproducts=null;
		
		String showQuery="select * from user_details";
		Connectionmv4 connection =new Connectionmv4();
		Connection con=connection.DBConnection();
	    Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(showQuery);
		while(rs.next()) {
			
	    userproducts=new  User(rs.getString(1),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getInt(7));
//		System.out.println(rs.getString(3));
	    userList.add(userproducts);
	  
		}
		
		 return userList;
		
		
	}

}
