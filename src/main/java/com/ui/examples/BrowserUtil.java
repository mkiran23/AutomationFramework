package com.ui.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {
	
	private WebDriver wd;
	
	public BrowserUtil(Browser browser) {
		if(browser.equals(Browser.CHROME)) {
			wd = new ChromeDriver();
		}
		else if(browser.equals(Browser.FIREFOX)) {
			wd = new FirefoxDriver();
		}
		else if(browser.equals(Browser.EDGE)) {
			wd = new EdgeDriver();
		}
	}
	
	public void goToWebsite(String url) {
		wd.get(url);
	}
	
	public void maximizeBrowser()
	{
		wd.manage().window().maximize();
	}
	
	public void enterTextInto(By locator, String textToEnter) {
		sleepFor(5);
		WebElement element = wd.findElement(locator);
		element.clear();
		element.sendKeys(textToEnter);
	}
	
	public void sleepFor(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
