package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utill.TestUtil;

public class DealsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	String sheetname = "deals";

	public DealsPageTest() {
		super();
	}

	@BeforeMethod

	public void setup() {

		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username1"), prop.getProperty("password"));
		testUtil.switchToFrame();
		dealsPage = new DealsPage();
		//dealsPage = homePage.clickOnDealsLink();

	}

	@DataProvider

	public Object[][] getDealsTestData() throws InvalidFormatException {
		Object data[][]=TestUtil.getTestData(sheetname);
		
		return data;
	}

	@Test(priority = 1, dataProvider = "getDealsTestData")

	public void addNewDeals(String title, String companyname) {
		homePage.clickonNewDealsLink();
		dealsPage.createNewDeals(title, companyname);

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}
