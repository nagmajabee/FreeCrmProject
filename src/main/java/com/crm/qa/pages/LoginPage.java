package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	//PageFactory-----Or(Object Repository)
@CacheLookup
@FindBy(xpath="//input[@name='username']")
WebElement uname;
@CacheLookup
@FindBy(xpath="//input[@name='password']")
WebElement pwd;
@CacheLookup
@FindBy(xpath="//input[@type='submit']")
WebElement LoginBtn;
@CacheLookup
@FindBy(xpath="//img[@alt='free crm logo']")
WebElement CrmLogo;
@CacheLookup
@FindBy(xpath="//button[@class='btn' and @type='button']")
WebElement SignUpBtn;

//Initialization of PageObject
public LoginPage(){
	PageFactory.initElements(driver,this);
}
//Actions
public String validateLoginPageTitle() {
	return driver.getTitle();
	
}
public SignupPage clickOnSignUpBtn() {
	((JavascriptExecutor)driver).executeScript("arguments[0].click();", SignUpBtn);
	return new SignupPage();
}
public boolean validateCrmLogo() {
	return CrmLogo.isDisplayed();
}
public boolean validateSignUpBtn() {
	return SignUpBtn.isDisplayed();
}
public HomePage login(String un,String pw) throws Exception {
	uname.sendKeys(un);
	pwd.sendKeys(pw);
	Thread.sleep(5000);
	LoginBtn.click();
	return new HomePage();
}
}
