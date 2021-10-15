package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		intiialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.switchToframe();
		contactsPage =  homePage.clickOnContactsLink();
		
	}
	
	@Test(priority = 1)
	public void verifyContactsTableTest() {
		

		String expected =  contactsPage.verfiryContactsLabel();
		Assert.assertEquals(expected, "Contacts","Contacts table not present");
	}
	
	@Test(priority = 2)
	public void verifyAdvancedSearchTest() {
	

		Assert.assertTrue(contactsPage.verifyAdvancedSearchbtn());
	}
	
	@Test(priority = 3)
	public void selectSingleContactTest() {
		contactsPage.selectContactByName("Amit Kumar");
	}

	@Test(priority = 4)
	public void selectMultipleContactTest(){
		contactsPage.selectContactByName("Amit Kumar");
		contactsPage.selectContactByName("antony dsouza");
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 5,dataProvider = "getCRMTestData")
	public void verifyNewContact(String title, String firstname, String lastname, String company) {
		
		
		homePage.clickOnNewContactLink();
		contactsPage.FillForm(title,firstname,lastname,company);
		homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactByName(firstname+ " "+lastname));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
