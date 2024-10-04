package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	public static String browser = "edge";
	public static WebDriver driver;

	public static void main(String[] args) {
		if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		WebElement password = driver.findElement(By.id("password"));
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(password)).sendKeys("standard_user");
		
		WebElement username = driver.findElement(By.id("user-name"));
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(username)).sendKeys("secret_sauce");
		
//		driver.findElement(By.id("user-name")).sendKeys("standard_user"); 
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input")).click();
		
		driver.findElement(By.id("login-button")).click();
		
		try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		driver.close();
	}
}
