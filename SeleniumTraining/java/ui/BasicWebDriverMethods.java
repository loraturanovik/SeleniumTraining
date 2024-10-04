package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicWebDriverMethods {
	
	public static String browser = "chrome";
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
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	
		driver.findElement(By.id("user-name")).sendKeys("standard_user"); 
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input")).click();
		
		List<WebElement> webelements = driver.findElements(By.xpath("//div[@class='inventory_list']/div"));
		System.out.println(webelements);
		
		driver.navigate().to("https://www.sugarcrm.com/");
		String windowhandle = driver.getWindowHandle();
		System.out.println(windowhandle);
		
//		driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div/a")).click();
//		Set<String> windowhandles = driver.getWindowHandles();
//		System.out.println(windowhandles);
		
		try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		driver.close();
	}
}
