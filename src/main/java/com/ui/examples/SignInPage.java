package com.ui.examples;

import static com.ui.examples.PheonixLocator.*;

import org.openqa.selenium.By;

public final class SignInPage extends BrowserUtil {
	
	

	private static final By USER_NAME_TEXTBOX_LOCATOR = locateByID("username");
	private static final By PASSWORD_TEXTBOX_LOCATOR = locateByID("password");
	private static final By SIGN_IN_BUTTON_LOCATOR = locateByXPath("//span[contains(text(),'Sign in')]");
	
	public SignInPage(Browser browser) {
		super(browser);
		maximizeBrowser();
		goToWebsite("http://phoenix.techwithjatin.com/");
	}
	
	public void doSignInWith(String userName,String password) {
		
		enterTextInto(USER_NAME_TEXTBOX_LOCATOR, userName);
		enterTextInto(PASSWORD_TEXTBOX_LOCATOR, password);
		
	}
	

}
