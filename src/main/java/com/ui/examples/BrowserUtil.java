package com.ui.examples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BrowserUtil {
	
	private WebDriver wd;
	private WebDriverWait wait;
	
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
		wait = new WebDriverWait(wd, Duration.ofSeconds(30));
	}
	
	public void goToWebsite(String url) {
		wd.get(url);
	}
	
	public void maximizeBrowser()
	{
		wd.manage().window().maximize();
	}
	
	public void enterTextInto(By locator, String textToEnter) {
		//WebElement element = wd.findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
	
	public void clickOnElement(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
}
