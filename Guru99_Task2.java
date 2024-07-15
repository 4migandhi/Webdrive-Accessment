//Parameterised your script using testing and take input from excel sheet
package Assesment_Selenium;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Guru99_Task2 {
	@DataProvider(name = "charmi")
	public Object[][] readData() throws InvalidFormatException, IOException {
		Object[][] data = null;
		
		//1. to give file path
		String filepath = "D:\\Automation_Testing\\selenium\\file.xlsx";
		
		//2. to make file
		File file = new File(filepath);
		
		//3. to open excle file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//4. to open sheet
		Sheet sheet=workbook.getSheet("Sheet2");
		
		//5. to get row
		int nrow=sheet.getPhysicalNumberOfRows();
		
		System.out.println("no of rows is" + nrow);
		
		data=new Object[nrow][];
		
		for (int i = 0; i < data.length; i++) {
			
			//6. to select particular row
			Row row= sheet.getRow(i);
			
			//7. to get col
			
			int ncell = row.getPhysicalNumberOfCells();
			System.out.println("No of col is :"+ncell);
			
			data[i]=new Object[ncell];
			
			for (int j = 0; j < data[i].length; j++) {
				
				//8. to select a particular cell
				Cell cell=row.getCell(j);
				
				//9.to set all value of string
				
				cell.setCellType(CellType.STRING);
				
				//10.to get cell value
				
				data[i][j] = cell.getStringCellValue();				
			}
			
		}		
	
		return data;
	}
	
	WebDriver driver;
	
	@Test(dataProvider = "charmi")
	public void test(String keyword) throws 
				InterruptedException, InvalidFormatException, IOException {
		
		WebDriverManager.edgedriver().setup();
		//driver = new EdgeDriver();
		if(keyword.equals("open browser")) {
			driver = new EdgeDriver();
			
		}else if (keyword.equals("enter url")) {
		driver.get("https://demo.guru99.com/");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}else if (keyword.equalsIgnoreCase("Email ID")){
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input"))
				.sendKeys("c@gmail.com");
		Thread.sleep(2000);
	}
	}
}	