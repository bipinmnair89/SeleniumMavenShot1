package com.test.mavenshot.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitUtil {
	
	public void explicitWaitTillElementClickable(WebDriver driver, WebElement value)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(value));
		System.out.println("Executing util class - explicitWaitTillElementClickable");
		
	}
	
	public void explicitWaitTillElementVisible(WebDriver driver, WebElement value)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(value));
		System.out.println("Executing util class - explicitWaitTillElementVisible");
	}
}
