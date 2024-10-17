package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

 
public class ReadConfig {
	Properties properties;
	String path = "C:\\Users\\hp\\eclipse-workspace\\MyStoreV1\\Configuration\\config.properties";

	// constructor
	// initialinzing above object
	public ReadConfig() {
		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	//method to read baseUrl key from configuration file
	public String getBaseUrl() {
		String value = properties.getProperty("baseUrl");
		System.out.println("Base url : "+value);
		if(value!=null)
		return value;
		else
		throw new RuntimeException("url not specified in the configuration file");
	}
	//to read browser value from configuration file
	public String getBrowser() {
		String value = properties.getProperty("browser");
		System.out.println("value of browser is : "+value);
		if(value!=null)
		return value;
		else
		throw new RuntimeException("url not specified in the configuration file");
	}
	//to read email from configuration file
	public String getEmail()
	{
		String email = properties.getProperty("email");
		if(email!=null)
			return email;
		else
			throw new RuntimeException("email not specified in config file.");
		
	}
	//to read password from configuration file
	public String getPassword()
	{
		String password = properties.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");
		
	}

}
