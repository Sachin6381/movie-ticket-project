package com.MovieTicketBookingDao;

import java.util.List;


public interface Theatreinformation {
	public void insert(Theatreinformation theatre ) ;
	
	public void update(Theatreinformation theatre2 ) ;
	
	 public void delete(Theatreinformation theatre3 ) ;
	 
	 public  void findmytheatre(Theatreinformation M1) ;
	 
	 public List<Theatreinformation> showtheatre(); 
	 
	 

}
