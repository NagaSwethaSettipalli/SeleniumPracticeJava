package com.SeleniumPractice.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("C://Users//bommadi//Downloads//LoginData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheetAt(0);
		//For reading rows we should know how many rows are there and also we should know how many no of columns are there.. we use for loop to read all the row and the columns

		// for counting rows
		int rowcount = sh.getLastRowNum(); // it gives you the last row no ie; row count

		// for counting cells go to one row and count how many cells are thereby getting
		// last column number ie; getlastcellnum method
		int cellcount = sh.getRow(0).getLastCellNum(); // returns column count

		// now we have to read the values from excel sheet for that we have to use for
		// loop
		// first we need to jump to first row and read all cell values then we need to
		// jump to second row and read all cell values and then third row..
		// for incrementing rows we write one for loop and for each row to read all cell
		// values we write another for loop
		// in for loop 'i' represents rows
		for (int i = 0; i <= rowcount; i++) // for increasing row number
		{
			// first we need to focus on first row
			XSSFRow currentrow = sh.getRow(i); // focuses on current row what ever is the value of i it will focus on
												// that and keeps on increasing
			// here in for loop we have i=0 means we are focusing on first row
			// let us store this row in one variable .. we are storing entire row object in
			// that current row variable nd it will be row type variable

			// now we need to write one more for loop for reading all the cell values in tht
			// row
			for (int j = 0; j < cellcount; j++) {
				// now we need to read cell values available in that current row
				String value = currentrow.getCell(j).toString(); // for reading value in that cell we need to do
																	// tostring();.. reads value from cell
				// store this in a varaiable 'value' an then print that value
				System.out.print(" " + value);
			}
			System.out.println();// just do this for proper alignment of printing the data
		}

	}

}
