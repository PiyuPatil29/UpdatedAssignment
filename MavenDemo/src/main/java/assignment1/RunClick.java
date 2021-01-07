package assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RunClick {

	public static WebDriver driver;

	@Test
	public void m1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		
		Actions action=new Actions(driver);
		action.click(driver.findElement(By.xpath("//button[@class='w3-button w3-bar-item w3-green w3-hover-white w3-hover-text-green']")));
		action.build().perform();
		//driver.findElement(By.xpath("//button[@class='w3-button w3-bar-item w3-green w3-hover-white w3-hover-text-green']")).click();


	}
}