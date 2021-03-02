package com.testAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage
	{

		WebDriver driver;

		public loginPage(WebDriver ldriver)
			{

				this.driver = ldriver;
			}

		@FindBy(xpath = "//span[@class=\"icon icon-xs mdi-chart-bar\"]")
		WebElement LoginButton;
		@FindBy(name = "email")
		WebElement uname;
		@FindBy(name = "password")
		WebElement passwd;
		@FindBy(xpath = "//div[@class=\"ui fluid large blue submit button\"]")
		WebElement loginButton;

		public void loginCRM(String username, String password) throws InterruptedException
			{

				LoginButton.click();
				uname.sendKeys(username);
				passwd.sendKeys(password);
				loginButton.click();
			}

	}
