package no.uio.inf5750.TheAcademy.Screenshot.service;

import java.io.IOException;

import no.uio.inf5750.TheAcademy.Screenshot.dao.ImageSaver;
import no.uio.inf5750.TheAcademy.Screenshot.dao.ScreenshotDAO;
import no.uio.inf5750.TheAcademy.Screenshot.models.Screenshot;
import no.uio.inf5750.TheAcademy.Screenshot.models.impl.ScreenshotImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Screenshot")
public class ScreenshotController {
	ScreenshotDAO dao;
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String addScreenshot(@RequestBody ScreenshotRequest resource){
		Screenshot screenshot;
		try {
			screenshot = new ScreenshotImpl(resource.getUser(), ImageSaver.saveImage(resource.getUser(), resource.getImage()), resource.getUrl());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "Failed";
		}
		return "Success! Image added with id: " + dao.addScreenshot(screenshot);
		
	}
	@RequestMapping(value="/", method = RequestMethod.DELETE)
	public String removeScreenshot(@RequestBody String id){
		dao.deleteScreenshot(id);
		return id + "deleted!";
	}
}