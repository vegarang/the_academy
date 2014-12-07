package no.uio.inf5750.TheAcademy.Screenshot.service;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import no.uio.inf5750.TheAcademy.Screenshot.dao.ImageSaver;
import no.uio.inf5750.TheAcademy.Screenshot.dao.impl.ScreenshotDAOImpl;
import no.uio.inf5750.TheAcademy.Screenshot.models.Screenshot;
import no.uio.inf5750.TheAcademy.Screenshot.models.impl.ScreenshotImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScreenshotController {
	@Resource(name="screenshotDAO")
	ScreenshotDAOImpl dao;
	@RequestMapping(value="/api/Screenshot/", method = RequestMethod.POST)
	public String addScreenshot(@RequestBody ScreenshotResource resource){
		Screenshot screenshot;
		try {
			screenshot = new ScreenshotImpl(resource.getUser(), ImageSaver.saveImage(resource.getUser(), resource.getImage()), resource.getUrl());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "Failed";
		}
		return "Success! Image added with id: " + dao.addScreenshot(screenshot);
		
	}
	@RequestMapping(value="/api/Screenshot/{id}", method = RequestMethod.DELETE)
	public String removeScreenshot(@RequestBody String id){
		dao.deleteScreenshot(id);
		return id + "deleted!";
	}
	@RequestMapping(value="/api/Screenshot/{id}", method= RequestMethod.GET)
	public ScreenshotResource getScreenshot(@PathVariable("id") String id){
		Screenshot screenshot = dao.getScreenshot(id);
		ScreenshotResource ret = getMapper(screenshot);
		return ret;
	}
		
	
	@RequestMapping(value="/api/Screenshot/",method= RequestMethod.GET)
	public List<ScreenshotImpl> fun(@RequestBody ScreenshotResource request){
		return dao.getScreenshots(request.getUser());
	}
	
	@RequestMapping(value="api/Screenshot/image/{imageid}" , method = RequestMethod.GET)
	public byte[] getImage(@PathVariable("imageid") String imageId){
		Screenshot screenshot = dao.getScreenshot(imageId);
		try{
			return ImageSaver.getImage(screenshot.getImageLocation());
		} catch( IOException e){
			return e.getMessage().getBytes();
		}
	}
	private ScreenshotResource getMapper(Screenshot screen){
		ScreenshotResource ret = new ScreenshotResource();
		ret.setCreated(screen.getCreated());
		ret.setUser(screen.getUserId());
		ret.setImage("api/Screenshot/image/" + screen.getId());
		if(screen.getComment() != null){
			ret.setDescription(screen.getComment());
		}
		if(screen.getId() != null){
			ret.setId(screen.getId());
		}
		if(screen.getTitle() != null){
			ret.setTitle(screen.getTitle());
		}
		if(screen.getUrl() != null){
			ret.setUrl(screen.getUrl());
		}
		
		return ret;
		
	}
}