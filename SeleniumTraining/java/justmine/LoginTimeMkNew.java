package justmine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTimeMkNew {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://www.time.mk");
        driver.manage().window().maximize();
        
        Thread.sleep(5000); 
        
		driver.close();
		


	}

}
