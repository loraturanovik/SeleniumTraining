package justmine;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WithScreenshots {

    public static String browser = "edge";
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
    	String formattedDate = formatter.format(new Date());
    	
        if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        
        driver.get("https://test.salesforce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("team.seavus@partner-prod.com.vlocitysbx");
        
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("seavusQA123!");

        driver.findElement(By.id("rememberUn")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("Login")).click();

        driver.get("https://seavus-testing-vlocity--vlocitysbx.sandbox.lightning.force.com/lightning/o/Account/list?filterName=__Recent");
        
        // Taking screenshot with a formatted date in the filename
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//scrfile//screenshot_" + formattedDate + ".png"));
  
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the element in the account list is visible and click it
        WebElement accountList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"brandBand_1\"]/div/div/div/div/div[1]/div[1]/div[2]/ul/li[1]/a/div")));
        accountList.click();

        // Wait for the checkbox to appear and click it
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div[1]/fieldset/div[1]/div[7]/label/div[1]/span")));
        checkbox.click();

        // Wait for the Next button to be clickable and click it
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Next']]")));
        nextButton.click();

        // Wait for the Name input field to be visible and enter account name
        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='slds-input' and @name='Name']")));
        name.sendKeys("Lora Account Automation");

        // Wait for the combobox button to be clickable and click it
        WebElement comboboxButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='combobox-button-136']")));
        comboboxButton.click();

        // Wait for the "Active" option to appear and click it
        WebElement desiredOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Active']")));
        desiredOption.click();

        // Wait for the Save button to be clickable and click it
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']")));
        saveButton.click();

        driver.quit();
    } 
}
