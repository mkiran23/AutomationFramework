package com.runner;

import java.util.ArrayList;

import org.testng.TestNG;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;
import org.testng.xml.XmlTest;

public class FrameworkRunner {
// Take the parameters from the enduser / terminal ------ Run time Arguments
// it will call method which will create the Dynamic Test ng xml file

	public static void main(String[] args) {
		//Jenkins
		String component = "api";
		String testType = "sanity";
		String env = "QA";

		runTestNG(component, testType, env);

	}

	private static void runTestNG(String component, String testType, String env) {
		// method which will create the Dynamic Test ng xml file

		TestNG testng = new TestNG();

		// <suite name="API Test Suite" guice-stage="QA">

		XmlSuite xmlSuite = new XmlSuite();
		xmlSuite.setName("Api test suite");
		xmlSuite.setGuiceStage(env); // <suite name="API Test Suite" guice-stage="QA">
		xmlSuite.setParallel(ParallelMode.METHODS);
		xmlSuite.setThreadCount(5);
		// <test name="Phoenix API Tests">

		XmlTest xmlTest = new XmlTest(xmlSuite);//****
		xmlTest.setName("Phoenix API Test"); // <test name="Phoenix API Tests">

		XmlPackage xmlPackage = new XmlPackage();
		xmlPackage.setName("com." + component + ".tests");

//		// Collection
//		int x[] = new int[5];
//		ArrayList<Integer> al = new ArrayList<Integer>();

		ArrayList<XmlPackage> packagesList = new ArrayList<XmlPackage>();
		packagesList.add(xmlPackage);

		xmlTest.setXmlPackages(packagesList);
	
		/*
		 * <test name="Phoenix API Tests"> <include groups ="sanity"/> <packages>
		 * <package name ="com.api.tests" >
		 * <package name ="com.api.tests" >
		 * <package name ="com.api.tests" >
		 * <package name ="com.api.tests" >

		 * </packages>
		 */
		
		xmlTest.addIncludedGroup(testType); //This very important

		ArrayList<XmlTest> testList = new ArrayList<XmlTest>();
		testList.add(xmlTest);
		
		xmlSuite.setTests(testList);
		
		ArrayList<XmlSuite> xmlSuiteList = new ArrayList<XmlSuite>();
		xmlSuiteList.add(xmlSuite);
		
		testng.setXmlSuites(xmlSuiteList);
		testng.run();
		
		
	}
}
