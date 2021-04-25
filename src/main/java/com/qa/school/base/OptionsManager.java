package com.qa.school.base;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	public ChromeOptions cOptions;
	public FirefoxOptions firefoxOptions;
	public Properties properties;
	
	public OptionsManager(Properties properties){
		this.properties = properties;
	}
	
	public ChromeOptions getChromeOptions(){
		cOptions = new ChromeOptions();
		if (properties.getProperty("incognito").equals("yes")) cOptions.addArguments("--incognito");
		if (properties.getProperty("headless").equals("yes")) cOptions.addArguments("--headless");
		
		return cOptions;
	}
	
	public FirefoxOptions getFireFoxOptions(){
		firefoxOptions = new FirefoxOptions();
		if (properties.getProperty("headless").equals("yes")) firefoxOptions.addArguments("--headless");
		
		return firefoxOptions;
	}
	
	

}
