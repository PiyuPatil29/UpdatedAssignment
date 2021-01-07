package assignment1;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;

//Use https://letskodeit.teachable.com/p/practice

//1.Enter name in "Enter Your Name" field.Click on Confirm button.Check value entered in the field indeed exists in the messaage
//shown by confirmation window.Close confirmation window by clicking on No button

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_1 {
	public static WebDriver driver;

	@Test
	public void m1() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://letskodeit.teachable.com/p/practice\r\n" + "");

		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Priyanka");

		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();

		Assert.assertTrue(text.contains("Priyanka"));
		System.out.println("Text contains  " + text);
		alert.accept();
		driver.close();

	}

}
