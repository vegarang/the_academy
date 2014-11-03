package no.uio.inf5750.TheAcademy.Screenshot.dao;

import java.util.List;

import no.uio.inf5750.TheAcademy.Screenshot.models.Screenshot;

/**
 * DAO interface
 * @author matsasc
 *
 */
public interface ScreenshotDAO {
	void addScreenshot(String userId, Screenshot screen);
	Screenshot getScreenshot(String screenshotId);
	List<Screenshot> getScreenshots(String userId);
	
}
