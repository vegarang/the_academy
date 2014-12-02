package no.uio.inf5750.TheAcademy.Screenshot.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.Base64Utils;

import no.uio.inf5750.TheAcademy.Screenshot.PropertiesHandler;

public class ImageSaver {
	
	/**
	 * 
	 * @param user the user the image belongs too
	 * @param base64encodedImage the encoded image
	 * @param screenshotProperties the properties for the screenshot application
	 * @return filename wher the image is saved
	 * @throws IOException 
	 */
	public static String saveImage(String user, String base64encodedImage, Properties screenshotProperties) throws IOException{
		String fileLocation = screenshotProperties.getProperty("screenshot.path");
		File dir = new File(fileLocation);
		if(!dir.exists()){
			dir.mkdirs();
		}
		
		String suffix =  "png"; //TODO: Fix a better way to check what kind of file it is. The data should get in thrue the call
		File image = new File(dir, user + "-" + System.currentTimeMillis() + "." + suffix);
		FileOutputStream imageWriter = new FileOutputStream(image);
		imageWriter.write(Base64Utils.decodeFromString(cleanUpImage(base64encodedImage)));
		imageWriter.close();
		return image.getName();
	}
	//TODO write a better way to do this
	private static String cleanUpImage(String base64encImg){
		return base64encImg.split(",")[1];
	}
	
	

}
