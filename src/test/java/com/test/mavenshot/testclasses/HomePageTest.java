package com.test.mavenshot.testclasses;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.mavenshot.base.BaseConfiguration;
import com.test.mavenshot.utils.ExplicitWaitUtil;

public class HomePageTest {
	
	public BaseConfiguration base;
	public ExplicitWaitUtil wait;
	public Properties prop;
	public WebDriver driver;
	
	
	@BeforeMethod
	public void initialize() throws IOException
	{
		base=new BaseConfiguration();
		prop=base.initialize_Properties();
		driver=base.initialize_Webdriver(prop.getProperty("browserValue"));		
	}
	
	@Test
	public void homePageTest() throws InterruptedException
	{
		driver.get(prop.getProperty("urlValue"));
		WebElement userName=driver.findElement(By.id(prop.getProperty("userNameLocatorId")));
		userName.sendKeys(prop.getProperty("userNameValue"));
		WebElement passWord=driver.findElement(By.id(prop.getProperty("passWordLocatorId")));
		passWord.sendKeys(prop.getProperty("passWordValue"));
		WebElement logInBtn=driver.findElement(By.id(prop.getProperty("logInBtnLocatorId")));
		logInBtn.click();

		WebElement contactsBtn=driver.findElement(By.id(prop.getProperty("contactsBtnId")));
		wait=new ExplicitWaitUtil();
		wait.explicitWaitTillElementClickable(driver, contactsBtn);
		
		//verifying if contacts button is enabled
		Assert.assertTrue(contactsBtn.isEnabled());
	
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
