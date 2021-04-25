package com.qa.school.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.school.util.ElementUtil;

public class HarmoniOne {

	WebDriver driver;
	ElementUtil elementUtil;

	@FindBy(partialLinkText = "Select bo")
	public WebElement selectBook;
	@FindBy(xpath = "//a[contains(text(),'Harmoni Türkçe 1 (A1)')]")
	public WebElement harmoni1;
	@FindBy(xpath = "//a[@class='ng-binding']")
	public List<WebElement> lessons;
	@FindBy(xpath = "//h3[contains(text(),'Harmoni')]")
	public WebElement bookName;
	@FindBy(xpath = "//a[contains(text(),'1-1. Ders - Senin adın ne?')]")
	public WebElement lesson1;
	@FindBy(xpath = "(//div[@class='panel-heading ng-binding'])[1]")
	public WebElement okuma;
	@FindBy(xpath = "//div[@class='panel-heading ng-binding']")
	public WebElement chapter;
	@FindBy(xpath = "//a[contains(text(),'2')]")
	public WebElement activity2;
	@FindBy(xpath = "//span[contains(text(),'1-1. Ders - Senin adın ne?')]")
	public WebElement lessonName;

	@FindBy(xpath = "//div[contains(text(),'Merhaba')]")
	public WebElement merhabaDrag;
	@FindBy(css = "body.ng-scope:nth-child(2) div.Region.container:nth-child(2) div.Module.StaticHtml.col-sm-12 div.ng-scope:nth-child(1) div.well.toEtk.ng-scope div.ng-scope:nth-child(2) div.col-sm-6 div.row.less-padding span.part.ng-scope:nth-child(1) > span.bosluk.ng-binding.ng-scope")
	public WebElement merhabaDrop;
	@FindBy(xpath = "//div[contains(text(),'adım')]")
	public WebElement adimDrag;
	@FindBy(css = "body.ng-scope:nth-child(2) div.Region.container:nth-child(2) div.Module.StaticHtml.col-sm-12 div.ng-scope:nth-child(1) div.well.toEtk.ng-scope div.ng-scope:nth-child(2) div.col-sm-6 div.row.less-padding span.part.ng-scope:nth-child(2) > span.bosluk.ng-binding.ng-scope")
	public WebElement adimDrop;
	@FindBy(xpath = "(//div[contains(text(),'ne')])[1]")
	public WebElement neDrag;
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/span[3]/span[2]")
	public WebElement neDrop;
	@FindBy(xpath = "//div[contains(text(),'Memnun')]")
	public WebElement memnunDrag;
	@FindBy(css = "body.ng-scope:nth-child(2) div.Region.container:nth-child(2) div.Module.StaticHtml.col-sm-12 div.ng-scope:nth-child(1) div.well.toEtk.ng-scope div.ng-scope:nth-child(2) div.col-sm-6 div.row.less-padding span.part.ng-scope:nth-child(4) > span.bosluk.ng-binding.ng-scope")
	public WebElement memnunDrop;
	@FindBy(xpath = "//div[contains(text(),'Benim')]")
	public WebElement benimDrag;
	@FindBy(css = "body.ng-scope:nth-child(2) div.Region.container:nth-child(2) div.Module.StaticHtml.col-sm-12 div.ng-scope:nth-child(1) div.well.toEtk.ng-scope div.ng-scope:nth-child(2) div.col-sm-6 div.row.less-padding span.part.ng-scope:nth-child(5) > span.bosluk.ng-binding.ng-scope")
	public WebElement benimDrop;
	@FindBy(css = "body.ng-scope:nth-child(2) div.Region.container:nth-child(2) div.Module.StaticHtml.col-sm-12 div.ng-scope:nth-child(1) div.well.toEtk.ng-scope div.ng-scope:nth-child(4) div.controlButtons.ng-scope:nth-child(1) > button.btnCheckAnswers.btn.btn-sm.btn-primary")
	public WebElement checkAnswers;
	@FindBy(xpath = "//span[contains(text(),'0')]")
	public WebElement score;

	public HarmoniOne(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtil = new ElementUtil(driver);
	}

	public void chooseBook() {
		selectBook.click();
		harmoni1.click();
		elementUtil.doFindElements(lessons, "1-1. Ders - Senin adın ne?");

	}

	public String verifyLessonName() {
		return lessonName.getText();
	}

	public void chooseActivity() {
		// driver.get(driver.getCurrentUrl());
		okuma.click();
		activity2.click();
		merhabaDrag.click();
		merhabaDrop.click();
		adimDrag.click();
		adimDrop.click();
		neDrag.click();
		neDrop.click();
		memnunDrag.click();
		memnunDrop.click();
		benimDrag.click();
		benimDrop.click();
		checkAnswers.click();

	}

	public int getScore() {

//		String scorePoint = score.getText().trim();
//		int scoreDigit = Integer.parseInt(scorePoint);
//		
//		if (score.getText().equals(null)) {
//			return 0;
//		}
//		
//		return scoreDigit;
		
		String str = score.getText().trim();
		if (score.getText().equals(null)) {
			return Integer.parseInt(str);
		} else {
			return 0;
		}
	}

	public int getScore2() {
		
		String str = score.getText().trim();
		if (score.getText().equals(null)) {
			return Integer.parseInt(str);
		} else {
			return 0;
		}
			
		
	}

}
