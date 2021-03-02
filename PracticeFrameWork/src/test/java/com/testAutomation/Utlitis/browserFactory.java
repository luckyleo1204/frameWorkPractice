package com.testAutomation.Utlitis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browserFactory
	{

		public static WebDriver startApplicaiton(WebDriver ldriver, String browser, String url)
			{
				if (browser.equalsIgnoreCase("chrome"))
					{
						System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
						ldriver = new ChromeDriver();

					} else if (browser.equalsIgnoreCase("firefox"))
					{
						System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
						ldriver = new FirefoxDriver();

					} else if (browser.equalsIgnoreCase("IE"))
					{
					} else
					{
						System.out.println("we do not support this browser");
					}
				ldriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				ldriver.get(url);
				ldriver.manage().window().maximize();
				ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				return ldriver;

			}

		public static void closeBrowser(WebDriver ldriver)
			{
				ldriver.quit();

			}

	}
