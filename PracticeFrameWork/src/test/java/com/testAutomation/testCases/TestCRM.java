package com.testAutomation.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.testAutomation.Utlitis.Helper;
import com.testAutomation.pages.Base;
import com.testAutomation.pages.loginPage;

public class TestCRM extends Base
	{

		@Test
		public void testLogin() throws InterruptedException
			{
				logger = report.createTest("Login to TestCRM Test");
				String uname = excel.getStringData("Login", 0, 0);
				String pass = excel.getStringData("Login", 0, 1);
				System.out.println(pass);
				loginPage lp = PageFactory.initElements(driver, loginPage.class);
				logger.info("Starting Application");
				lp.loginCRM(uname, pass);
				logger.pass("Login is successfully");
				Helper.takeScreenShot(driver);
				logger.info("Screen shot taken");
			}

	}
