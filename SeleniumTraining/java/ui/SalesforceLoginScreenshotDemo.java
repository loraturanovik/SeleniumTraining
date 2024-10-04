package ui;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceLoginScreenshotDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		Date currentdate = new Date();
		System.out.println(currentdate);
		
		String screenshotfilenames = currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotfilenames);
		
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		
		driver.get("https://test.salesforce.com/");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("team.seavus@partner-prod.com.vlocitysbx");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("seavusQA123!");
		
//		driver.findElement(By.id("rememberUn")).click();
//		Thread.sleep(1500);
		driver.findElement(By.id("Login")).click();
		
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scr, new File(".//newscreenshot//" + currentdate + ".png"));
	}
}
