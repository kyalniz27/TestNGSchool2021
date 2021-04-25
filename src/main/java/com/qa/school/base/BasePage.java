package com.qa.school.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	//WebDriver driver;
	Properties properties;
	public OptionsManager optionsManager;

	 public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	 	 
	 public static synchronized WebDriver getDriver(){
	 return tldriver.get();
	 }

	public WebDriver init_driver(String browserName) {
		optionsManager = new OptionsManager(properties);

		if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionsManager.getFireFoxOptions());
			tldriver.set(new FirefoxDriver(optionsManager.getFireFoxOptions()));

		} else if (browserName.equals("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			//driver = new SafariDriver();
			tldriver.set(new SafariDriver());

		} else {
			System.out.println("Browser name " + browserName + " is not found, please pass the correct browser");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return getDriver();
	}

	public Properties init_properties() {

		properties = new Properties();
		String path = "./src/main/java/com/qa/school/config/config.properties";

		try {
			FileInputStream ip = new FileInputStream(path);
			properties.load(ip);

		} catch (FileNotFoundException e) {
			System.out.println("some issue with config properties... Please correct your config...");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	/**
	 * Screenshot
	 * 
	 * @return
	 */
	public String getScreenshot() {

		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		//String path2 = "C:/Users/seker/workspace/TestNGSchool2021/screenshots";
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.err.println("screenshot captured failed...");
		}

		return path;

	}

}
