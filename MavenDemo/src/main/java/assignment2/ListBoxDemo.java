package assignment2;
 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//all values present in field
//validations
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListBoxDemo {
	@Test
	public void m1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://letskodeit.teachable.com/p/practice");
		
		driver.manage().window().maximize();
		WebElement e=driver.findElement(By.xpath("//*[@id='block-1069048']/div/div/div/div[1]/div[3]/fieldset/select"));
	//	Thread.sleep(300);
		//Select option Orange in ListBox
		Select select=new Select(e);
		select.selectByVisibleText("Orange");
		
		
		//Check whether correct options are seen in Listbox or not
		WebElement option = select.getFirstSelectedOption();
		String SelectedText = option.getText();
		System.out.println("Selected option:"+SelectedText);
		
	}
}