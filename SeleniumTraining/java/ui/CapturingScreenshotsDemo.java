package ui;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CapturingScreenshotsDemo {

	public static void main(String[] args) throws IOException {
		
		Date currentdate = new Date();
		String screenshotfilenames = currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotfilenames);
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com/");
	//  driver.manage().window().maximize();
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + currentdate + ".png"));

	}

}
