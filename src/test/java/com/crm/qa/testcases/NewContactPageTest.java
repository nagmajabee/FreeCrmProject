package com.crm.qa.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.testUtil.TestUtil;

public class NewContactPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	TestUtil testUtil;
	NewContactPage newContactPage;
	String sheet_name="new Contact";

public NewContactPageTest() {
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
	contactPage=new ContactsPage();
	testUtil=new TestUtil();
	newContactPage=new NewContactPage();
	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	testUtil.switchToFrame();
	homePage.clickOnNewContactLink();
	
}
@Test(priority=1)
public void verifyContactInformationLabelTest() {
	boolean newContact=newContactPage.verifyContactInformationLabel();
	Assert.assertTrue(newContact,"ContactInformation is missing");
}
@DataProvider
public Object[][] getData() {
	Object data[][]=TestUtil.getTestdata(sheet_name);
	return data;
}
@Test(priority=2,dataProvider="getData")
public void createNewContactTest(String title,String fname,String sname,String comp) {
	newContactPage.createNewContact( title, fname, sname, comp);
}
@AfterMethod
public void tearDown() {
	driver.quit();
}
}
