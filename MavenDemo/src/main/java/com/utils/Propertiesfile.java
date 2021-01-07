package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.keywords.Constants;

public class Propertiesfile {
	static String value = null;

	public static String getProperty(String key)  {
		try {
			Constants.file = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\MavenDemo\\src\\main\\resources\\OR.properties");
			Constants.prop = new Properties();
			Constants.prop.load(Constants.file);
			value = Constants.prop.getProperty(key);
		
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open Object Repository");
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String getProperty(String key, String filePath) {
	String value = null;
		try {
			Constants.file = new FileInputStream(filePath);
			Constants.prop = new Properties();
			Constants.prop.load(Constants.file);
			
		} catch (FileNotFoundException e) {
			System.out.println(filePath + filePath + "file not found");
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("Unable to load file " + filePath);
		e.printStackTrace();
		}

		return value;
	}

	public static String[] getLocator(String Key) throws IOException {
		String[] values = null;
		try {
			Constants.file = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\MavenDemo\\src\\main\\resources\\OR.properties");
			Constants.prop = new Properties();
			Constants.prop.load(Constants.file);
			String part = Constants.prop.getProperty(Key);
			values = part.split("##");
			System.out.println("Locator type " + values[0]);
			System.out.println("Locator value " + values[1]);
		} catch (IOException e) {
			System.out.println("unable to open Object repository");
			e.printStackTrace();
		}
		return values;
	}




	}
