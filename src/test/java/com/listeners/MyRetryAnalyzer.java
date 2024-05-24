package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer{
	
	private static int count=1;
	private static int MAX_ATTEMPT=3;

	@Override
	public boolean retry(ITestResult result) {
		if(count<=MAX_ATTEMPT) {
			count=count+1;
			return true;
		}
		else {
			return false;
		}
	}

}
