package assignment1;

//3.Use link below:
//https://letskodeit.teachable.com/p/practice
//Type course name in the search field of Iframe given in Iframe example section

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_3 {

	@Test
	public void m1() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");
		WebElement Frame1 = driver.findElement(By.xpath("//iframe[@id='courses-iframe']"));
		driver.switchTo().frame(Frame1);

		WebElement ele = driver.findElement(By.cssSelector("#search-courses"));
		ele.sendKeys("Software Testing");

		System.out.println("Switch on frame" + ele.getText());
		
	}
}
