/**
 * 
 */
package no.uio.inf5750.TheAcademy.Screenshot.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import no.uio.inf5750.TheAcademy.Screenshot.dao.ScreenshotDAO;
import no.uio.inf5750.TheAcademy.Screenshot.models.Screenshot;
import no.uio.inf5750.TheAcademy.Screenshot.models.impl.ScreenshotImpl;

/**
 * @author matsasc 	
 *
 */
public class ScreenshotDAOImpl implements ScreenshotDAO {
	SessionFactory sessionFactory;
	String screenshotLocation;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see no.uio.inf5750.TheAcademy.Screenshot.dao.ScreenshotDAO#addScreenshot(no.uio.inf5750.TheAcademy.Screenshot.models.Screenshot)
	 */
	public String addScreenshot(Screenshot screen) {
		Session session = sessionFactory.getCurrentSession();
		Integer id = (Integer) session.save(screen);
		return id.toString();
	}

	/* (non-Javadoc)
	 * @see no.uio.inf5750.TheAcademy.Screenshot.dao.ScreenshotDAO#getScreenshot(java.lang.String)
	 */
	public Screenshot getScreenshot(String screenshotId) {
		return (Screenshot) sessionFactory.getCurrentSession().get(ScreenshotImpl.class, Integer.parseInt(screenshotId));
	}

	/* (non-Javadoc)
	 * @see no.uio.inf5750.TheAcademy.Screenshot.dao.ScreenshotDAO#getScreenshots(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<ScreenshotImpl> getScreenshots(String userId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ScreenshotImpl.class);
		criteria.add(Restrictions.eq("user", userId));
		return criteria.list();
	}

	/* (non-Javadoc)
	 * @see no.uio.inf5750.TheAcademy.Screenshot.dao.ScreenshotDAO#deleteScreenshot(java.lang.String)
	 */
	public void deleteScreenshot(String screenshotId) {
		Screenshot screenshot = getScreenshot(screenshotId);
		Session session = sessionFactory.getCurrentSession();
		session.delete(screenshot);
	}
	

}
