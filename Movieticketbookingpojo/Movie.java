package com.Movieticketbookingpojo;

public class Movie {
	private String Movie_name;
	private int Movie_id;
	private String Movie_type;
	private int movie_ratings;
	private int movie_duration;
	private String director;
	private String music_director;
	private String hero_name;
	public String getMovie_name() {
		return Movie_name;
	}
	public void setMovie_name(String movie_name) {
		Movie_name = movie_name;
	}
	public int getMovie_id() {
		return Movie_id;
	}
	public void setMovie_id(int movie_id) {
		Movie_id = movie_id;
	}
	public String getMovie_type() {
		return Movie_type;
	}
	public void setMovie_type(String movie_type) {
		Movie_type = movie_type;
	}
	public int getMovie_ratings() {
		return movie_ratings;
	}
	public void setMovie_ratings(int movie_ratings) {
		this.movie_ratings = movie_ratings;
	}
	public int getMovie_duration() {
		return movie_duration;
	}
	public void setMovie_duration(int movie_duration) {
		this.movie_duration = movie_duration;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMusic_director() {
		return music_director;
	}
	public void setMusic_director(String music_director) {
		this.music_director = music_director;
	}
	public String getHero_name() {
		return hero_name;
	}
	public void setHero_name(String hero_name) {
		this.hero_name = hero_name;
	}
	public Movie(String movie_name, int movie_id, String movie_type, int movie_ratings, int movie_duration,
			String director, String music_director, String hero_name) {
		super();
		Movie_name = movie_name;
		Movie_id = movie_id;
		Movie_type = movie_type;
		this.movie_ratings = movie_ratings;
		this.movie_duration = movie_duration;
		this.director = director;
		this.music_director = music_director;
		this.hero_name = hero_name;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(String string, String string2, String string3, String string4, String string5, String string6,
			String string7, String string8) {
		// TODO Auto-generated constructor stub
	}
	public Movie(String movietype,int movieid) {
		// TODO Auto-generated constructor stub
		this.Movie_type=movietype;
		this.Movie_id=movieid;
	}
	public Movie(int movieid1) {
		// TODO Auto-generated constructor stub
		this.Movie_id=movieid1;
	}
	public Movie(int id1, String name) {
		// TODO Auto-generated constructor stub
		this.Movie_id=id1;
		this.Movie_name=name;
	}
	@Override
	public String toString() {
		return "Movie \nMovie_name=" + Movie_name + "\n Movie_id=" + Movie_id + "\n Movie_type=" + Movie_type
				+ "\n movie_ratings=" + movie_ratings + "\n movie_duration=" + movie_duration + "\n director=" + director
				+ "\n music_director=" + music_director + "\n hero_name=" + hero_name + "]";
	}
	public static void add(Movie product) {
		// TODO Auto-generated method stub
		
	}
}
	