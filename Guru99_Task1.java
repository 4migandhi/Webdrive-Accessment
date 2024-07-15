/* Steps to get access to Test Site 

 * 1. Visit - http://demo.guru99.com/ 
 * 2. Enter your email id 
 * 3. Login credentials is allocated to you and mailed at your id
 * 
 * Task : 1  verify that test pass or fail
 * */
package Assesment_Selenium;

import static org.testng.Assert.fail;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Guru99_Task1 {
	WebDriver driver;
	
	@Test
	public void before() throws InterruptedException{

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://demo.guru99.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input"))
				.sendKeys("c@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input")).click();
		Thread.sleep(2000);
		
		if(driver.getCurrentUrl().equals("https://demo.guru99.com/access.php?uid=mngr576968%20&%20pass=ysYpAtY%20&%20email=c@gmail.com"))
		{
			System.out.println("Your Login Test Has been Passed...");
		}
		else
		{
			System.out.println("Your Login Test Hasbeen Failed...");
			fail("Login Failed");
		}
		
	}
}
