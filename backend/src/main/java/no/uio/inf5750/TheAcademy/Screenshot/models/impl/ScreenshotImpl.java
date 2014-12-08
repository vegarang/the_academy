package no.uio.inf5750.TheAcademy.Screenshot.models.impl;

import java.util.Date;

import no.uio.inf5750.TheAcademy.Screenshot.models.Screenshot;

public class ScreenshotImpl implements Screenshot {
	private Integer id;
	private String userId;
	private String comment;
	private String url;
	private String fileLocation;
	private String title;
	private Date taken;

	public ScreenshotImpl(String userId, String filelocation, String url) {
		this.userId = userId;
		this.fileLocation = filelocation;
		this.url = url;
		taken = new Date();
	}
	public ScreenshotImpl(){
		
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setComment(String comment){
		this.comment = comment;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setUrl(String url){
		this.url = url;
	}
	public String getUserId() {
		return userId;
	}

	public String getComment() {
		return comment;
	}

	public void editComment(String newComment) {
		comment = newComment;
	}

	public void appendComment(String comment) {
		this.comment += "\n" + comment;
	}

	public String getUrl() {
		return url;
	}

	public String getFileLocation() {
		return fileLocation;
	}
	
	public void setFileLocation(String fileLocation){
		this.fileLocation = fileLocation;
	}
	public String getTitle() {
		return title;
	}
	public Screenshot withUserId(String userId){
		this.userId = userId;
		return this;
	}
	public Screenshot withUrl(String url){
		this.url = url;
		return this;
	}
	public Screenshot withComment(String comment) {
		this.comment = comment;
		return this;
	}
	public Screenshot withTitle(String title){
		this.title = title;
		return this;
	}
	public Screenshot withFilelocation(String fileLocation){
		this.fileLocation = fileLocation;
		return this;
	}

	public String getImageLocation() {
		return fileLocation;
	}

	public Date getCreated() {
		return taken;
	}
	public void setUserId(String userId) {
		this.userId = userId;
		
	}
	@Override
	public Date getTaken() {
		return getCreated();
	}
	@Override
	public void setTaken(Date taken) {
		this.taken = taken;
		
	}

}
