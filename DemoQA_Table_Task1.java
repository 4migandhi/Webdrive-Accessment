//  Write a script to click on Edit button for given name
package Assesment_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQA_Table_Task1 {
	WebDriver driver;	

	@Test
	public void before() throws InterruptedException{

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//  //tagname[@attr_name='attr_value']
		// tag Name.class value
		//driver.findElement(By.cssSelector("span.mr-2")).click();
		WebElement edit=driver.findElement(By.xpath("//span[@title='Edit']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", edit);
		Thread.sleep(2000);
		edit.click();
		Thread.sleep(2000);
		
	}
}
