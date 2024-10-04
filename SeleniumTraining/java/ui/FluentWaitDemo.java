package ui;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {

	public static void main(String[] args) throws IOException {
		
//		Date currentdate = new Date();
//		System.out.println(currentdate);
//		String screenshotfilenames = currentdate.toString().replace(" ", "-").replace(":", "-");
//		System.out.println(screenshotfilenames);

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
        WebElement element = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/a"));
        
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("This is a custom message");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a"))).click();
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//	    driver.findElement(By.xpath("//*[@id=\"s0-17-12_2-0-1[0]-0-0\"]/ul/li[2]/a")).click();
//	    
//	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	    FileUtils.copyFile(screenshotFile, new File(".//newfile//" + screenshotfilenames + ".png"));
	}
}
