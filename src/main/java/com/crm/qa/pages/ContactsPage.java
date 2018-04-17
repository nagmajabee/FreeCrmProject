package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	//page factory....>
@FindBy(xpath="(//td[@class='datacardtitle'])[4]")
WebElement contactsLabel;
//initialization
public ContactsPage() {
	PageFactory.initElements(driver, this);
}
//actions
public boolean verifycontactLabel() {
	return contactsLabel.isDisplayed();
}
public void searchContactByLetter(char letter) {
	driver.findElement(By.xpath("//td[.='"+letter+"']")).click();
}
public void selectContactByName(String name) {
	driver.findElement(By.xpath("(//a[.='"+name+"']/../..//input[@name='contact_id'])[1]")).click();
}

}
