package com.utils;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;

	public class Utils {
		
		public static String getLocatorType(String key) {
			String value=getProperty(key);
			return value.split("##")[0];
		}
		
		public static String getLocatorValue(String key) {
			String value=getProperty(key);
			return value.split("##")[1];
		}
		
		public static String getProperty(String key) {
			String value=null;
			try {
				FileInputStream fis =new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\MavenDemo\\src\\main\\resources\\OR.properties");
				Properties prop= new Properties();
				prop.load(fis);
				value=(String) prop.get(key);
					
				
			} catch (FileNotFoundException e) {
				System.out.println("Store locator repo not found");
				e.printStackTrace();
			}
			catch (IOException e) {
				System.out.println("Unable to load properties file");
				e.printStackTrace();
			}
			return value;
		}

	}



