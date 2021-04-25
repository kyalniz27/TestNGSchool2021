package com.qa.school.test;

import static org.testng.Assert.fail;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.school.base.BasePage;
import com.qa.school.page.HarmoniOne;
import com.qa.school.page.HomePage;

public class HarmoniOneTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	HomePage homePage;
	HarmoniOne h1;
	
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(properties.getProperty("url"));
		homePage = new HomePage(driver);
		h1 = new HarmoniOne(driver);
	}
	
	@Test(priority=1)
	public void chooseBookTest(){
		homePage.doLogIn(properties.getProperty("username"), properties.getProperty("password"));
		h1.chooseBook();
	}
	
	@Test(priority=2)
	public void verifyLessonNameTest(){
		String actual = h1.verifyLessonName();
		String expected = "1-1. Ders - Senin adın ne?";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=3)
	public void chooseActivityTest(){
		h1.chooseActivity();
	}
	
	@Test(priority=4)
	public void getScoreTest(){
		
//		int actual = h1.getScore();
//		int expected = 60;
//		if (actual == expected) {
//			System.out.println("Score matched");
//		} else {
//			fail();
//		}
		
		int strOutput = h1.getScore2();
		System.out.println("Output " + strOutput);
		Assert.assertEquals(strOutput, 60);
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	

}
