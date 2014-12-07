package no.uio.inf5750.TheAcademy.Screenshot.models;

import java.util.Date;

public interface Screenshot {
	/**
	 * Method for getting the userId of the person that owns the screenshot
	 * 
	 * @return userId of person that owns screenshot
	 */
	public String getUserId();
	public Date getTaken();
	public void setTaken(Date taken);
	public void setUserId(String userId);

	/**
	 * Get the description of the screenshot
	 * 
	 * @return the comment
	 */
	public String getComment();

	/**
	 * Change the comment.
	 * 
	 * @param newComment
	 */
	public void editComment(String newComment);

	/**
	 * Append to the comment
	 * 
	 * @param comment
	 */
	public void appendComment(String comment);

	/**
	 * Get the url where the screenshot was taken.
	 * 
	 * @return the url
	 */
	public String getUrl();

	/**
	 * Get the file location for the image
	 * 
	 * @return the filelocation
	 */
	public String getImageLocation();

	/**
	 * Get title
	 * 
	 * @return
	 */
	public String getTitle();

	/**
	 * Get the time the image was sent to server
	 * 
	 * @return the time the image was sent to server
	 */
	public Date getCreated();

	/**
	 * @return the database id of the screenshot
	 */
	public Integer getId();

	public void setId(Integer id);
}