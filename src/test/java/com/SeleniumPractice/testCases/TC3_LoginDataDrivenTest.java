package com.SeleniumPractice.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SeleniumPractice.PageObjects.LoginPage;
import com.SeleniumPractice.utilities.XLUtils;

public class TC3_LoginDataDrivenTest extends BaseClass
{
@Test(dataProvider="LoginData")
public void loginDDT(String uname, String pwd) throws InterruptedException
{
	LoginPage lp = new LoginPage(driver);
	lp.setUserName(uname);
	logger.info("user name provided");
	lp.setPassword(pwd);
	logger.info("password provided");
	lp.ClickOnLogin();
	
	Thread.sleep(3000);
	
	if(isAlertPresent() == true)
	{
		driver.switchTo().alert().accept(); // to close alert window
		driver.switchTo().defaultContent(); // switch to main window
		Assert.assertTrue(false);
		logger.info("Login failed");
	}
	else
	{
	    Assert.assertTrue(true);
	    logger.info("Login passed");
	    lp.ClickOnLogout();
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept(); // close logout alert
	    driver.switchTo().defaultContent();
	}
}

//User Defined method to check if alert is present on the webpage

public boolean isAlertPresent()
{
	try 
	{
		driver.switchTo().alert();
		return true;
	}
	catch(NoAlertPresentException e)
	{
		return false;
	}
}

// Data Provider method

@DataProvider(name="LoginData")
   String [][] getData() throws IOException
   {
	String path = System.getProperty("user.dir")+"/src/test/java/com/SeleniumPractice/testData/LoginData.xlsx";
	
	int rowCount = XLUtils.getRowCount(path,"Sheet1");
	int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
	
	String logindata[][] = new String[rowCount][colCount];
	
	for(int i=1; i<=rowCount; i++)
	{
		for(int j=0; j<colCount; j++)
		{
			logindata[i-1][j] = XLUtils.getCellData(path,"Sheet1", i, j); //1 0
		}
	}
	
	return logindata;
	
   }



}
