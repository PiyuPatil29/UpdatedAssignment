//2. Use below link
//https://letskodeit.teachable.com/p/practice
//Select option Orange in ListBox and check if option selected is indeed Orange or Not
//Check whether correct options are seen in Listbox or not
//use validation to check correct string passed option is selected
package assignment2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_1 {
	static WebDriver driver;

	@Test
	public void m1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/p/practice\r\n");
		driver.manage().window().maximize();
		WebElement e=driver.findElement(By.xpath("//*[@id=\"block-1069048\"]/div/div/div/div[1]/div[3]/fieldset/select"));
		Thread.sleep(3000);
		Select select=new Select(e);
		select.selectByVisibleText("Orange");
		
		//Check Wheather correct options are seen in Listbox or not 
		WebElement option=select.getFirstSelectedOption();
		String selectedText=option.getText();
		Assert.assertTrue(selectedText.contains("Orange"));
		System.out.println("Selected option is "+selectedText);
		}
}
