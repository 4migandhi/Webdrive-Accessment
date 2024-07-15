//[1] Task 2 : Write script to take screenshot of filled form
package Assesment_Selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Form_Selenium_Task2 {
	
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
	public void test() throws InterruptedException, IOException{
		
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
		
		driver.findElement(By.id("dateOfBirthInput")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath
				("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[4]")).click();
		Thread.sleep(2000);
		
		// //*[@id=\"subjectsContainer\"]/div/div[1]
		/*driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")).sendKeys("Subject");
		Thread.sleep(2000);*/
		
		driver.findElement(By.xpath("//*[@id=\\\"subjectsContainer\\\"]/div/div[1]")).
										sendKeys("abcd");
		Thread.sleep(2000);
	
        WebElement Hobbies=driver.findElement(By.id("hobbies-checkbox-2"));
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Hobbies);
        Hobbies.click();
        
		Thread.sleep(2000);
		
		driver.findElement(By.id("uploadPicture")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("textarea.form-control")).sendKeys("Hello");
		//driver.findElement(By.id("currentAddress")).sendKeys("123");
		Thread.sleep(2000);
		
		WebElement e1= driver.findElement(By.name("country"));
		
		Select s1=new Select(e1);
		
		s1.selectByValue("NRC");
		Thread.sleep(2000);
		

		// to take screenshot
		File file=(File) ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		
		//copy ss to file
		
		Files.copy(file, new File("D:\\Automation_Testing\\ss"));
		
		driver.close();
	}

}
