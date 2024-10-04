package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindingElements {
	
	public static String browser = "edge";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
		
		driver.get("https://www.sugarcrm.com/uk/request-demo/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("email")).sendKeys("turanoviklora@yahoo.com");
		
		WebElement down = driver.findElement(By.name("employees_c"));
		
		Select select = new Select(down);
		WebElement firstOption = select.getFirstSelectedOption();
		System.out.println(firstOption.getText());
		
		select.selectByValue("level1");
		Thread.sleep(2000);
		
		select.deselectByVisibleText("51 - 100 employees");
		Thread.sleep(2000);
		
		select.selectByIndex(5);

		try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		driver.close();
			
	
	}

}
