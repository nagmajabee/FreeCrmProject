package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class NewContactPage extends TestBase{
	//FindBy......>
@FindBy(xpath="//legend[.='Contact Information']")
WebElement ContactInformationLabel;
@FindBy(name="title")
WebElement titles;
@FindBy(id="first_name")
WebElement firstname;
@FindBy(id="surname")
WebElement surname;
@FindBy(name="client_lookup")
WebElement company;
@FindBy(xpath="//input[@name='image_file']")
WebElement image;
@FindBy(xpath="//input[@type='submit' and @value='Save']/../input[2]")
WebElement saveBtn;
//Initialization of Element
public NewContactPage() {
	PageFactory.initElements(driver, this);
}
//Actions
public boolean verifyContactInformationLabel() {
	return ContactInformationLabel.isDisplayed();
}
public void createNewContact(String title,String fname,String sname,String comp) {
	Select select=new Select(titles);
	select.selectByVisibleText(title);
	firstname.sendKeys(fname);
	surname.sendKeys(sname);
	image.sendKeys("F:\\nagma resume\\Photo.jpg");
	company.sendKeys(comp);
	saveBtn.click();
}
}
