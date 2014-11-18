/**
 * 
 */
package no.uio.inf5750.TheAcademy.Screenshot.dao.impl;

import java.util.Collection;


import org.hibernate.SessionFactory;

import org.springframework.transaction.annotation.Transactional;

import no.uio.inf5750.TheAcademy.Screenshot.dao.ScreenshotDAO;
import no.uio.inf5750.TheAcademy.Screenshot.models.Screenshot;

/**
 * @author matsasc 	
 *
 */
@Transactional
public class ScreenshotDAOImpl implements ScreenshotDAO {
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see no.uio.inf5750.TheAcademy.Screenshot.dao.ScreenshotDAO#addScreenshot(no.uio.inf5750.TheAcademy.Screenshot.models.Screenshot)
	 */
	public String addScreenshot(Screenshot screen) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see no.uio.inf5750.TheAcademy.Screenshot.dao.ScreenshotDAO#getScreenshot(java.lang.String)
	 */
	public Screenshot getScreenshot(String screenshotId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see no.uio.inf5750.TheAcademy.Screenshot.dao.ScreenshotDAO#getScreenshots(java.lang.String)
	 */
	public Collection<Screenshot> getScreenshots(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see no.uio.inf5750.TheAcademy.Screenshot.dao.ScreenshotDAO#deleteScreenshot(java.lang.String)
	 */
	public void deleteScreenshot(String screenshotId) {
		// TODO Auto-generated method stub

	}

}
