package no.uio.inf5750.TheAcademy.Screenshot.dao;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import no.uio.inf5750.TheAcademy.Screenshot.PropertiesHandler;

import org.springframework.util.Base64Utils;

public class ImageSaver {
	
	/**
	 * 
	 * @param user the user the image belongs too
	 * @param base64encodedImage the encoded image
	 * @param screenshotProperties the properties for the screenshot application
	 * @return filename where the image is saved
	 * @throws IOException 
	 */
	public static String saveImage(String user, String base64encodedImage) throws IOException{
		String fileLocation = PropertiesHandler.getProperties("screenshot").getProperty("screenshot.path");
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
	public byte[] getImage(String name) throws IOException{
		File dir = new File(PropertiesHandler.getProperties("screenshot").getProperty("screenshot.path"));
		File image = new File(dir, name);
		InputStream imageStream = new FileInputStream(image);
		byte[] ret = new byte[(int)image.length()];
		DataInputStream dataStream = new DataInputStream(imageStream);
		dataStream.readFully(ret);
		dataStream.close();
		return ret;
	}
	

}
