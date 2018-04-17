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
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browser) {
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
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
	@Test(priority=2)
	public void crmLogoTest() {
		boolean flag = loginPage.validateCrmLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void SignUpBtnTest() {
		boolean flag=loginPage.validateSignUpBtn();
		Assert.assertTrue(flag);
	}
	@Test(priority=4)
	public void loginTest() throws Exception  {
			homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test(priority=5)
	public void clickonSignupTest() {
		loginPage.clickOnSignUpBtn();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
