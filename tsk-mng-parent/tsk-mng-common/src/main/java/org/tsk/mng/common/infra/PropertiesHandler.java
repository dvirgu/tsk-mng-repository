package org.tsk.mng.common.infra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesHandler {

	private static final Logger logger = Logger.getLogger(PropertiesHandler.class); 
	private static Properties prop;
	
	public static Properties getPropertieFile(String fileName){
		try {
			prop = new Properties();
			InputStream input = PropertiesHandler.class.getResourceAsStream(fileName);
			prop.load(input);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return prop;
	}
	
	public static void addPropertie(String fileName, String key, String value){
		try {
			prop = new Properties();
			InputStream input = PropertiesHandler.class.getResourceAsStream(fileName);
			prop.load(input);
			prop.setProperty(key, value);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public static String readPropertie(String fileName, String key){
		String value = null;
		try {
			prop = new Properties();
			InputStream input = PropertiesHandler.class.getResourceAsStream(fileName);
			prop.load(input);
			value = prop.getProperty(key);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return value;
	}
	
	public static void createPropertieFile(String fileName){
		try {
			prop = new Properties();
			prop.store(new FileOutputStream(fileName), null);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
