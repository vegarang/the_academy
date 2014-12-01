package no.uio.inf5750.TheAcademy.Screenshot;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesHandler {
	public static Properties getProperties(String application) throws IOException{
		Resource resource = new ClassPathResource("/" + application + ".properties");
		Properties props = PropertiesLoaderUtils.loadProperties(resource);
		return props;
	}
}
