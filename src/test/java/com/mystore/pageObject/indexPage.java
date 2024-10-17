package com.mystore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	//1. create object of webdriver
		WebDriver ldriver;

		//constructor
		public indexPage(WebDriver rdriver)
		{
			ldriver = rdriver;
			

			PageFactory.initElements(rdriver, this);
		}


		//identify webelements
		@FindBy(linkText = "Sign in") 
		WebElement signIn;
		
		@FindBy(xpath="(//a[text()='T-shirts'])[2]")
		WebElement tshirtMenu;
		
		
		//identify action on webelement
		public void clickOnSignIN() {
			signIn.click();
		}
		
		public String getPageTitle()
		{
			return(ldriver.getTitle());
		}
		
		public void clickOnTShirtMenu()
		{
			tshirtMenu.click();
		}
}
/*
 * What is an automation Framework?
 * 		It is a collection of files and tools working together to support automated testing of any web application.
 * What is automation Framework development?
 *		Organization of all automation files, libraries & other tools we need for automation testing is called automation Framework development.
 * for eg: Test data file, Test cases, utility files, configuration file, drivers, Test Reports etc.
 * Advantage:
 * 		1. Manitability
 * 		2. Reusablity
 * 		3. Code shall be generic so that same code should be use for testing in different appliction testing.
 * 
 * A good framework should support:
 * 		1. Reusable methods
 * 		2. Logging feature i.e logs for what is happening in the application
 * 		3. Low maintanence
 * 		4. Reporting
 * 		5. Test case maping with manual
 * 		6. Data Changes without compiling.
 * 
 * Steps To build automation Framework
 * 		1. Chose a programing language - Java
 * 		2. Chose a unit test framework - TestNG
 * 		3. Design the framework architecture
 * 			a. Page Object Model with page factory(Page Object Model consider every webpage as a Application and for every application we 
 * 				maintain a class and in that class we identiyf the elements and actions to be performed on that webpage/application element
 * 				page factory is an approach to implement Page Object Model in this to find a webelemnt we us @findBy, @inItElement is use to create webElement).
 * 			b. Maven(Automation Build Tool)
 * 			c. Utilities for different generic functions(Read excel file(test data file), listener class, read configuration file.
 * 		4. Reporting mechanism - Extent Report(Dashboard(Pass/fail test case)(IReport Interface is alos there to customise report but not so good)
 * 		5. Log4j2(Logging API)
 * 		6. Chose a Version Control mechanism - Git and Git hub.(for maintanence)
 * 		7. Decide how to implement CI/CD - Jenkins
 * Configuration file(config.properties) : We keep all the hardcoded values here which are common for all test cases to read this we make ReadConfig.java
 * in utilities package.
 * 
 * 
 * 		
 */