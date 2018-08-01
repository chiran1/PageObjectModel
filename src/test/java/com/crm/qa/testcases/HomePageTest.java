package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil utilPage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		//here homePage object is coming from loginPage, so its chained. the purpose of loginPage is landing next landingPage.
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		utilPage = new TestUtil();
		contactsPage = new ContactsPage();
	}
	
	
	@Test (priority=1)
	public void verifyHomePageTitleTest() {
		String actualHomePageTitle =homePage.verifyHomePageTitle();
		Assert.assertEquals(actualHomePageTitle, "CRMPRO", "Home page title not matched");//only printed if it is failed
	}
	
	@Test(priority=2)
	public void verifyCorrectUserNameTest() {
		utilPage.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	
	public void verifyContactsLinkTest() {
		utilPage.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
