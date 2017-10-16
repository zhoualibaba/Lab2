package org.zhou.model;

public class Author {
	private int authorID;
	private String authorname;
	private int authorage;
	private String authorcountry;
	
	public Author(){
		
	}
	
	public Author(int authorID, String authorname, int authorage, String authorcountry) {
		this.authorID = authorID;
		this.authorname = authorname;
		this.authorage = authorage;
		this.authorcountry = authorcountry;
	}
	
	public int getAuthorID() {
		return authorID;
	}
	
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	
	public String getAuthorname() {
		return authorname;
	}
	
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	
	public int getAuthorage() {
		return authorage;
	}
	
	public void setAuthorage(int authorage) {
		this.authorage = authorage;
	}
	
	public String getAuthorcountry() {
		return authorcountry;
	}
	
	public void setAuthorcountry(String authorcountry) {
		this.authorcountry = authorcountry;
	}

}
