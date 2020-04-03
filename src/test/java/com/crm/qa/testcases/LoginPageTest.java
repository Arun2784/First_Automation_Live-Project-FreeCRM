package com.crm.qa.testcases;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;

	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod

	public void setup() {

		initialization();

		loginpage = new LoginPage();

	}

	@Test(priority = 1)

	public void loginPageTitleTest() {

		String title = loginpage.validationTitle();

		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		//System.out.println("Yaha tak aapka code sahi chal rha h");
	}

	@Test(priority = 2)

	public void crmLogoImageTest() {

		boolean flag = loginpage.validationCRMLogo();
		Assert.assertTrue(flag);
		//System.out.println("Ye code bhi mast hai");
	}

	@Test(priority = 3)

	public void loginTest() {

		// loginpage.login(prop.getProperty(username), pswd)

		homepage = loginpage.login(prop.getProperty("username1"), prop.getProperty("password"));
	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

	}
}
