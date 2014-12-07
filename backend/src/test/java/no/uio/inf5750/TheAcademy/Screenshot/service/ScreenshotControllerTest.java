package no.uio.inf5750.TheAcademy.Screenshot.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:beans.xml" })
@Transactional
public class ScreenshotControllerTest {
	
	@Autowired
	ApplicationContext context;
	
	ScreenshotController service;
	
	@Before
	public void setUp(){
		service = (ScreenshotController) context.getBean("screenshot");
	}
	@Test
	public void test() {
		String image = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAHCAIAAAC+zks0AAAAA3NCSVQICAjb4U/gAAAAGXRFWHRTb2Z0d2FyZQBnbm9tZS1zY3JlZW5zaG907wO/PgAAABVJREFUCJljfPfuHQNuwIRHbnBLAwBejALYn/dMKwAAAABJRU5ErkJggg==";
		String user = "test";
		ScreenshotResource resource =  new ScreenshotResource();
		resource.setImage(image);
		resource.setUser(user);
		
		String ret = service.addScreenshot(resource);
		System.err.println(ret);
//		ScreenshotResource screenshotResourceRet = service.getScreenshot(ret);
//		System.err.println(screenshotResourceRet.toString());
		
	}

}
