package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.utill.TestUtil;

public class TaskPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homePage;
	TaskPage taskPage;
	TestUtil testUtil;
	String sheetName = "task";

	public TaskPageTest() {

		super();

	}

	@BeforeMethod

	public void setup() {

		initialization();
		testUtil = new TestUtil();
		loginpage = new LoginPage();
		homePage = new HomePage();
		homePage = loginpage.login(prop.getProperty("username1"), prop.getProperty("password"));
		testUtil.switchToFrame();
		taskPage = new TaskPage();

	}

	@DataProvider

	public Object[][] gettaskData() throws InvalidFormatException {

		Object data[][] = TestUtil.getTestData(sheetName);
		return data;

	}

	@Test(priority = 1, dataProvider = "gettaskData")

	public void createNewTask(String title, String status, String type, String priority, String taskName) {

		taskPage.clickOnNewTaskPage();
		taskPage.createNewTask(title, status, type, priority, taskName);
		
		System.out.println("Successfully Task Created");

	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

	}

}
