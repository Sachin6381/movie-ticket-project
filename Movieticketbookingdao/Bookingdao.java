package com.Movieticketbookingdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.Movieticketbookingpojo.Bookingdetail;
import com.connection.Connectionmv4;

public class Bookingdao {
	public void insert(Bookingdetail Booking) {
	       String  query="insert into booking_detail(user_id,theatre_id,no_seats,total_amount,booking_status,movie_name) values (?,?,?,?,?,?)";
		
			try {
			Connection	con = Connectionmv4.DBConnection();
				PreparedStatement Pstmt1 = con.prepareStatement(query);
			
				Pstmt1.setInt(1,Booking.getUser_id());
				
				Pstmt1.setInt(2,Booking.getTheatre_id());
				Pstmt1.setInt(3,Booking.getNo_seat());
				Pstmt1.setInt(4,Booking.getTotal_amount());
				Pstmt1.setString(5,Booking.getBooking_status());
				Pstmt1.setString(6, Booking.getMovie_name());
				
				int i = Pstmt1.executeUpdate();

				//System.out.println("Booking Success");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public void update(Bookingdetail Booking)  {
		
		    String query="update booking_detail set booking_status=? where booking_id=? ";

		try {
			Connection con = Connectionmv4.DBConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, Booking.getBooking_status());
			pstmt.setInt(2, Booking.getBooking_id());
	        int i = pstmt.executeUpdate();
			
			System.out.println("Booking Cancel Success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
      public int delete(Bookingdetail Booking )  {
		
	        String query="delete from theatre where Booking_id=? ";
		
		try {
		     Connection	con = Connectionmv4.DBConnection();
             PreparedStatement pstmt = con.prepareStatement(query);
		     pstmt.setInt(1,Booking.getBooking_id());
	         int i = pstmt.executeUpdate();
		
   		     System.out.println(i+"rows deleted successfully");



		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  return 0; 
      }
		  
		  public ResultSet Showbooking (int bookingid) throws ClassNotFoundException, SQLException {
			  String query="select * from booking_detail where booking_id=? ";
			  Connection	con = Connectionmv4.DBConnection();
			  PreparedStatement pstmt = con.prepareStatement(query);
			  pstmt. setInt(1,bookingid);
			  ResultSet rs =pstmt.executeQuery();
			  return rs;
			  
		  }
		    

}
			
		
              
