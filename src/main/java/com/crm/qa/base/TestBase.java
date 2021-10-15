package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:/Users/dudha/Desktop/QA/Selenium_WorkSpace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	public static void intiialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\dudha\\Desktop\\QA\\SeleniumJars\\geckodriver.exe");	
			 driver = new FirefoxDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\dudha\\Desktop\\QA\\SeleniumJars\\chromedriver.exe");	
			 driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
}
