package no.uio.inf5750.TheAcademy.Screenshot.service;

public class ScreenshotRequest {
	int userId;
	String titlex;
	String url;
	String image;
	String description;
	public String getUser() {
		// TODO Auto-generated method stub
		return Integer.toString(userId);
	}
	public String getUrl() {
		// TODO Auto-generated method stub
		return url;
	}
	public String getImage() {
		// TODO Auto-generated method stub
		return image;
	}
	public String getDesctiption(){
		return description;
	}
	
	
}
