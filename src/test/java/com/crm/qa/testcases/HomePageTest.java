package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utill.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();

	}

	@BeforeMethod

	public void setup() {

		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password"));

	}

	// Test Cases should be separated--independent each other

	// before each test case --launch the browser and login
	// @test--execute test case
	// After each Testcase--close the browser

	@Test(priority = 1)

	public void verifyHomePageTitleTest() {

		String homePageTitle = homePage.verifyHomePageTitle();

		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page Title is not matched");

	}

	@Test(priority = 2)

	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());

	}

	@Test(priority = 3)

	public void verifiedContactLinks() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

	}

}
