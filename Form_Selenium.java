// [1] Task 1 : Write script to fill this form using selenium webdriver.
package Assesment_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Form_Selenium {
WebDriver driver;
	
	@BeforeTest
	public void before() throws InterruptedException{

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test
	public void test() throws InterruptedException{
		
		driver.findElement(By.id("firstName")).sendKeys("charmi");
		Thread.sleep(2000);
		
		driver.findElement(By.id("lastName")).sendKeys("gandhi");
		Thread.sleep(2000);
		
		driver.findElement(By.id("userEmail")).sendKeys("c@gmail.com");
		Thread.sleep(2000);
		
		// // //tagname[text()='text_value']
		// //tagname[@attr_name='attr_value']
		driver.findElement(By.xpath("//label[@class='custom-control-label']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("userNumber")).sendKeys("1236547895");
		Thread.sleep(2000);
		
		driver.findElement(By.id("dateOfBirthInput")).sendKeys("25/11/1992");
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]")).click();
		//Thread.sleep(2000);
		
		driver.findElement(By.id("hobbies-checkbox-1")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("hobbies-checkbox-2")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("hobbies-checkbox-3")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("uploadPicture")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("currentAddress")).sendKeys("123");
		Thread.sleep(2000);
		
		WebElement e1= driver.findElement(By.name("country"));
		
		Select s1=new Select(e1);
		
		s1.selectByValue("NRC");
		Thread.sleep(2000);
		
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		
		driver.close();
	}
}