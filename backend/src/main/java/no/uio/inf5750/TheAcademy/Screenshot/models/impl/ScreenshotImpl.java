package no.uio.inf5750.TheAcademy.Screenshot.models.impl;

import no.uio.inf5750.TheAcademy.Screenshot.models.Screenshot;

public class ScreenshotImpl implements Screenshot {
	private String userId;
	private String comment;
	private String url;
	private String canvas;
	private String title;

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

}
