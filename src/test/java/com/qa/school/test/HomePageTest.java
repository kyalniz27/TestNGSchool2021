package com.qa.school.test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.school.base.BasePage;
import com.qa.school.page.HomePage;
import com.qa.school.page.LoginPage;
import com.qa.school.util.Credentials;
import com.qa.school.util.ElementUtil;

public class HomePageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	//LoginPage loginPage;
	HomePage homePage;
	ElementUtil elementUtil;
	
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(properties.getProperty("url"));
		//loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		elementUtil = new ElementUtil(driver);
	}
	
	@Test(priority=1,enabled=true)
	public void doLogInTest(){
		homePage.doLogIn(properties.getProperty("username"), properties.getProperty("password"));
	}
	
	@Test(priority=2,enabled=false)
	public void getTeacherNameTest(){
		String act = homePage.getTeacherName();
		String exp = "Mustafa Koklu";
		Assert.assertEquals(act, exp);
	}
	
	@Test(priority=3)
	public void currentPageUrlTest(){
		String act = driver.getCurrentUrl();
		String exp = "http://turkceokulu.com/Editor.aspx";
		Assert.assertEquals(act, exp);
	}
	
//	@DataProvider
//	public Object[][] getLoginInvalidData(){
//		Object data[][] = {	{"test123@gmail.com","test23"} };
//		
//		return data;
//	}
//	
//	@Test(priority=3, dataProvider = "getLoginInvalidData", enabled=true)
//	public void loginInvalidTestCase(String user, String pass){
//		
//		
//		homePage.doLogIn(user, pass);
//		elementUtil.waitForElementVisible(homePage.btnBtn);
//		driver.findElement(By.cssSelector("#btnClose")).click();
//		String text = driver.findElement(By.xpath("//div[@class='modal-header']/following-sibling::div")).getText();
//		System.out.println(text);
//	}
	
//	@Test
//	public void isBtnButtonClickableTest(){
//		homePage.isBtnButtonClickable();
//	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
