package no.uio.inf5750.TheAcademy.Screenshot.models.impl;

import no.uio.inf5750.TheAcademy.Screenshot.models.Screenshot;

public class ScreenshotImpl implements Screenshot {
	private String userId;
	private String comment;
	private String url;
	private String imageurl;
	private String title;

	public ScreenshotImpl(String userId, String imageurl, String url) {
		this.userId = userId;
		this.imageurl = imageurl;
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

	public String getImageURL() {
		return imageurl;
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
	public Screenshot withImageURL(String imageURL){
		this.imageurl = imageURL;
		return this;
	}

}
