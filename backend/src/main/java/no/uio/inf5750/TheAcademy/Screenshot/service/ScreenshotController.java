package no.uio.inf5750.TheAcademy.Screenshot.service;

import no.uio.inf5750.TheAcademy.Screenshot.dao.ScreenshotDAO;

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
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addScreenshot(@RequestBody String resource){
		return resource;
	}
	@RequestMapping(value="/{id]", method = RequestMethod.DELETE)
	public String removeScreenshot(@PathVariable("id") String id){
		dao.deleteScreenshot(id);
		return id + "deleted!";
	}
}
