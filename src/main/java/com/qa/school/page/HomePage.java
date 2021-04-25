package com.qa.school.page;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.school.base.BasePage;
import com.qa.school.util.ElementUtil;

public class HomePage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	@FindBy(xpath="//li[@id='menu1']") public WebElement signInBtn;
	@FindBy(xpath="//*[@name='Email']") public WebElement email;
	@FindBy(xpath="//*[@name='Password']") public WebElement password;
	@FindBy(css="#btn-login") public WebElement btnBtn;
	@FindBy(xpath="//h1[contains(text(),'Mustafa Koklu')]") public WebElement teacherName;
	@FindBy(xpath="//*[text()='Mustafa Koklu ']/ancestor::li[1]") public WebElement signInBtnAgain;
	@FindBy(xpath="//a[contains(text(),'Editor Page')]") public WebElement editor;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtil = new ElementUtil(driver);
		
	}
	
	public void doLogIn(String user, String pass){
		signInBtn.click();
		email.sendKeys(user);
		password.sendKeys(pass);
		btnBtn.click();
		driver.get(driver.getCurrentUrl());
		signInBtnAgain.click();
		editor.click();
		
	}
	
	
	public String getTeacherName(){
		return teacherName.getText();
		
	}
	
	

}
