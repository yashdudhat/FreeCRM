package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;


public class HomePageTest extends TestBase{
	LoginPage loginPage; 
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	public HomePageTest() {
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		intiialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage =  new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));		
	}	
	@Test(priority = 1)
	public void verifyHomePageTitle() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page title does not match");
		
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest() {
		testUtil.switchToframe();
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
	}
	@Test(priority = 3)
	public  void verifyContactsLinkTest() {
		testUtil.switchToframe();
		contactsPage =  homePage.clickOnContactsLink();
	}
	
	@Test(priority = 4)
	public void verifyDealsLinkTest() {
		testUtil.switchToframe();
		dealsPage = homePage.clickOnDealsLink();
		
	}
	
	public void verifyTasksLinkTest() {
		
		testUtil.switchToframe();
		tasksPage =  homePage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
