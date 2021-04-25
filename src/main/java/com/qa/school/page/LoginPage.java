package com.qa.school.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.school.base.BasePage;
import com.qa.school.util.AppConstants;
import com.qa.school.util.ElementUtil;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	@FindBy(partialLinkText = "About") 	public WebElement aboutUs;
	@FindBy(xpath = "//ul[@class='dropdown-menu']/li") 	public List<WebElement> list;
	@FindBy(xpath = "//h1[contains(text(),'Sign Language')]") public WebElement header;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtil = new ElementUtil(driver);
	}

	// Page actions with elementUtil class 
	public String getPageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.PAGE_TITLE);
		return elementUtil.getPageTitle();
	}

	public void getList() {
		
		elementUtil.clickOn(aboutUs);
		elementUtil.doFindElements(list, "Sign Language");
		
//		aboutUs.click();
		
//		for (WebElement webElement : list) {
//			if (webElement.getText().equals("Sign Language")) {
//				webElement.click();
//				break;
//			}
//		}
	}

	public String getSignLanguageTitle() {
		//return driver.getTitle();
		return elementUtil.getPageTitle();
	}

	
	public String signLanguagePage() {
		return header.getText();
	
		
	}

}
