package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil utilPage;
	ContactsPage contactsPage;
	String sheetName="Sheet1";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		utilPage = new TestUtil();
		contactsPage = new ContactsPage();
		//here homePage object is coming from loginPage, so its chained. the purpose of loginPage is landing next landingPage.
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		utilPage.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
		
		
		
	}
	
	@Test(priority = 1, enabled = true)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContanctsLabel(), "contacts label is missing") ;
	}
	
	@Test(priority = 2, enabled = true )
	public void selectContactsTest() {
		contactsPage.selectContactsByName("a,b");
	}
	
	@Test(priority = 3, enabled = true)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("a b");
		contactsPage.selectContactsByName("aaa aaa");
	}
	
	@Test (priority = 4, enabled = false )
	public void validateCreateNewContact() {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Sir", "Tom", "Peter", "Google");
	}
	
	 
	
	@DataProvider
	public Object[][] getCrmTestData() {
		Object data [][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority =5, enabled= false, dataProvider = "getCrmTestData")
	public void validateCreateNewContact(String title, String firstname, String lastname, String company) {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstname, lastname, company);
		
	}
	
	@AfterMethod(enabled = true)
	public void tearDown() {
		driver.quit(); 
	}
	
}
