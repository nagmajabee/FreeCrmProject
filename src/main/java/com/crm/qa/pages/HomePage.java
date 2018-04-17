package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
@FindBy(xpath="(//td[contains(.,'User: nagma jabee')])[2]")
WebElement usernameLabel;
@FindBy(xpath="//a[.='Contacts']")
WebElement contactsLink;
@FindBy(xpath="//a[.='Tasks']")
WebElement taskLink;
@FindBy(xpath="//a[.='Deals']")
WebElement dealsLink;
@FindBy(xpath="//a[.='Cases']")
WebElement casesLink;
@FindBy(xpath="//td[@class='logo_text']")
WebElement logo;
@FindBy(xpath="//a[.='New Contact']")
WebElement newContactLink;


public HomePage() {
	PageFactory.initElements(driver, this);
}
public String verifyHomePageTitle() {
	return driver.getTitle();
}
public boolean verifyCorrectUsernameLabel() {
	return usernameLabel.isDisplayed();
}

public ContactsPage clickOnContactLink() {
	contactsLink.click();
	return new ContactsPage();
}
public DealsPage clickOnDealsLink() {
	dealsLink.click();
	return new DealsPage();
}
public TaskPage clickOnTasksLink() {
	taskLink.click();
	return new TaskPage();
}
public CasesPage clickOnCasesLink() {
	taskLink.click();
	return new CasesPage();
}
public boolean verifyLogo() {
	return logo.isDisplayed();
}
public NewContactPage clickOnNewContactLink() {
	Actions action=new Actions(driver);
	action.moveToElement(contactsLink).build().perform();
	newContactLink.click();
	return new NewContactPage();
}

}
