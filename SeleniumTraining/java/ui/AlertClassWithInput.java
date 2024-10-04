package ui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertClassWithInput {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("/html/body/button")).click();
		Thread.sleep(2000);
		
		Alert alertonpage = driver.switchTo().alert();
		alertonpage.sendKeys("RCV Academy");
		alertonpage.accept();

		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
		
		Thread.sleep(1000);
		driver.quit();
		

	}

}
