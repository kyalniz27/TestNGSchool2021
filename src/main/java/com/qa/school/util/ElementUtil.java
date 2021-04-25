package com.qa.school.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jmx.snmp.SnmpStringFixed;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class ElementUtil {

	WebDriver driver;
	WebElement element;
	WebDriverWait wait;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIMEOUT);
	}
	
	
	/**
	 * wait for title
	 * @param title
	 * @return
	 */
	
	public boolean waitForTitlePresent(String title){
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}
	
	/**
	 * wait for element
	 * @param locator
	 * @return
	 */
	public boolean waitForElementPresent(By locator){
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}
	
	/**
	 * wait for element visible
	 * @param element
	 * @return
	 */
	public void waitForElementVisible(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementClickable(WebElement element){
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Get_Page_Title
	 * 
	 * @return
	 */
	public String getPageTitle() {
		return driver.getTitle();

	}

	/**
	 * Click_On_Element
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement doClickOn(By locator) {

		try {

			driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Element not clickable");
		}
		return element;

	}
	
	/**
	 * Click_On_Element
	 * @param element
	 */
	
	public void clickOn(WebElement element){
		element.click();
	}
	
	/**
	 * DropDown_WithoutSelect
	 * @param element
	 * @param value
	 */
	public void doFindElements(List<WebElement> element,String value){
		
		for (int i = 0; i <element.size() ; i++) {
			if (element.get(i).getText().equals(value)) {
				element.get(i).click();
				break;
			}
		}
		
	}

	/**
	 * Send_Keys_Method
	 * @param locator
	 * @param value
	 */
	public WebElement doSendKeys(By locator, String value) {

		try {
			driver.findElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("Value couldn't send to the locator");
		}

		return element;

	}
	
	

	/**
	 * isDisplayed_Method
	 * 
	 * @param locator
	 * @return
	 */
	public boolean isElementDisplayed(By locator) {

		try {
			driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("Element is not displayed");
		}
		return false;

	}

	/**
	 * isEnableded_Method
	 * 
	 * @param locator
	 * @return
	 */
	public boolean isElementEnabled(By locator) {

		try {
			driver.findElement(locator).isEnabled();
		} catch (Exception e) {
			System.out.println("Element is not enabled");
		}
		return false;

	}

	/**
	 * isSelected_Method
	 * 
	 * @param locator
	 * @return
	 */
	public boolean isElementSelected(By locator) {

		try {
			driver.findElement(locator).isSelected();
		} catch (Exception e) {
			System.out.println("Element is not selected");
		}
		return false;

	}

	

}
