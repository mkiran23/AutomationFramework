package com.ui.examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class PheonixLocator extends By {

	@Override
	public List<WebElement> findElements(SearchContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static By locateByID(String id) {
		return id(id);
	}
	
	public static By locateByXPath(String xpath) {
		return xpath(xpath);
	}
	
	public static By locateByLinkText(String linkText) {
		return linkText(linkText);
	}
	
	public static By locateByPartialLinkText(String partialLinkText) {
		return partialLinkText(partialLinkText);
	}
	
	public static By locateByName(String name) {
		return name(name);
	}
	
	public static By locateByTagName(String tagName) {
		return tagName(tagName);
	}
	
	public static By locateByClassName(String className) {
		return className(className);
	}
	
	public static By locateByCssSelector(String text) {
		return cssSelector(text);
	}

}
