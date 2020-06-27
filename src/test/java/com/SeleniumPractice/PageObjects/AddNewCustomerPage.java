package com.SeleniumPractice.PageObjects;


  
  import org.openqa.selenium.WebDriver; 
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.support.CacheLookup; import
  org.openqa.selenium.support.FindBy; import
  org.openqa.selenium.support.PageFactory;
  
  import com.SeleniumPractice.testCases.BaseClass;
  
  public class AddNewCustomerPage{
  
  WebDriver ldriver;
  
  public AddNewCustomerPage(WebDriver rdriver) { ldriver = rdriver;
  PageFactory.initElements(rdriver, this); }
  
  @FindBy(linkText ="New Customer")
  @CacheLookup
  WebElement AddCustomerLink;
  
  @FindBy(xpath ="/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
  @CacheLookup
  WebElement CustomerNameTxt;
  
  @FindBy(xpath ="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
  @CacheLookup WebElement 
  GenderMaleRadioBtn;
  
  @FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
  @CacheLookup 
  WebElement GenderFemaleRadioBtn;
  
  @FindBy(name ="dob")
  @CacheLookup 
  WebElement DateOfBirth;
  
  @FindBy(name ="addr")
  @CacheLookup
  WebElement AddressTxt;
  
  @FindBy(name ="city")
  @CacheLookup
  WebElement CityTxt;
  
  @FindBy(name ="state")
  @CacheLookup
  WebElement StateTxt;
  
  @FindBy(name ="pinno")
  @CacheLookup
  WebElement PINTxt;
  
  @FindBy(name ="telephoneno")
  @CacheLookup
  WebElement MobilenoTxt;
  
  @FindBy(name ="emailid")
  @CacheLookup
  WebElement EmailidTxt;
  
  @FindBy(name ="password")
  @CacheLookup
  WebElement PasswordTxt;
  
  @FindBy(name ="sub")
  @CacheLookup
  WebElement SubmitButton;
  
  @FindBy(name ="res")
  @CacheLookup
  WebElement ResetButton;
  
  //methods
  
  public void ClickAddNewCustomerLnk()
  {
	  AddCustomerLink.click();
  }
  public void EnterCustomerName(String custname)
  {
	  CustomerNameTxt.sendKeys(custname);
  }
  public void SelectGenderMale()
  {
	  GenderMaleRadioBtn.click();
  }
  public void SelectGenderFemale()
  {
	  GenderFemaleRadioBtn.click();
  }
  public void EnterDateOfBirth(String mm, String dd, String yy) // we need to enter month , date and year seperately
  {
	  DateOfBirth.sendKeys(mm); 
	  DateOfBirth.sendKeys(dd); 
	  DateOfBirth.sendKeys(yy); 
  }
  public void EnterAddress(String addr)
  {
	  AddressTxt.sendKeys(addr);
  }
  public void EnterCity(String cty)
  {
	  CityTxt.sendKeys(cty);
  }
  public void EnterState(String stat)
  {
	  StateTxt.sendKeys(stat);
  }
  public void EnterPIN(int pin)
  {
	  PINTxt.sendKeys(String.valueOf(pin));
  }
  public void EnterMobileno(String mno)
  {
	  MobilenoTxt.sendKeys(mno);
  }
  public void EnterEmail(String email)
  {
	  EmailidTxt.sendKeys(email);
  }
  public void EnterPassword(String pass)
  {
	  PasswordTxt.sendKeys(pass);
  }
  public void ClickSubmitbtn()
  {
	  SubmitButton.click();
  }
  public void ClickResetbtn()
  {
	  ResetButton.click();
  }
  
  }
 