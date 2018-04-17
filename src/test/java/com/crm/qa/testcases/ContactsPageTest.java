package com.crm.qa.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testUtil.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	public ContactsPageTest(){
		super();
	}
	   @Parameters({"browser"})
		@BeforeMethod
		public void setUp(String browser) throws Exception {
			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if(browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
				driver=new FirefoxDriver();
				}
			else if(browser.equals("Ie")) {
				driver=new InternetExplorerDriver();
				}
		initialization();
		loginPage=new LoginPage();
		homePage=new HomePage();
		contactsPage=new ContactsPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactLink();
		
	}
	@Test(priority=1)
	public void verifycontactLabelTest() {
		boolean contactLabel=contactsPage.verifycontactLabel();
		Assert.assertTrue(contactLabel,"contactLabel is not matched");
	}
	@Test(priority=2)
	public void selectContactByNameTest() {
		contactsPage.selectContactByName("farhat jamal");
		contactsPage.selectContactByName("sadab alam");
		contactsPage.selectContactByName("md shakeel");
		
	}
	@Test(priority=3)
	public void searchContactByLetterTest() {
		contactsPage.searchContactByLetter('N');
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
