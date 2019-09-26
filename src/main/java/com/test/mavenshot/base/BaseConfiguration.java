package com.test.mavenshot.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseConfiguration {
	
	/* In BaseConfigurationClass we set the WebDriver and Properties
	 */
	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver initialize_Webdriver(String browsername) 
	{
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
			if(prop.getProperty("headlessValue").equals("yes"))
			{
				ChromeOptions options=new ChromeOptions();
				options.setHeadless(true);
				driver=new ChromeDriver(options);
			}
			else
			{
				driver=new ChromeDriver();
			}
				
		}else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D://Learning//JARFiles//geckodriver.exe");
			if(prop.getProperty("headlessValue").equals("yes"))
			{
				FirefoxOptions options=new FirefoxOptions();
				options.setHeadless(true);
				driver=new FirefoxDriver(options);
			}
			else
			{
				driver=new FirefoxDriver();
			}
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();			
		return driver;
			
	}
	
	public Properties initialize_Properties() throws IOException
	{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("D://Learning//Workspace//SeleniumMavenShot1//src//main//java//com//test//mavenshot//config//config.properties");
		prop.load(ip);
		return prop;
	}

}
