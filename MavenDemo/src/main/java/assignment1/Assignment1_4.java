package assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1_4 {
	static WebDriver driver;

	@Test
	public void m1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_disabled");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
	    WebElement element=driver.findElement(By.xpath("/html/body/button"));
	  System.out.println(element.getText());
		
	
	
	}
		
	}

