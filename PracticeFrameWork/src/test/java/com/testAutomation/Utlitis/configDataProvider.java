package com.testAutomation.Utlitis;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configDataProvider
	{

		Properties prop;

		public configDataProvider()
			{

				File src = new File("./Configuration/config.properties");
				FileInputStream fis;
				try
					{
						fis = new FileInputStream(src);
						prop = new Properties();
						prop.load(fis);

					} catch (Exception e)
					{
						System.out.println("Unable to Load Configuation file" + e.getMessage());
					}
			}

		public String getDataFromConfig(String configValue)
			{

				return prop.getProperty(configValue);

			}

		public String getBrowser()
			{
				return prop.getProperty("Browser");
			}

		public String getTestUrl()
			{
				return prop.getProperty("qaUrl");
			}

	}
