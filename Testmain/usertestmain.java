package com.Testmain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.Movieticketbookingdao.Admindao;
import com.Movieticketbookingdao.Bookingdao;
import com.Movieticketbookingdao.Moviedao;
import com.Movieticketbookingdao.Theatredao;
import com.Movieticketbookingdao.userdao;
import com.Movieticketbookingpojo.Admin;
import com.Movieticketbookingpojo.Bookingdetail;
import com.Movieticketbookingpojo.Movie;
import com.Movieticketbookingpojo.Theatreinformation;
import com.Movieticketbookingpojo.User;
import com.connection.Connectionmv4;

public class usertestmain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		Connection con = Connectionmv4.DBConnection();
		// System.out.println("Connection established");
		userdao uDao = new userdao();
		int user_id=0;
		String email_id=null;
		int wallet=0;
		System.out.println("\t welcome Like myshow");
		System.out.println("\n1.Register \n2.Login \n3.Update password\n4.Admin login");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
		case 1:

			String user_name;

			do {
				System.out.println("Enter the user_name");
				user_name = sc.nextLine();

				if (user_name.isEmpty()) {
					System.out.println("user_name is empty");
				}

				if (!user_name.matches("[A-Za-z]{3,}")) {
					System.out.println("Invalid user_name");
				}
			}

			while (!user_name.matches("[A-Za-z]{3,}"));

			String gender;

			do {
				System.out.println("Enter the Gender");
				gender = sc.nextLine();

				if (gender.isEmpty()) {
					System.out.println("gender is empty");
				} else if (!gender.matches("[A-Za-z]")) {
					System.out.println("Invalid gender");
				}
			}

			while (!gender.matches("[A-Za-z]"));

			String emailid1 = null;
			do {
				System.out.println("Enter email ID:");
				emailid1 = sc.nextLine();

				if (emailid1.isEmpty()) {
					System.out.println("email_id is empty");
				} else if (!emailid1.matches("[a-z0-9]+[@][a-z]+[.][a-z]+")) {
					System.out.println("Invalid email_id");
				}
			}

			while (!emailid1.matches("[a-z0-9]+[@][a-z]+[.][a-z]+"));

			String mobile_num;
			do {
				System.out.println("Enter Phone mobile_number:");
				mobile_num = sc.nextLine();

				if (mobile_num.isEmpty()) {
					System.out.println("mobile_num is empty");
				}

				else if (!mobile_num.matches("[6-9]{1}[0-9]{9}")) {
					System.out.println("invalid mobile_num");
				}
			} while (!mobile_num.matches("[6-9]{1}[0-9]{9}"));
			  long mobile_num1 = Long.parseLong(mobile_num);

			String e_password;
			do {
				System.out.println("Enter password:");
				e_password = sc.nextLine();

				if (emailid1.isEmpty()) {
					System.out.println("email_id is empty");
				}

				else if (!e_password.matches("[A-Za-z0-9-@]{8,}")) {
					System.out.println("invalid password");
				}
			}

			while (!e_password.matches("[A-Za-z0-9-@]{8,}"));

			User udao = new User(user_name, gender, emailid1, mobile_num1, e_password);
			uDao.insert(udao);
			
			
			// login
		case 2:

			User user = null;
			
			do {
				System.out.println("login");
				System.out.println("\nenter the register emailid");
				String emailid = sc.nextLine();
				System.out.println("\nenter the current password");
				String password1 = sc.nextLine();
				userdao currentUser = new userdao();
				user = currentUser.validateUser(emailid, password1);
				if (user != null) {
					System.out.println("Login success " + user.getUser_name());
				} else {
					System.out.println("invalid entry");
				}
			} while (user == null);
			
			
			
//			System.out.println("\n1.Show Movie List \n2.Show Theatre List");
//			int choice8 = sc.nextInt();
//			sc.nextLine();
//			switch (choice8) {
//			case 1:
               
			// showquery movielist
			System.out.println("Movielist \n");
			Moviedao product=new Moviedao();
			List<Movie> Products1=product.showMovie();
			for(int i=0;i<Products1.size();i++)
			{
				System.out.println(Products1.get(i));
				
			}

						
		//find mymovie
		
			System.out.println("Find mymovie \n");
			System.out.println("Enter the movieid \n");
			int id1 = Integer.parseInt(sc.nextLine());
			System.out.println("Enter the moviename \n");
			String name=sc.nextLine();
            Moviedao u2=new Moviedao();
            Movie uA1=new Movie(id1,name);
            u2.searchmovie(uA1);
           
           
			
           
             //showtheatre
		
            Theatredao products11=new Theatredao();
			List<Theatreinformation> Products12=products11.showtheatre();
			for(int i=0;i<Products12.size();i++)
			{
				System.out.println(Products12.get(i));
				
			}
			
			
			//find mvtheatre
			
			System.out.println("Find mytheatre \n");
			System.out.println("Enter the movieid \n");
			int movied1 = Integer.parseInt(sc.nextLine());
			System.out.println("Enter the theatreid \n");
			int theatreid4 = Integer.parseInt(sc.nextLine());
			int moviePrice=0;
		
			for(Theatreinformation t:Products12) {
				if(t.getTheatre_id()==theatreid4) {
					moviePrice=t.getPrice();
							
				}
			}
            Moviedao dao2=new Moviedao();
            Movie uao3=new Movie(id1,name);
            dao2.searchmovie(uao3);
            
            
            
            System.out.println("Do you want to Book this movie yes/no");
            String choice1 =sc.nextLine().toLowerCase();
            if(choice1.equals("yes")) {
                 System.out.println("Enter the no of seat");
                 int seat1=Integer.parseInt(sc.nextLine());
                 Bookingdao book=new Bookingdao();
                 Bookingdetail detail=new Bookingdetail(user.getUser_id(),theatreid4,seat1,(moviePrice*seat1),"booked",name);
                 book.insert(detail);
                 System.out.println("enter userid!!");
                 int uid = sc.nextInt();
                 sc.nextLine();
                 User userwall = new User(uid);
                 userdao userdao = new userdao();
                int dedwallbal =  userdao.getwallet(userwall)-180;
                User userwall1 = new User(uid,dedwallbal);
               int res = userdao.updatewallet(userwall1);
               if(res > 0) {
            	   System.out.println("booked Sucessfully!!");
               }else {
            	   System.out.println("something went wrong try again!!");
               }
            }
            
            System.out.println("\n1.View my Booking details  \n2.cancel Booking");
    		int choices = sc.nextInt();
    		sc.nextLine();
    		
    		switch (choices) {
    		case 1:
    			
    			System.out.println("view booking details \n");
    			System.out.println("Enter the Bookingid \n");
    			int Booking =sc.nextInt();
    			sc.nextLine();
                Bookingdao book=new Bookingdao();
               
				ResultSet rs =book.Showbooking(Booking);
                while(rs.next()) {
                    System.out.println("Booking Details:\n"+ "Booking ID:"+rs.getInt(1)+"\n"+ "UserID:"+rs.getInt(2)+"\n"+ "Theatre ID:"+rs.getInt(3)+"\n"+"No Seat:"+rs.getInt(4)+"\n"+"Total amount:"+rs.getInt(5)+"\n"+"Booking Status:"+rs.getString(6)+"\n"+"Movie name:"+rs.getString(7));
                }
                     
    			
    	
    	   		break;
    			
    		case 2:
    			System.out.println("Enter the bookingstatus\n");
    			String status=sc.nextLine();
                System.out.println("Enter the bookingid \n");
                int bookingid2=Integer.parseInt(sc.nextLine());
                Bookingdao bookd2=new Bookingdao();
		        Bookingdetail detail2=new Bookingdetail(status,bookingid2);
		        bookd2.update(detail2);
		        
		// update emailid
          //  break;
    		}
    		break;
		case 3:

			System.out.println("1.forgot emailid\n2.forgot password");
			int forgotemailchoice = Integer.parseInt(sc.nextLine());

			switch (forgotemailchoice) {

			case 1:
				System.out.println("Enter your Register mobilenum");
				long mobile = Long.parseLong(sc.nextLine());
				System.out.println("Enter new emailid");
				String email = sc.nextLine();
				User user1 = new User(mobile, email);
				user = uDao.updateUser(user1);
				if (user != null) {
					System.out.println("Update success ");
				} else {

					System.out.println("invalid entry");
				}
				break;
				
			case 2:

				System.out.println("Enter your Register emailid");
				String email1 = sc.nextLine();
				System.out.println("Enter new password");
				String password = sc.nextLine();
				User user2=new User(email1, password);
				user = uDao.updateUser1(user2);
				if (user != null) {
					System.out.println("Update success ");
				} else {

					System.out.println("invalid entry");
				}
				break;
			}
			
			
			//admin

           case 4:
//        	   System.out.println("1.Admin login\n2.Insert\n3.Update\n4.Delete\n5.Showmovie\n6.Theatreinformation insert\n7.Update\n8.Delete\n9.Showtheatre");
//   			    int admin = Integer.parseInt(sc.nextLine());
        	   Admindao user1=new Admindao();
        	   do
        	   {
        	   System.out.println("Admin");
        	   System.out.println("\nenter the admin emailid");
        	   String emailid2=sc.nextLine();
        	   System.out.println("\nenter the admin password");
        	   String password2=sc.nextLine();
        	   Admindao adminuser=new Admindao();
//        	  user1= adminuser.validate(emailid2, password2);
        	  if(user1!=null) {
        		  System.out.println("admin success");
        	  }
        	  else {
        		  System.out.println("admin notsuccess");
        	  }
           }while(user1==null);  
        	   System.out.println("2.Insert\n3.Update\n4.Delete\n5.Showmovie\n6.Theatreinformation insert\n7.Update\n8.Delete\n9.Showtheatre");
        	   int admin = Integer.parseInt(sc.nextLine());

switch (admin) {
//   			case 1:
        	   
//        	   Admindao user1=new Admindao();
//        	   do
//        	   {
//        	   System.out.println("Admin");
//        	   System.out.println("\nenter the admin emailid");
//        	   String emailid2=sc.nextLine();
//        	   System.out.println("\nenter the admin password");
//        	   String password2=sc.nextLine();
//        	   Admindao adminuser=new Admindao();
////        	  user1= adminuser.validate(emailid2, password2);
//        	  if(user1!=null) {
//        		  System.out.println("admin success");
//        	  }
//        	  else {
//        		  System.out.println("admin notsuccess");
//        	  }
//           }while(user1==null); 
//        	   break;
        case 2:

        	 System.out.println("Enter the moviedetails");
        	 System.out.println("Enter the movename");
        	 String mvname=sc.nextLine();
        	 System.out.println("Enter the movieid");
        	 int mvid=Integer.parseInt(sc.nextLine());
        	 System.out.println("Enter the movietype");
        	 String mvtype=sc.nextLine();
        	 System.out.println("Enter the movierating");
        	 int mvrating=Integer.parseInt(sc.nextLine());
        	 System.out.println("Enter the movieduration");
        	 int mvduration=Integer.parseInt(sc.nextLine());
        	 System.out.println("Enter the director");
        	 String mvdirector=sc.nextLine();
        	 System.out.println("Enter the musicdirector");
        	 String mvmusic=sc.nextLine();
        	 System.out.println("Enter the Heroname");
        	 String mvhero=sc.nextLine();
        	 Moviedao uDao2=new Moviedao();
        	 Movie udao1 = new Movie( mvname,mvid,mvtype,mvrating,mvduration,
        				mvdirector,mvmusic,mvhero);
        	 uDao2.insert(udao1);
        	   break;
        	 
        	   
        	   
        case 3:
        	System.out.println("Update movieid");
        	int movieid=Integer.parseInt(sc.nextLine());
        	System.out.println("Enter your movietype");
        	String movietype=sc.nextLine();
        	Moviedao uDao3=new Moviedao();
        	Movie udao2=new Movie(movietype,movieid);
        	uDao3.update(udao2);
        	
            break;
            
        case 4:
        	System.out.println("delete movieid1");
        	int movieid1=Integer.parseInt(sc.nextLine());
        	Moviedao uDao4=new Moviedao();
        	Movie udao3=new Movie(movieid1);
        	uDao4.delete(udao3);
        	 
        	break;
        	
        	
        case 5:
        	
        	Moviedao product1=new Moviedao();
			List<Movie> Products11=product1.showMovie();
			for(int i=0;i<Products11.size();i++)
			{
				System.out.println(Products11.get(i));
				
			}
			
			break;
          
        case 6:
        	DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

 	
          System.out.println("Enter the theatre_name");
          String theatrename=sc.nextLine();
          System.out.println("Enter the movie_id");
          int mvid2=Integer.parseInt(sc.nextLine());
       //  System.out.println("Enter the theatre_id");
         //int theatreid2=Integer.parseInt(sc.nextLine());
          System.out.println("Enter the number_seats");
          int seat=Integer.parseInt(sc.nextLine());
          System.out.println("Enter the theatre_address");
          String theatreaddress=sc.nextLine();
          System.out.println("Enter the theatre_rating");
          int rating=Integer.parseInt(sc.nextLine());
          System.out.println("Enter the price");
          int price1=Integer.parseInt(sc.nextLine());
          System.out.println("enter movie  date time ");
  	      String mvDate = sc.nextLine(); //"2021-12-21 05:30";
  		  LocalDateTime mvTimeDate = LocalDateTime.parse(mvDate, formatter);
          System.out.println(mvTimeDate);

          Theatredao udao5=new Theatredao();
          
          Theatreinformation u1=new Theatreinformation(theatrename, mvid2, seat, theatreaddress,rating, price1,mvTimeDate);
          System.out.println(u1);
          udao5.insert(u1);
          
          break;
          
        case 7:
        	//update
        	System.out.println("Enter the theatrename");
        	String theatrename1=sc.nextLine();
        	System.out.println("Enter the theatreid");
        	int theatreid1=Integer.parseInt(sc.nextLine());
        	Theatredao uDa=new Theatredao();
        	Theatreinformation obc=new Theatreinformation (theatrename1,theatreid1);
        	uDa.update(obc);
        	break;
        	
        	
        	//delete
              case 8:        	
        	System.out.println("Enter the theatreid");
        	int theatreid21=Integer.parseInt(sc.nextLine());
        	Theatredao Udoa=new Theatredao();
        	Theatreinformation udaoa=new Theatreinformation (theatreid21);
          	Udoa.delete(udaoa);
   			}
   			
           case 9:
        	   
        	   //showtheatre
        	Theatredao products15=new Theatredao();
			List<Theatreinformation> Products13=products15.showtheatre();
			for(int i=0;i<Products13.size();i++)
			{
				System.out.println(Products13.get(i));
				
			}
//           case 10:
//        	   System.out.println("view user");
//        	   User user11=new User(user_id,user_name,gender,email_id,Long.parseLong(e_password),,wallet);
//        	   userdao abc=new userdao();
//        	   abc.viewuser(user11);
//   			
//   			
			
			
			
   			
   			
   			
        
		}
		
		
		
		
		
	}
	
	}
	 	 


	


//}
