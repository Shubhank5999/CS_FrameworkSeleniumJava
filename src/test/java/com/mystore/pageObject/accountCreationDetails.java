package com.mystore.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountCreationDetails {
	WebDriver ldriver;
	//constructor
	public accountCreationDetails(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//identify webElement
	@FindBy(id="id_gender1")//for tiltle Mr
	WebElement titleMr;
	
	@FindBy(id = "customer_firstname")
	WebElement customerFirstName;
	
	@FindBy(id = "customer_lastname")
	WebElement customerLastName;
	
	@FindBy(id = "passwd")
	WebElement password; 
	
	@FindBy(id = "submitAccount")
	WebElement register;
	
	//identify actions on webelement
	public void selectTitleMr() {
		titleMr.click();
	}
	public void enterCustomerFirstName(String fname)
	{
		customerFirstName.sendKeys(fname);
	}
	public void enterCustomerLastName(String lname)
	{
		customerLastName.sendKeys(lname);
	}
	public void enterPassword(String pas)
	{
		password.sendKeys(pas);
	}
	public void clickOnRegister() {
		register.click();
	}
}
