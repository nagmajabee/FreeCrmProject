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

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	TestUtil testutil;
	public HomePageTest() {
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
	testutil=new TestUtil();
	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
}
@Test(priority=1)
public void verifyHomePageTitleTest() {
	Assert.assertEquals(homePage.verifyHomePageTitle(), "CRMPRO","Homepage title is not matched");
}
@Test(priority=2)
public void verifyUsernameTest(){
	testutil.switchToFrame();
	Assert.assertTrue(homePage.verifyCorrectUsernameLabel());
}
@Test(priority=3)
public void verifycontactsLinkTest() {
	testutil.switchToFrame();
	contactPage=homePage.clickOnContactLink();
}
@Test(priority=4)
public void verifylogoTest() {
	testutil.switchToFrame();
	Assert.assertTrue(homePage.verifyLogo());
}
@AfterMethod
public void tearDown() {
	driver.quit();
}
}
