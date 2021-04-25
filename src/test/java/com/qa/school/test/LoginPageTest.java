package com.qa.school.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.school.base.BasePage;
import com.qa.school.page.LoginPage;
import com.qa.school.util.AppConstants;

public class LoginPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(properties.getProperty("url"));
		loginPage = new LoginPage(driver);
		
	}
	
	
	@Test(priority=1,enabled=false)
	public void getPageTitleTest(){
		String act = loginPage.getPageTitle();
		String exp = AppConstants.PAGE_TITLE;
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=2)
	public void getListTest(){
		loginPage.getList();
	}
	
	
	@Test(priority=3)
	public void getSignLanguageTitleTest(){
		String act = loginPage.getSignLanguageTitle();
		String exp = "Sign Language - Türkçe Okulu";
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=4)
	public void signLanguagePageTest(){
		String act = loginPage.signLanguagePage();
		String exp = "Sign Language";
		Assert.assertEquals(act, exp, "PAGE IS EMPTY");
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
