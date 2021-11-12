package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{
	
	@FindBy(id = "title")
	WebElement titleBox;
	
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	@FindBy(xpath = "//img[@src='https://classic.freecrm.com/images/downarrow.gif']")
	WebElement sortBtn;
	
	@FindBy(partialLinkText = "abcd")
	WebElement titleName;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void FillForm(String title) {	
		titleBox.sendKeys(title);
		saveBtn.click();	
	
		
	}
	
	public boolean verifyNewDeals() {
	sortBtn.click();
		
		return titleName.isDisplayed();
	}
	
}
