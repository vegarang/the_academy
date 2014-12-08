package no.uio.inf5750.TheAcademy.Screenshot.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import no.uio.inf5750.TheAcademy.Screenshot.dao.ImageSaver;
import no.uio.inf5750.TheAcademy.Screenshot.dao.ScreenshotDAO;
import no.uio.inf5750.TheAcademy.Screenshot.dao.impl.ScreenshotDAOImpl;
import no.uio.inf5750.TheAcademy.Screenshot.models.Screenshot;
import no.uio.inf5750.TheAcademy.Screenshot.models.impl.ScreenshotImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScreenshotController {
	@Resource(name="screenshotDAO")
	ScreenshotDAO dao;
	@RequestMapping(value="/api/Screenshot/", method = RequestMethod.POST)
	public String addScreenshot(@RequestBody ScreenshotResource resource){
		Screenshot screenshot;
		try {
			screenshot = new ScreenshotImpl(resource.getUserName(), ImageSaver.saveImage(resource.getUserName(), resource.getImage()), resource.getUrl());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "Failed" + e.getLocalizedMessage();
		}
		return "Success! Image added with id: " + dao.addScreenshot(screenshot);
		
	}
	@RequestMapping(value="/api/Screenshot/{id}", method = RequestMethod.DELETE)
	public String removeScreenshot(@RequestBody String id){
		dao.deleteScreenshot(id);
		return id + "deleted!";
	}
	@RequestMapping(value="/api/Screenshot/{id}", method = RequestMethod.PATCH)
	public ScreenshotResource updateScreenshot(@RequestBody ScreenshotResource req){
		Screenshot screenshot = dao.getScreenshot(req.getId().toString());
		updateScreenshot(req, screenshot);
		dao.updateScreenshot(screenshot);
		return getMapper(screenshot);
		
	}
		
	
	private void updateScreenshot(ScreenshotResource req, Screenshot screenshot) {
		if(req.getDescription() != null){
			screenshot.editComment(req.getDescription());
		}
		if(req.getTitle() != null){
			screenshot.setTitle(req.getTitle());
		}
		
	}
	@RequestMapping(value="/api/Screenshot/{id}",method= RequestMethod.GET)
	public List<ScreenshotResource> fun(@PathVariable("id")String request){
		ArrayList<ScreenshotResource> ret = new ArrayList<ScreenshotResource>();
		for(Screenshot screen : dao.getScreenshots(request)){
			ret.add(getMapper(screen));
		}
		return ret;
	}
	
	@RequestMapping(produces = MediaType.IMAGE_PNG_VALUE ,value="api/Screenshot/image/{imageid}" , method = RequestMethod.GET)
	public byte[] getImage(@PathVariable("imageid") String imageId){
		Screenshot screenshot = dao.getScreenshot(imageId);
		try{
			byte[] ret = ImageSaver.getImage(screenshot.getImageLocation());
			System.err.println(ret.length);
			return ret;
		} catch( IOException e){
			e.printStackTrace();
			return e.getMessage().getBytes();
		}
	}
	private ScreenshotResource getMapper(Screenshot screen){
		ScreenshotResource ret = new ScreenshotResource();
		ret.setCreated(screen.getCreated());
		ret.setUserName(screen.getUserId());
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