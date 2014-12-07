package no.uio.inf5750.TheAcademy.Screenshot.service;

import java.util.Date;

import no.uio.inf5750.TheAcademy.Screenshot.models.Screenshot;

public class ScreenshotResource {
	private Integer id;
	private String username;
	private String title;
	private String url;
	private String image;
	private String imageurl;
	private String description;
	private Date created;
	
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	
	public void setImageUrl(String imageUrl){
		imageurl = imageUrl;
	}
	public String getImageUrl(){
		return imageurl;
	}
	public void setUser(String id){
		username = id;
	}
	public String getUser() {
		return username;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return title;
	}
	public void setUrl(String url){
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	public void setImage(String image){
		this.image =  image;
	}
	public String getImage() {
		return image;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}
	public void setCreated(Date time){
		created = time;
	}
	public Date getCreated(){
		return created;
	}
	
}
