//3.Use below link:
//https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_table_test
//Identify td element showing Savings of month February,retrieve the savings value and print on console

package assignment2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_2 {
	static WebDriver driver;

	@Test
	public void m1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_table_test");

		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");

		int rownum = driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
		System.out.println("rows:" + rownum);
		int colnum = driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/th")).size();
		WebElement table = driver.findElement(By.xpath("/html/body/table"));
		List<WebElement> rowval = table.findElements(By.tagName("tr"));
		Thread.sleep(300);
		for (int i = 1; i < rownum; i++) {

			List<WebElement> colval = rowval.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < colnum; j++) {
				if (colval.get(j).getText().equalsIgnoreCase("February"))
					System.out.println("Saving=" + colval.get(j + 1).getText());

			}
		}

	}

}
