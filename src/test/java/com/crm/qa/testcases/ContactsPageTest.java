package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utill.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName="contacts";

	public ContactsPageTest() {
		super();

	}

	@BeforeMethod

	public void setup() {

		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();

	}

	@Test(priority = 1)

	public void verifyContactsPageLebel() {
		Assert.assertTrue(contactsPage.verifyContactPageLebel(), "Contacts Lebel missing on the Page");

	}

	
	@DataProvider	
	
	public Object[][] getCRMTestData() throws InvalidFormatException {
		
		Object data [][]=TestUtil.getTestData(sheetName);
		
		return data;
		
	}
	
	
	@Test(priority = 2,dataProvider = "getCRMTestData")

	public void validateNewContact(String title, String Firstname, String lastName, String company) {
		
		
		homePage.clickonNewContactLink();
		//contactsPage.creatNewContact("Mr.", "Arun", "Pandey", "PureSoftware");
		contactsPage.creatNewContact(title, Firstname, lastName, company);
		
	}
	
	@AfterMethod

	public void tearDown() {

		driver.quit();
	}


}
