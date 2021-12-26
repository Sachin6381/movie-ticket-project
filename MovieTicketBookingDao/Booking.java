package com.MovieTicketBookingDao;

import java.sql.ResultSet;
import java.util.List;

import com.Movieticketbookingpojo.Bookingdetail;

public interface Booking {

	public void insert(Bookingdetail Booking);
	
	public void update(Bookingdetail Booking);
	
	 public int delete(Bookingdetail Booking );
	 
	  public ResultSet Showbooking (int bookingid);
	  
	  public List<Bookingdetail> showBooking();
}
