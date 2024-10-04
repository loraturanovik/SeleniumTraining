package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/slider/#colorpicker");
		driver.manage().window().maximize();
		
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);
		
		WebElement greenelement = driver.findElement(By.xpath("//*[@id=\"green\"]/span"));
		
		WebElement redelement = driver.findElement(By.xpath("//*[@id=\"red\"]/span"));
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(greenelement, -100, 125).perform();
		action.dragAndDropBy(redelement, -100, 125).perform();
		

	}

}
