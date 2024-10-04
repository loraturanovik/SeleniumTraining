package justmine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTimeMk {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://www.time.mk");
            driver.manage().window().maximize();

            Thread.sleep(5000); 
            
        } catch (InterruptedException e) {
            e.printStackTrace();
            
        } finally {
            driver.quit();
        }
	}
}
