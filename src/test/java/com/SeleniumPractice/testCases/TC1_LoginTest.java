package com.SeleniumPractice.testCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.SeleniumPractice.PageObjects.LoginPage;

public class TC1_LoginTest extends BaseClass
{
	public WebDriverWait wait;
	@Test
	public void LoginTest() throws InterruptedException, IOException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.ClickOnLogin();
		logger.info("Clicked on submit button");
		Thread.sleep(3000);
		//Assert.assertTrue(driver.getTitle().equals( "Guru99 Bank Manager HomePage" ), "Incorrect page displayed");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			CaptureScreenshot(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}

}
