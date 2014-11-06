package no.uio.inf5750.TheAcademy.Screenshot.models.impl;

import no.uio.inf5750.TheAcademy.Screenshot.models.Screenshot;

public class ScreenshotImpl implements Screenshot {
	private String userId;
	private String comment;
	private String url;
	private String canvas;
	private String title;

	public ScreenshotImpl(String userId, String canvas, String url) {
		this.userId = userId;
		this.canvas = canvas;
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

	public String getCanvas() {
		return canvas;
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
	public Screenshot withCanvas(String canvas){
		this.canvas = canvas;
		return this;
	}

}
