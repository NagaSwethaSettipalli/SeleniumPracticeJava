package com.SeleniumPractice.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	  WebDriver ldriver;
	  
	  public LoginPage(WebDriver rdriver)
	  {
		  ldriver = rdriver;
	      PageFactory.initElements(rdriver, this); 
	  }
	  
	  @FindBy(name ="uid")
	  @CacheLookup
	  WebElement userIDTxt;
	  
	  @FindBy(name ="password")
	  @CacheLookup
	  WebElement passwordTxt;
	  
	  @FindBy(name ="btnLogin")
	  @CacheLookup
	  WebElement loginButton;
	  
	  @FindBy(name ="btnReset")
	  @CacheLookup
	  WebElement resetButton ;
	  
	  @FindBy(linkText ="Log out")
	  @CacheLookup
	  WebElement logoutButton ;
	   
	  //action methods
	  
	  public void setUserName(String uname)
	  {
		  userIDTxt.sendKeys(uname);
	  }
	  public void setPassword(String pwd)
	  {
		  passwordTxt.sendKeys(pwd);
	  }
	  public void ClickOnLogin()
	  {
		  loginButton.click();
	  }
	  public void ClickOnLogout()
	  {
		  logoutButton.click();
	  }
	  

}
