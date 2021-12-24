package com.Movieticketbookingpojo;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Timer;

public class Theatreinformation {
	private String theatre_name;
    private int movie_id;
    private int theatre_id;
    private int  number_seats;
    private String theatre_address;
    private int  theatre_rating;
    private int price;
    private LocalDateTime movie_date_time;
	
    public Theatreinformation(String theatre_name, int movie_id2,int theatre_id, int number_seats, String theatre_address, int theatre_rating, LocalDateTime movie_date_time,
			int price) {
    	super();
		this.theatre_name = theatre_name;
		this.movie_id = movie_id2;
	    this.theatre_id=theatre_id;
		this.number_seats = number_seats;
		this.theatre_address = theatre_address;
		this.theatre_rating = theatre_rating;
		this.price = price;
		this.movie_date_time = movie_date_time;
	}
    
    
//    public Theatreinformation(String theatre_name, int movie_id, int theatre_id, int number_seats,
//			String theatre_address, int theatre_rating, int price, LocalDateTime movie_date_time) {
//		
//	}
	public Theatreinformation(String theatre_name, int movie_id, int number_seats, String theatre_address,
			int theatre_rating, int price, LocalDateTime movie_date_time) {
		super();
		this.theatre_name = theatre_name;
		this.movie_id = movie_id;
		this.number_seats = number_seats;
		this.theatre_address = theatre_address;
		this.theatre_rating = theatre_rating;
		this.price = price;
		this.movie_date_time = movie_date_time;
	}
	@Override
	public int hashCode() {
		return Objects.hash(movie_date_time, movie_id, number_seats, price, theatre_address, theatre_id, theatre_name,
				theatre_rating);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theatreinformation other = (Theatreinformation) obj;
		return Objects.equals(movie_date_time, other.movie_date_time) && movie_id == other.movie_id
				&& number_seats == other.number_seats && price == other.price
				&& Objects.equals(theatre_address, other.theatre_address) && theatre_id == other.theatre_id
				&& Objects.equals(theatre_name, other.theatre_name) && theatre_rating == other.theatre_rating;
	}
	@Override
	public String toString() {
		return "Theatreinformation \ntheatre_name=" + theatre_name + "\n movie_id=" + movie_id + "\n theatre_id="
				+ theatre_id + "\n number_seats=" + number_seats + "\n theatre_address=" + theatre_address
				+ "\n theatre_rating=" + theatre_rating + "\n price=" + price + "\n movie_date_time=" + movie_date_time
				+ "\n\n";
	}
	public String getTheatre_name() {
		return theatre_name;
	}
	public void setTheatre_name(String theatre_name) {
		this.theatre_name = theatre_name;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public int getTheatre_id() {
		return theatre_id;
	}
	public void setTheatre_id(int theatre_id) {
		this.theatre_id = theatre_id;
	}
	public int getNumber_seats() {
		return number_seats;
	}
	public void setNumber_seats(int number_seats) {
		this.number_seats = number_seats;
	}
	public String getTheatre_address() {
		return theatre_address;
	}
	public void setTheatre_address(String theatre_address) {
		this.theatre_address = theatre_address;
	}
	public int getTheatre_rating() {
		return theatre_rating;
	}
	public void setTheatre_rating(int theatre_rating) {
		this.theatre_rating = theatre_rating;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDateTime getMovie_date_time() {
		return movie_date_time;
	}
	public void setMovie_date_time(LocalDateTime movie_date_time) {
		this.movie_date_time = movie_date_time;
	}
	public Theatreinformation(String theatrename1, int theatreid1) {
		// TODO Auto-generated constructor stub
		this.theatre_name=theatrename1;
		this.theatre_id=theatreid1;
	}
	public Theatreinformation(int theatreid21) {
		// TODO Auto-generated constructor stub
		this.theatre_id=theatreid21;
	}
	public Theatreinformation(String string, int int1, String string2, int int2, int int3, String string3,
			String string4) {
		// TODO Auto-generated constructor stub
	}
	public Theatreinformation(String string, int int1, int int2, String string2, int int3, String string3,
			String string4) {
		// TODO Auto-generated constructor stub
	}
	
	public static void add1(Theatreinformation mvtheatre) {
		// TODO Auto-generated method stub
		
	}
	
    
}