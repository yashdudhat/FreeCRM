package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	
	String sheetName = "deals";
	
	public DealsPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		intiialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToframe();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(dataProvider = "getCRMTestData")
	public void verifyNewDealsCreated(String title) {
		
		homePage.clickOnNewDealsLink();
		dealsPage.FillForm(title);
		
		homePage.clickOnDealsLink();
		Assert.assertTrue(dealsPage.verifyNewDeals());
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
