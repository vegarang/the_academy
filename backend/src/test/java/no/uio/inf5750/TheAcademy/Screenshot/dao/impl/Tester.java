package no.uio.inf5750.TheAcademy.Screenshot.dao.impl;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class Tester{
	@Test
	public void test() throws IOException{
		Resource resource = new ClassPathResource("/screenshot.properties");
		Properties props = PropertiesLoaderUtils.loadProperties(resource);
		boolean containsFoo = props.containsKey("screenshot.path");
		System.out.println("Does my environment contain the 'foo' property? " + containsFoo);
	}
}
