package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class SignupPage extends TestBase{
	//pageFactory.....>
@FindBy(name="payment_plan_id")
WebElement selectEdition;
@FindBy(name="first_name")
WebElement First_name;
@FindBy(name="surname")
WebElement Last_name;
@FindBy(name="email")
WebElement email;
@FindBy(name="email_confirm")
WebElement Confirm_email;
@FindBy(name="username")
WebElement username;
@FindBy(name="password")
WebElement password;
@FindBy(name="passwordconfirm")
WebElement confirm_password;
@FindBy(name="agreeTerms")
WebElement selectagreeTerms;
@FindBy(name="submitButton")
WebElement submitBtn;
//initialization
public SignupPage() {
	PageFactory.initElements(driver, this);
}
//actions
public void createNewAccount() {
	Select select=new Select(selectEdition);
	select.selectByVisibleText("Free Edition");
	First_name.sendKeys("Rohit");
	Last_name.sendKeys("Ranjan");
	email.sendKeys("rohit.ranjan10@hotmail.com");
	Confirm_email.sendKeys("rohit.ranjan10@hotmail.com");
	username.sendKeys("rohitranjan");
	password.sendKeys("rohitranjan");
	confirm_password.sendKeys("rohitranjan");
	selectagreeTerms.click();
	submitBtn.click();
}
}
