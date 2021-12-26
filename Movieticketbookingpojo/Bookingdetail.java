package com.Movieticketbookingpojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.MovieTicketBookingDaoImpl.Bookingdao;

public class Bookingdetail {
	private int booking_id;
	private int user_id ;
	private int theatre_id;
	private int no_seat;
	private int total_amount;
	private String booking_status;
	private String movie_name;
	
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTheatre_id() {
		return theatre_id;
	}
	public void setTheatre_id(int theatre_id) {
		this.theatre_id = theatre_id;
	}
	public int getNo_seat() {
		return no_seat;
	}
	public void setNo_seat(int no_seat) {
		this.no_seat = no_seat;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public String getBooking_status() {
		return booking_status;
	}
	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}

	
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	@Override
	public String toString() {
		return "Bookingdetail \nbooking_id=" + booking_id + "\n user_id=" + user_id + "\n theatre_id=" + theatre_id
				+ "\n no_seat=" + no_seat + "\n total_amount=" + total_amount + "\n booking_status=" + booking_status
				+ "\n\n";
	}
	public Bookingdetail( int user_id, int theatre_id, int no_seat, int total_amount,
			String booking_status,String movie_name) {
		super();
		
		this.user_id = user_id;
		this.theatre_id = theatre_id;
		this.no_seat = no_seat;
		this.total_amount = total_amount;
		this.booking_status = booking_status;
		this.movie_name=movie_name;
	}
	public Bookingdetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bookingdetail(int bookingid2, Bookingdao bookd2) {
		// TODO Auto-generated constructor stub
	}
	public Bookingdetail(String status, int bookingid2) {
		// TODO Auto-generated constructor stub
		this.booking_status=status;
		this.booking_id=bookingid2;
	}
	
}
		
	





