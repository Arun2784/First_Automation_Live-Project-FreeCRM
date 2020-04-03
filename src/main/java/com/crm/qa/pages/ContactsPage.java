package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
    @CacheLookup
	WebElement contactsLebel;

	@FindBy(name = "title")
	WebElement selectTitle;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(name = "client_lookup")
	WebElement company;

	@FindBy(xpath = "//input[@type='submit'and @value='Save']")
	WebElement saveBtn;

	public ContactsPage() {

		PageFactory.initElements(driver, this);

	}

	public boolean verifyContactPageLebel() {

		return contactsLebel.isDisplayed();

	}

	public void creatNewContact(String title, String ftName, String ltName, String companyName) {

		// Select select = new Select(driver.findElement(By.name("title")));

		Select select = new Select(selectTitle);

		select.selectByVisibleText(title);

		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(companyName);

		saveBtn.click();

	}

}
