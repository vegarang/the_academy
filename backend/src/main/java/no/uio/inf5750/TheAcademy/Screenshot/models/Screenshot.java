package no.uio.inf5750.TheAcademy.Screenshot.models;

public interface Screenshot {
	/**
	 * Method for getting the userId of the person that owns the screenshot
	 * @return userId of person that owns screenshot
	 */
	public String getUserId();
	/**
	 * Get the description of the screenshot
	 * @return the comment
	 */
	public String getComment();
	/**
	 * Change the comment.
	 * @param newComment
	 */
	public void editComment(String newComment);
	/**
	 * Append to the comment
	 * @param comment
	 */
	public void appendComment(String comment);
	/**
	 * Get the url where the screenshot was taken.
	 * @return the url
	 */
	public String getUrl();
	/**
	 * Get the HTML canvas we save
	 * @return the canvas
	 */
	public String getImageURL();
	/**
	 *  Get title
	 * @return
	 */
	public String getTitle();
} 