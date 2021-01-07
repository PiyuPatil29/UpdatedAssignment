package com.keywords;
	

	import java.awt.AWTException;
	import java.awt.Rectangle;
	import java.awt.Robot;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.Iterator;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import javax.imageio.ImageIO;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.interactions.Action;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import com.google.gson.JsonArray;
	import com.google.gson.JsonObject;
	import com.google.gson.JsonParser;

	import io.github.bonigarcia.wdm.WebDriverManager;
	import ru.yandex.qatools.ashot.AShot;
	import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

	public class Keyword {
		public static void openBrowser(String browserName) {
	     ChromeOptionsTo.addInChrome();
			switch (browserName) {
			case "Chrome":
				System.out.println("Opening Chrome Browser");
				WebDriverManager.chromedriver().setup();
				Constants.driver = new ChromeDriver();
				break;
			case "Firefox":
				System.out.println("Openeing Firefox Driver");
				WebDriverManager.firefoxdriver().setup();
				Constants.driver = new FirefoxDriver();
				break;
			case "IE":
				System.out.println("Opening Internet Explorer");
				WebDriverManager.iedriver().setup();
				Constants.driver = new InternetExplorerDriver();
			case "Safari":
			default:
				System.out.println("Invalid BrowserName " + browserName);
				break;
			}
		}

		/**
		 * It open specified Url in WebBrowser recently opened by driver instance
		 * {@code String} Url to open
		 * 
		 * @return void
		 */

	//========================================================================//	
		// To verifyText is present or not

		public static boolean verifyText(String value) {
			return Constants.driver.getPageSource().contains(value);
		}

		// ====================================================================//

		// refresh page
		public static void refreshPage() {
			Constants.driver.navigate().refresh();
		}

		// ==========================================================//

		public static void openURL(String url) {
			Constants.driver.get(url);
		}

	//==============================================================///
		public static WebElement getWebElement(String locatortype, String locatorvalue) {
			WebElement element = null;
			switch (locatortype) {
			case "XPATH":
				element = Constants.driver.findElement(By.xpath(locatorvalue));
				break;
			case "CSS":
				element = Constants.driver.findElement(By.cssSelector(locatorvalue));
				break;
			case "ID":
				element = Constants.driver.findElement(By.id(locatorvalue));
				break;
			case "LINKTEXT":
				element = Constants.driver.findElement(By.linkText(locatorvalue));
				break;
			case "PARTIAL_LINKTEXT":
				element = Constants.driver.findElement(By.partialLinkText(locatorvalue));
				break;
			case "CLASS_NAME":
				element = Constants.driver.findElement(By.className(locatorvalue));
				break;
			case "NAME":
				element = Constants.driver.findElement(By.name(locatorvalue));
			default:
				System.err.println("Invalid locator type " + locatortype
						+ ("Expected CSS,XPATH,PARTIAL_LINKTEXT,LINKTEXT,CLASS_NAME,ID"));
				break;
			}
			return element;
		}

	//==============================================================//
		// This method entertext
		public static void enterText(String locatortype, String locatorvalue, String textToEnter) {
			Constants.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			getWebElement(locatortype, locatorvalue).sendKeys(textToEnter);
		}

	//=============================================================//
		// click method to click particular element
		public static void clickonElement(String locatortype, String locatorvalue) {
			getWebElement(locatortype, locatorvalue).click();
		}
		//============================================================//
		public static void hoverMouseonWebelement() {
			Actions action=new Actions(Constants.driver);
			//Add Books
			action.moveToElement(Constants.driver.findElement(By.xpath("//span[@class='cat-item-text']/parent::a[@id='cat-link-18970']")));
			action.perform();
			
		}


	//=============================================================//
		public static String getTitleofPage() {
			String Actualtitle = Constants.driver.getTitle();
			return Actualtitle;
		}
		//=============================================================//
		public static void windowHandles() {
			String parentWindow=Constants.driver.getWindowHandle();
			Set<String>s=Constants.driver.getWindowHandles();
			Iterator<String> itr=s.iterator();
			while(itr.hasNext()) {
				String childwindow=itr.next();
				if(parentWindow.equals(childwindow)) {
					Constants.driver.switchTo().window(childwindow);
					Constants.driver.findElement(By.xpath("//*[@id='ip2EmailOverlay']/button/img")).click();

				}
			}
		}
		

		// =============================================================//
		// select from dropdown list
		public static void selectValueFromDropDown(String locatortype, String locatorvalue, String textToSelect) {
			Constants.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element = getWebElement(locatortype, locatorvalue);
			Select select = new Select(element);
			select.selectByVisibleText(textToSelect);
		}

	//=============================================================//
		// scroll page up and down
		public static void upScrollBar() {
			JavascriptExecutor js = (JavascriptExecutor) Constants.driver;
			js.executeScript("window.scrollBy(0,-250)");

		}

		public static void downScrollBar() {
			JavascriptExecutor js = (JavascriptExecutor) Constants.driver;
			js.executeScript("window.scrollBy(0,800)", "");
			// js.executeAsyncScript("window.scrollBy(0,-800)", "");
		}

		// ==================================================================//
	// window handling code

		public static void switchToparentwindow() {
			String mainwindow = Constants.driver.getWindowHandle();
			Set<String> set = Constants.driver.getWindowHandles();
			Iterator<String> itr = set.iterator();
			while (itr.hasNext()) {
				String childwindow = itr.next();
				if (!mainwindow.equals(childwindow)) {
					Constants.driver.switchTo().window(childwindow);
					System.out.println(Constants.driver.switchTo().window(childwindow).getTitle());
				}
			}
		}

	//============================================================//
		public static void applyWait() throws InterruptedException {
			Thread.sleep(3000);
		}
	//===================================================//
		// Takes screenshot

		public static void takeScreenshot() throws IOException {
			TakesScreenshot ts = (TakesScreenshot) Constants.driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,
					new File("C:\\Users\\Hp\\eclipse-workspace\\Scratch\\Fullpagescreenshots\\UsingRobotClass.png"));

		}

		// ==============================================================//

		public static boolean ifAlert() {
			try {
				Constants.driver.switchTo().alert().accept();
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		// ===========================================================//
		// Screenshot using Ashot
		public static void screenShotbymethod() {
			AShot ashot = new AShot();
			BufferedImage image = ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000))
					.takeScreenshot(Constants.driver).getImage();
			try {
				ImageIO.write(image, "JPG",
						new File("C:\\Users\\Hp\\eclipse-workspace\\Scratch\\Fullpagescreenshots\\UsingAshot.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// =====================================================//
		// wait
		public static void applyWaits() {
			Constants.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		}

		// ====================================================================//
		public static void performAction(String locatortype, String locatorvalue) {
			Actions action = new Actions(Constants.driver);
			WebElement element1 = getWebElement(locatortype, locatorvalue);
			action.moveToElement(element1).perform();

		}

		// =================================================================//
		// Robot method
		public void usingAction() throws AWTException, IOException {
			Robot robo = new Robot();
			Rectangle rect = new Rectangle();
			rect.setBounds(0, 0, 1200, 1000);
			BufferedImage img = robo.createScreenCapture(rect);
			ImageIO.write(img, "PNG", new File("/Scratch/Screenshots.png"));
		}

	// =============================================================//
		// to maximize browser
		public static void maximizeBrowser() {
			Constants.driver.manage().window().maximize();
		}

	//===========================================================//
		public static void returnHomepage() {
			JavascriptExecutor js = (JavascriptExecutor) Constants.driver;
			js.executeScript("window.history.go(-1)");
			System.out.println("Amazon Homepage");

		}

		// ==============================================================//
		// code to read.jsonfile
		public static void readJsonfile() {
			JsonParser parser = new JsonParser();
			FileReader reader;
			try {
				reader = new FileReader("ExpectedHelptopics.json");
				Object obj = parser.parse(reader);
				JsonArray usersList = (JsonArray) obj;
				System.out.println(usersList);
				for (int i = 0; i < usersList.size(); i++) {
					JsonObject users = (JsonObject) usersList.get(i);
					System.out.println(users);
				}
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		//=========================================================//
		public static void performKeyaction() {
			Actions action=new Actions(Constants.driver);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			action.keyDown(Keys.CONTROL).sendKeys("//*[@id=\"hmenu-content\"]/ul[1]/li[10]/a").keyDown(Keys.CONTROL).perform();
		}

		// ====================================================================//
		// To close open browser
		public static void closeBrowser() {
			Constants.driver.close();
		}

	//=============================================================//
		public static void closeAllbrowser() {
			Constants.driver.quit();
		}

	}





