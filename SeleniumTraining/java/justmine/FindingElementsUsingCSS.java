package justmine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindingElementsUsingCSS {

	public static String browser = "edge";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
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
		
		driver.get("https://test.salesforce.com/");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("team.seavus@partner-prod.com.vlocitysbx");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("seavusQA123!");
		
		driver.findElement(By.id("rememberUn")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("Login")).click();
		

	}

}
