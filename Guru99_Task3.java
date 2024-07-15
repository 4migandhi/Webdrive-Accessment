//Take screenshot for Failed test cases
package Assesment_Selenium;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Guru99_Task3 {
	WebDriver driver;
	
	@Test
	public void before() throws InterruptedException, IOException{

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://demo.guru99.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input"))
				.sendKeys("c");
		Thread.sleep(2000);
		
		// to take screenshot
		File file=(File) ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
				
		//copy ss to file
				
		Files.copy(file, new File("C:\\Users\\gandh\\eclipse-workspace\\ss\\defact.png"));
		
	}		
}