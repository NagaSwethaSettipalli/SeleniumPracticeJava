package com.SeleniumPractice.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MoneyControlCalculatorDataDrivenTest {
	
	public static String Testname = "MoneyControlTest";
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bommadi\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/test/java/com/SeleniumPractice/rough/MoneyControlCalculatorTestData.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		int rowcount = sh.getLastRowNum();
		System.out.println("Total no of rows :" + rowcount);

		for (int row = 1; row <= rowcount; row++)// we are doing row=1 bcoz 1st row has headers and we don't need
														// them
		{
			XSSFRow current_row = sh.getRow(row);
			XSSFCell principalCell = current_row.getCell(0);// returns cell object
			// we are taking the cell object and casting it to convert it in to integer
			// why we need to cast it to integer means if the excel sheet has numeric values
			// and when you read the data it will print with.00 in the end
			int pAmount = (int) principalCell.getNumericCellValue();
			// also instead of writing above 2 statements we can write in single statement as
			// int pAmount = (int)current_row.getCell(0).getNumericCellValue();
			XSSFCell roiCell = current_row.getCell(1);
			int roi = (int) roiCell.getNumericCellValue();
			XSSFCell periodCell = current_row.getCell(2);
			int period = (int) periodCell.getNumericCellValue();
			XSSFCell frequencyCell = current_row.getCell(3);
			String frequency = frequencyCell.getStringCellValue();
			XSSFCell maturityValueCell = current_row.getCell(4);
			double expectedmaturityValue = (double) maturityValueCell.getNumericCellValue();

			// Calculation process
			driver.findElement(By.name("principal")).sendKeys(String.valueOf(pAmount));// we do sendKeys(String.valueOf)
																						// for ending numeric values
			driver.findElement(By.name("interest")).sendKeys(String.valueOf(roi));
			driver.findElement(By.name("tenure")).sendKeys(String.valueOf(period));
			Select periodDropdown = new Select(driver.findElement(By.name("tenurePeriod")));
			periodDropdown.selectByVisibleText("year(s)");
			Select frequencyDropdown = new Select(driver.findElement(By.name("frequency")));
			frequencyDropdown.selectByVisibleText("Simple Interest");
			driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]/img")).click();
			// now we are going to store actual maturity value in a string variable because
			// by using getText() we are returning string value
			// why because expected maturity value is double and actual is string
			// so we have to get the string value from actual value and parse it to double
			// since most of the times the actual value returns decimal values
			// we convert to double by using double.parsedouble java conversion method
			String actualmaturityvalue = driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();

			if (Double.parseDouble(actualmaturityvalue) == expectedmaturityValue) {
				System.out.println("Test passed");
			} else {
				File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			     FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir") + "/Screenshots/" + Testname + ".png"));
								System.out.println("Test failed");
			}

			// now we need to clear all fields for the next execution

			driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img")).click();

		}
		driver.quit();
	}
	}
