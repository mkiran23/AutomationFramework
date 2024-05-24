package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import com.constants.Env;
import com.google.gson.Gson;

public class TestUtility {
	//VARIABLES AND METHODS ARE ALWAYS STATIC 
	
	public static String convertPOJOToJSON(Object object) {
		Gson gson=new Gson();
		String data=gson.toJson(object); //Serialization
		return data;
	}
	
	
	public static String readConfigFile(String env,String keyName)
	{
		File configFile = new File(System.getProperty("user.dir")+"\\config\\"+env+".properties");
		FileReader fileReader;
		Properties properties=new Properties();
		try {
			fileReader = new FileReader(configFile);
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		String data=properties.getProperty(keyName);
		return data;
		
	}
	
	public static String readConfigFile(Env env,String keyName)
	{
		File configFile = new File(System.getProperty("user.dir")+"\\config\\"+env+".properties");
		FileReader fileReader;
		Properties properties=new Properties();
		try {
			fileReader = new FileReader(configFile);
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		String data=properties.getProperty(keyName);
		return data;
		
	}
	
	public static void createDirectory(File f) {
		
		try {
			FileUtils.forceMkdir(f);
		} catch (IOException e) {
			System.out.println("Cannot create report directory!");
		}
	}
	
	public static void deleteDirectory(File f) {
		try {
			FileUtils.forceDelete(f);
		} catch (IOException e) {
			System.out.println("Cannot delete report directory!");
		}
	}
	
	public static String getTimeStamp() {
		Date date=new Date();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-YYYY HH-mm");
		String formattedDate=dateFormat.format(date);
		return formattedDate;
		
	}

}
