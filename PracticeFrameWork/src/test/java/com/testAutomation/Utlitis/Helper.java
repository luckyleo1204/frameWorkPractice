package com.testAutomation.Utlitis;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper
	{

		public static String takeScreenShot(WebDriver driver)
			{
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String screenShotpath = System.getProperty("user.dir") + "/ScreenShots/FreeCRM_" + getCurrentDateTime()
						+ ".png";
				try
					{
						FileHandler.copy(src, new File(screenShotpath));
						System.out.println("Screen shot is captured");
					} catch (IOException e)
					{
						System.out.println("Unable to take screen shot" + e.getMessage());
					}
				return screenShotpath;
			}

		public static String getCurrentDateTime()
			{

				DateFormat customDateformat = new SimpleDateFormat("MM_dd_yyyy_HH_MM_SS");
				Date currentDate = new Date();
				return customDateformat.format(currentDate);

			}

		public void handlFrames()
			{

			}

		public void handleAlert()
			{

			}

		public void multipleWindows()
			{

			}

		public void javaScriptExecutor()
			{

			}

		public void sync()
			{

			}

	}
