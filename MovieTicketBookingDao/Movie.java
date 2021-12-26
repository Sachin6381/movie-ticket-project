package com.MovieTicketBookingDao;

import java.util.List;



public interface Movie {

	public void insert(Movie Movie ) ;
	
	public  void searchmovie(Movie Movie1) ;
	
	public  void update(Movie Movie2 );
	
	 public void delete(Movie Movie3 );
	 
	 public List<Movie> showMovie();
	 
	 
}
