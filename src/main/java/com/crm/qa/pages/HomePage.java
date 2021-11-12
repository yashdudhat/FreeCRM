package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'User: group automation')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	@FindBy(xpath ="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath ="//a[contains(text(),'Companies')]")
	WebElement abc;
	
	@FindBy(xpath ="//a[contains(text(),'New Deal')]")
	WebElement newDealsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCorrectUserName() {
		
		return userNameLabel.isDisplayed();
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
		
	}
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
		
	}	
	
	public void clickOnNewContactLink() {
		
		Actions action = new Actions(driver);
		
		action.moveToElement(abc).build().perform();
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
		
	}
	
	public void clickOnNewDealsLink() {
		Actions action = new Actions(driver);
		
		action.moveToElement(abc).build().perform();
		action.moveToElement(dealsLink).build().perform();		
		newDealsLink.click();
		

	}
	
	public TasksPage clickOnTasksLink() {
		taskLink.click();
		return new TasksPage();
		
	}
}
