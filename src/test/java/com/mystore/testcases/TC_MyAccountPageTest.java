package com.mystore.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.mystore.pageObject.accountCreationDetails;
import com.mystore.pageObject.indexPage;
import com.mystore.pageObject.myAccountPage;
import com.mystore.pageObject.registeredUserAccount;

public class TC_MyAccountPageTest extends BaseClass{
	//We have put @Test method her but we have kept @BeforeClass and @AfterClass in Base will which this class extends so they will run accordingly
	@Test(enabled = false)
	public void VerifyRegistrationAndLogin() {
		//opening url
		
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIN();
		logger.info("Clicked on sign in button");

		myAccountPage Myaccpg = new myAccountPage(driver);
		
		Myaccpg.enterCreateEmailAddress("123cs123@gmail.com");
		logger.info("email address entered in create account section");
		
		Myaccpg.clickSubmitCreate();
		logger.info("clicked on create an account button");		
		
		accountCreationDetails accCreationPg = new accountCreationDetails(driver);
		accCreationPg.selectTitleMr();
		accCreationPg.enterCustomerFirstName("Sunny");
		accCreationPg.enterCustomerLastName("gupta");
		accCreationPg.enterPassword("15368");
		logger.info("Entered user details");
		accCreationPg.clickOnRegister();
		logger.info("Clicked on register button");
		
		registeredUserAccount regUser= new registeredUserAccount(driver);
		String userName = regUser.getUserName();
		Assert.assertEquals(userName, "Sunny gupta");
	}
	@Test
	public void verifyLogin() {
		logger.info("VerifyLogin test case execution started....");
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIN();
		logger.info("Clicked on sign in button");

		myAccountPage Myaccpg = new myAccountPage(driver);
		Myaccpg.enterEmailAddress("123cs123@gmail.com");
		logger.info("entered email");
		Myaccpg.enterPassword("15368");
		logger.info("entered password");
		Myaccpg.clickSubmitCreate();
		logger.info("Clicked on submit button");
		registeredUserAccount regUser= new registeredUserAccount(driver);
		String userName = regUser.getUserName();
		if(userName.equals("Sunny gupt")) {
			logger.info("verify login - passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("verify login - failed");
			try {
				captureScreenShot(driver, "verifyLogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
		}
	}
}
