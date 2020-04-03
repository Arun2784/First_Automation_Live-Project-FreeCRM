package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {

	@FindBy(id="title")
	WebElement title;
	
	
	@FindBy(name="client_lookup")
	
	WebElement company;
	
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	
	WebElement dealsSavebtn;
	
	public DealsPage() {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void createNewDeals(String dealsTitle, String dealsCompanyname) {
		
		
		title.sendKeys(dealsTitle);
		company.sendKeys(dealsCompanyname);
		
		dealsSavebtn.click();
	}
	
	
	
}
