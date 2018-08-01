package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(), 'New Contact')]")
	WebElement newContactLink;
	
	@FindBy (xpath="//font[contains(text(), 'Naveen K')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Tasks')]")
	WebElement TasksLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		Actions a = new Actions(driver);
		a.moveToElement(contactsLink).click().build().perform();
		//contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		DealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() {
		TasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		Actions a = new Actions (driver);
		a.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
		
	}
	

}
