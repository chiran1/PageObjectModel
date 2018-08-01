package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {
	
	
	//we have to define two things, page Factory of login page or also called Object Repository
	//use @FindBy() annotation
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//now initialize the object repositories or webelements with the help of page factory.
	// for that we have to create a constructor of the class. 
	
	//initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);//instead of this you can write LoginPage.class//pointing to the current class object
	}
	
	//now create a methods
	
	//Actions: ------means different features in webpage
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}  
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		TestUtil.modalPopUps();
		Actions a = new Actions(driver);
		a.moveToElement(loginBtn).click().build().perform();
		
		//loginBtn.click();//now this login method should return homepage
		
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	
	

}
