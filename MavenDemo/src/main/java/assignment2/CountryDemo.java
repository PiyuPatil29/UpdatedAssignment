package assignment2;


	// 4.Use below link:
	// https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro
	// Identify td showing CompanyName from country UK,retrieve company name and
	// print it on console.
	// without index value
	// without loop

	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;
	public class CountryDemo {

	public static WebDriver driver;

	@Test
		public void m1() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro");
			driver.manage().window().maximize();
			driver.switchTo().frame("iframeResult");

			int rows = driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
			System.out.println("rows are:" + rows);

			int column = driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/th")).size();
			System.out.println("Columns are: " + column);

			WebElement table = driver.findElement(By.xpath("/html/body/table"));
			WebElement rowvalue = table.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[3]"));
			String rowText=rowvalue.getText();
			System.out.println("Rowtext is "+rowText);
			
			
			WebElement columnvalue=driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[1]"));
			String textComp=columnvalue.getText();
			System.out.println("Company name is "+textComp);
						}
				}
			

		
