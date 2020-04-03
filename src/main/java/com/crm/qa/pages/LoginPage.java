package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// PageFacotry or OR--means Object repositry

	@FindBy(name = "username")

	WebElement username;

	@FindBy(name = "password")

	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")

	WebElement loginbtn;

	@FindBy(xpath = "//button[contains='Signup']")

	WebElement signup;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")

	WebElement crmlogo;

	// Intializing the page factory

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	// Action

	public String validationTitle() {

		return driver.getTitle();

	}

	public boolean validationCRMLogo() {

		return crmlogo.isDisplayed();

	}

	public HomePage login(String un, String pswd) {

		username.sendKeys(un);
		password.sendKeys(pswd);
		loginbtn.click();

		return new HomePage();

	}

}
