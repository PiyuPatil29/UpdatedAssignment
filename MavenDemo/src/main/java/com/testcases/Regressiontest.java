package com.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.keywords.Keyword;
import com.utils.Propertiesfile;
import com.utils.Utils;

public class Regressiontest {
	@Test(priority = 1)
	public void TC_01() {
		Keyword.openBrowser(Propertiesfile.getProperty("browsername"));
	}

	@Test(priority = 2)
	public void TC_02() {
		Keyword.openURL(Propertiesfile.getProperty("baseURL"));
		Keyword.windowHandles();
		Keyword.maximizeBrowser();
		Assert.assertEquals(Propertiesfile.getProperty("baseURL"), "https://www.shutterfly.com/");

	}

	@Test(priority = 3)
	public void TC_03() throws IOException, InterruptedException {
	     Keyword.clickonElement(Propertiesfile.getLocator("Signin_click")[0],Propertiesfile.getLocator("Signin_click")[1]);
	// 	Constant.driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
	   Keyword.selectValueFromDropDown(Propertiesfile.getLocator("dropSign_In")[0], Propertiesfile.getLocator("dropSign_In")[1],"Sign In");

	}

}
