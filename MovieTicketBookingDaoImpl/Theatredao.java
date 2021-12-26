package com.MovieTicketBookingDaoImpl;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Movieticketbookingpojo.Movie;
import com.Movieticketbookingpojo.Theatreinformation;
import com.connection.Connectionmv4;

public class Theatredao {
	public void insert(Theatreinformation theatre ) {
		    System.out.println(theatre.getMovie_date_time());
	        String  query="insert into theatre(theatre_name, movie_id,number_seats,theatre_address,theatre_rating,movie_date_time,price) values (?,?,?,?,?,?,?)";
			Connection con;
			try {
				Connection 	con1 = Connectionmv4.DBConnection();
				PreparedStatement Pstmt1 = con1.prepareStatement(query);
			    Pstmt1.setString(1,theatre.getTheatre_name());
			    Pstmt1.setInt(2,theatre.getMovie_id());
			    Pstmt1.setInt(3,theatre.getNumber_seats());
			    Pstmt1.setString(4,theatre.getTheatre_address());
			    Pstmt1.setInt(5,theatre.getTheatre_rating());
			    java.sql.Timestamp mvDateTime = java.sql.Timestamp.valueOf(theatre.getMovie_date_time());
			    Pstmt1.setTimestamp(6,java.sql.Timestamp.valueOf(theatre.getMovie_date_time()));
			    Pstmt1.setInt(7,theatre.getPrice());
			    
				int i = Pstmt1.executeUpdate();

				System.out.println(i+"rows inserted successfully");
				
			} catch (ClassNotFoundException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			} catch (SQLException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			}
	}
			
			
			
			
	public List<Theatreinformation> showtheatre() throws ClassNotFoundException, SQLException {
		
		       List<Theatreinformation> movietheatre=new ArrayList<Theatreinformation>();
	           Theatreinformation mvtheatre=null;
		
		       String showQuery="select * from theatre";
		       Connectionmv4 connection =new Connectionmv4();
		       Connection con=connection.DBConnection();
	           Statement stmt=con.createStatement();
		       ResultSet rs=stmt.executeQuery(showQuery);
		       while(rs.next()) {
               mvtheatre=new  Theatreinformation(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getTimestamp(7).toLocalDateTime(),rs.getInt(8));
//			   System.out.println(rs.getString(3));
               movietheatre.add(mvtheatre);
	  
		        }
		       return movietheatre;
			
	}
	
	public void update(Theatreinformation theatre2 ) {
		
		       
		        
		        String query="update theatre set theatre_name=? where  theatre_id=?  ";
		
		try {
		        Connection	con = Connectionmv4.DBConnection();
                PreparedStatement pstmt = con.prepareStatement(query);
		        pstmt.setString(1,theatre2.getTheatre_name());
	          	pstmt.setInt(2,theatre2.getTheatre_id());
	        	int i = pstmt.executeUpdate();
		
		        System.out.println(i+"rows update successfully");
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			    e.printStackTrace();
		} catch (Exception e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
		}
		
	}
	
    public void delete(Theatreinformation theatre3 )  {
		
	        	 String query="delete from theatre where theatre_id=? ";
	         
		try {
		         Connection	con = Connectionmv4.DBConnection();
                 PreparedStatement pstmt = con.prepareStatement(query);
	        	 pstmt.setInt(1,theatre3.getTheatre_id());
	        	 int i = pstmt.executeUpdate();
		
	             System.out.println(i+"rows deleted successfully");


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
 
   public  void findmytheatre(Theatreinformation M1)  {
			String showQuery="select * from theatre where movie_id=?";
			Connectionmv4 connection =new Connectionmv4();
			Connection con;
			try {
				con = connection.DBConnection();
				PreparedStatement pstmt=con.prepareStatement( showQuery);
			    pstmt.setInt(1,M1.getMovie_id());
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getInt(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8));
				}
			    
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
}
}