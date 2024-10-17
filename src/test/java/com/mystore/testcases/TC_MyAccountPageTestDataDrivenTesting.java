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
import com.mystore.utilities.ReadExcelFile;

public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass{
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
	@Test(dataProvider="LoginDataProvider")
	public void verifyLogin(String userEmail, String userPwd , String expectedUsername) {
		logger.info("VerifyLogin test case execution started....");
		indexPage pg = new indexPage(driver);
		pg.clickOnSignIN();
		logger.info("Clicked on sign in button");

		myAccountPage Myaccpg = new myAccountPage(driver);
		Myaccpg.enterEmailAddress(userEmail);
		System.out.println(userEmail);
		logger.info("entered email");
		Myaccpg.enterPassword(userPwd);
		logger.info("entered password");
		Myaccpg.clickSubmitCreate();
		logger.info("Clicked on submit button");
		registeredUserAccount regUser= new registeredUserAccount(driver);
		String userName = regUser.getUserName();
		System.out.println("user name is: "+userName);
		System.out.println("Expected user name is "+expectedUsername);
		if(userName.equals(expectedUsername)) {
			logger.info("verify login - passed");
			Assert.assertTrue(true);
			regUser.clickOnSignOut();
			
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
	
	//this method will fetch data from ReadExcellfile and return tha data to verifyLogin method
		@DataProvider(name = "LoginDataProvider")
		public String[][] LoginDataProvider()
		{
			//System.out.println(System.getProperty("user.dir"));
			String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";

			//ReadExcelFile is a static method so no need to create it's object
			int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
			int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");		

			//ttlRows-1 because first row is header row
			String data[][]=new String[ttlRows-1][ttlColumns];

			for(int i=1;i<ttlRows;i++)//rows =1,2
			{
				for(int j=0;j<ttlColumns;j++)//col=0, 1,2
				{

					data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
				}

			}
			return data;
	}
}
