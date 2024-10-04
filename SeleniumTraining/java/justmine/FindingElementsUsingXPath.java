package justmine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindingElementsUsingXPath {

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
		
		driver.get("https://seavus-testing-vlocity--vlocitysbx.sandbox.lightning.force.com/lightning/o/Account/list?filterName=__Recent");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"brandBand_1\"]/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section/div/div/section/div/div[2]/div/div/div/div[1]/div/div/div/div/div/div/fieldset/div/label[4]/span[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.//span[text()='Next']]")).click();
		
		Thread.sleep(2000);
		WebElement name = driver.findElement(By.xpath("//input[@class='slds-input' and @name='Name']"));
		name.sendKeys("Lora Account");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
}
