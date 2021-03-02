package com.testAutomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.testAutomation.Utlitis.Helper;
import com.testAutomation.Utlitis.browserFactory;
import com.testAutomation.Utlitis.configDataProvider;
import com.testAutomation.Utlitis.excelDataProvider;

public class Base
	{
		public WebDriver driver;
		public excelDataProvider excel;
		public configDataProvider config;
		public ExtentReports report;
		public ExtentTest logger;

		@BeforeSuite
		public void setupSuite()
			{
				Reporter.log("Setting Up Basic configuration started", true);
				excel = new excelDataProvider();
				config = new configDataProvider();
				ExtentHtmlReporter extentReport = new ExtentHtmlReporter(new File(System.getProperty("user.dir")
						+ "/Reports/CRMReport_" + Helper.getCurrentDateTime() + ".html"));
				report = new ExtentReports();
				report.attachReporter(extentReport);
				Reporter.log("Setting Up Basic configurating is fine", true);

			}

		@BeforeClass
		public void setup()
			{
				Reporter.log("Setting Up browser and applicaiton configurating is started", true);
				driver = browserFactory.startApplicaiton(driver, config.getBrowser(), config.getTestUrl());
				Reporter.log("Setting Up browser and applicaiton configurating is fine", true);
			}

		@AfterClass
		public void teardown()
			{
				browserFactory.closeBrowser(driver);
				Reporter.log("Current browser session is closed succesfully", true);
			}

		@AfterMethod
		public void teardownMethod(ITestResult result) throws IOException
			{
				Reporter.log("Preparing reprorts started", true);

				if (result.getStatus() == ITestResult.FAILURE)
					{
						// Helper.takeScreenShot(driver);
						logger.fail("Test Faild",
								MediaEntityBuilder.createScreenCaptureFromPath(Helper.takeScreenShot(driver)).build());
					} else if (result.getStatus() == ITestResult.SUCCESS)
					{
						logger.pass("Test Passed",
								MediaEntityBuilder.createScreenCaptureFromPath(Helper.takeScreenShot(driver)).build());
					} else if (result.getStatus() == ITestResult.SKIP)
					{
						logger.skip("Test Passed",
								MediaEntityBuilder.createScreenCaptureFromPath(Helper.takeScreenShot(driver)).build());
					}

				report.flush();
				Reporter.log("Reprorts generated succesfully", true);

			}

	}
