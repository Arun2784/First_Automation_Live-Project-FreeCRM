package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class TaskPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")

	WebElement taskLink;

	@FindBy(xpath = "//a[contains(text(),'New Task')]")
	WebElement newTaskLink;

	@FindBy(id = "title")

	WebElement taskTitle;

	@FindBy(xpath = "//select[@name='status' and @class='select']")

	WebElement taskStatus;

	@FindBy(xpath = "//select[@name='task_type' and @class='select']")

	WebElement taskType;

	@FindBy(xpath = "//select[@name='priority' and @class='select']")

	WebElement taskPriority;

	@FindBy(xpath = "//input[@type='text' and @name='prospect_lookup']")

	WebElement taskName;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")

	WebElement taskSavebtn;

	public TaskPage() {

		PageFactory.initElements(driver, this);

	}

	public void clickOnNewTaskPage() {

		Actions action = new Actions(driver);

		action.moveToElement(taskLink).build().perform();

		newTaskLink.click();
	}

	public void createNewTask(String title, String status, String type, String priority, String taskNametask) {

		taskTitle.sendKeys(title);
		Select statustask = new Select(taskStatus);
		statustask.selectByVisibleText(status);

		Select typeTask = new Select(taskType);
		typeTask.selectByVisibleText(type);

		Select prioritytask = new Select(taskPriority);
		prioritytask.selectByVisibleText(priority);

		taskName.sendKeys(taskNametask);

		taskSavebtn.click();

	}

}
