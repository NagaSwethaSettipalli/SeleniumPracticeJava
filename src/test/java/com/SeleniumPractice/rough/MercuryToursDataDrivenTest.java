package com.SeleniumPractice.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MercuryToursDataDrivenTest {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bommadi\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.get("http://newtours.demoaut.com/");

		// reading data from excel

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/java/com/SeleniumPractice/rough/MercuryToursRegistrationTestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		int rowcount = sh.getLastRowNum();
		System.out.println("Number of rows in Excel sheet :" + rowcount);
		for (int row = 1; row <= rowcount; row++) {
			XSSFRow current_row = sh.getRow(row);

			//without creating cell objects we are reading the cells data directly from rows
			//row.getCell(0 - returns cell object not the cell value again we have todo getStringCell value for getting the cell value)
			String FirstName = current_row.getCell(0).getStringCellValue(); 
			String Lastname = current_row.getCell(1).getStringCellValue();
			int Phone = (int)current_row.getCell(2).getNumericCellValue();
			String Email = current_row.getCell(3).getStringCellValue();
			String Address = current_row.getCell(4).getStringCellValue();
			String City = current_row.getCell(5).getStringCellValue();
			String State = current_row.getCell(6).getStringCellValue();
			int PostalCode = (int)current_row.getCell(7).getNumericCellValue();
			String Country = current_row.getCell(8).getStringCellValue();
			String Username = current_row.getCell(9).getStringCellValue();
			String Password = current_row.getCell(10).getStringCellValue();

			// Registration process

			driver.findElement(By.linkText("REGISTER")).click();

			// Entering Contact Information

			driver.findElement(By.name("firstName")).sendKeys(FirstName);
			driver.findElement(By.name("lastName")).sendKeys(Lastname);
			driver.findElement(By.name("phone")).sendKeys(String.valueOf(Phone));
			driver.findElement(By.name("userName")).sendKeys(Email);

			// Entering Mailing Information

			driver.findElement(By.name("address1")).sendKeys(Address);
			driver.findElement(By.name("city")).sendKeys(City);
			driver.findElement(By.name("state")).sendKeys(State);
			driver.findElement(By.name("postalCode")).sendKeys(String.valueOf(PostalCode));

			Select countrydropdown = new Select(driver.findElement(By.name("country")));
			countrydropdown.selectByVisibleText(Country);

			// Entering user informaton

			driver.findElement(By.name("email")).sendKeys(Username);
			driver.findElement(By.name("password")).sendKeys(Password);
			driver.findElement(By.name("confirmPassword")).sendKeys(Password);

			// submitting form
			driver.findElement(By.name("register")).click();

			if (driver.getPageSource().contains("Thank you for registering")) {
				System.out.println("Registration completed for " + row + "record");
			} else {
				System.out.println("Registration filed for " + row + "record");
			}

		}

		System.out.println("Data driven test completed");
	}

}
