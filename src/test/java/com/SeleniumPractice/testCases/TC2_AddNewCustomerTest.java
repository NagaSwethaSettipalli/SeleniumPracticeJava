package com.SeleniumPractice.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SeleniumPractice.PageObjects.AddNewCustomerPage;
import com.SeleniumPractice.PageObjects.LoginPage;

public class TC2_AddNewCustomerTest extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.ClickOnLogin();
		
		Thread.sleep(3000); // don't put long time otherwise it will cause performance issues
		
		AddNewCustomerPage addcust = new AddNewCustomerPage(driver);
		addcust.ClickAddNewCustomerLnk();
		
		logger.info("Providing Customer details");
		addcust.EnterCustomerName("Tweety");
		logger.info("Entered Customer name");
		addcust.SelectGenderFemale();
		logger.info("Entered Customer gender");
		addcust.EnterDateOfBirth("09", "08", "1985");
		Thread.sleep(3000);
		logger.info("Entered Customer DOB");
		addcust.EnterAddress("2342 macstreet");
		logger.info("Entered Customer address");
		addcust.EnterCity("Hyderabad");
		logger.info("Entered Customer city");
		addcust.EnterState("AP");
		logger.info("Entered Customer state");
		addcust.EnterPIN(520032);
		logger.info("Entered Customer PIN");
		addcust.EnterMobileno("9234347484");
		logger.info("Entered Customer Mobileno");
		String email = generateRandomString()+"@gmail.com";
		addcust.EnterEmail(email);
		logger.info("Entered Customer email");
		addcust.EnterPassword("abcdef");
		logger.info("Entered Customer password");
		addcust.ClickSubmitbtn();
		logger.info("Clicked on submit button");
        
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			CaptureScreenshot(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}

	}

	//user defined method to generate random email id
	
	public String generateRandomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return(generatedString);
	}
}
