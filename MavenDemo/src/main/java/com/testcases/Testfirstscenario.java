package com.testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testfirstscenario {
	@Test
	public void TC_01() {
		WebDriverManager.chromedriver().setup();
    	RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://www.shutterfly.com/");
		
		String parentwindow=driver.getWindowHandle();
	   Set<String>s=	driver.getWindowHandles();
	   Iterator<String> itr=s.iterator();
	   while(itr.hasNext()) {
		  String childwindow=itr.next();
		  if(parentwindow.equals(childwindow)) {
			  driver.switchTo().window(childwindow);
			  driver.findElement(By.xpath("//*[@id=\"ip2EmailOverlay\"]/button/img")).click();
			  driver.manage().window().maximize();
		  }	   
	   }
	   driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
	   driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]")).click();
	//	Actions action=new Actions(driver);
		//action.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/main/div[6]/div/div/button/img"))).click();
	//	action.perform();
		driver.findElement(By.cssSelector("#email")).sendKeys("piyupatil5029@gmail.com");
		driver.findElement(By.cssSelector("#password")).sendKeys("nishikant.patil");
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
	}

}
