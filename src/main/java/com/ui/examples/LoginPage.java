package com.ui.examples;
import static com.ui.examples.PheonixLocator.*;

public class LoginPage {
	
	public static void main(String args[]) {
		SignInPage signInPage = new SignInPage(Browser.CHROME);
		signInPage.doSignInWith("iamfd", "password");
	}

}
