package com.ui.examples;
import static com.ui.examples.PheonixLocator.*;

public class LoginPage {
	
	public static void main(String args[]) {
		BrowserUtil bu=new BrowserUtil(Browser.CHROME);
		bu.maximizeBrowser();
		bu.goToWebsite("http://phoenix.techwithjatin.com/");
		bu.enterTextInto(locateByID("username"), "iamfd");
		bu.enterTextInto(locateByID("password"), "password");
	}

}
