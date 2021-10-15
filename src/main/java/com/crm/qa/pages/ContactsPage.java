package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath ="//td[contains(text(),'Contacts')]")
	WebElement contactsLabels;
	
	@FindBy(id ="btn_cs_search")
	WebElement advancedSearch;
	
	@FindBy(name = "title")
	WebElement selectTitleOption;
	
	@FindBy(id = "first_name")
	WebElement firstNameBox;
	
	@FindBy(id = "surname")
	WebElement lastNameBox;
	
	@FindBy(name = "client_lookup")
	WebElement companyBox;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verfiryContactsLabel() {
		return contactsLabels.getText();
	}
	
	public boolean verifyAdvancedSearchbtn() {
		return advancedSearch.isDisplayed();
	}
	
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@type='checkbox']")).click();
		
	}
	public boolean verifyContactByName(String name) {
		return driver.findElement(By.xpath("//a[text()='"+name+"']")).isDisplayed();

		
	}
	
	
	public void FillForm(String title,String ftName, String ltName, String compName) {
		Select s = new Select(selectTitleOption);
		s.selectByVisibleText(title);
		firstNameBox.sendKeys(ftName);
		lastNameBox.sendKeys(ltName);
		companyBox.sendKeys(compName);
		saveBtn.click();
		//return driver.findElement(By.xpath("//td[contains(text(),'"+firstName+ " "+surname+"')]")).isDisplayed();	
		
		
		
	}
}
