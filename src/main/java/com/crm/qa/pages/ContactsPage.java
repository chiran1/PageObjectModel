package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;


public class ContactsPage extends TestBase {

	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy (xpath= "//*[@name='title']")
	WebElement contactTitle;
	
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement LastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//parent::td[@colspan='2']//input[@type='submit' and @value = 'Save']")
	WebElement saveBtn;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContanctsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		//driver.findElement(By.xpath("//a["+name+"(text(), 'Contacts')]")).click();;// 
		driver.findElement(By.xpath("//table[@class='datacard']//tbody//tr[4]//td[2]//a"));
		//false xpath
		// "+name+" is added because if you want to choose the number of names in table then simply 
		//pass in the parameter. Here the name is repeated so cant add name in between. 
 	
	}
	
	public void createNewContact(String title, String ftName,  String ltName, String comp) {
		//Select select = new Select(driver.findElement(By.name("title")));
		Select select = new Select(contactTitle);
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName); 
		LastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	
	
	
	

		
	
	
}
