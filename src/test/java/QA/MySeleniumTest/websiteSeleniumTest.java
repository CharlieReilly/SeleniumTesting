package com.qa.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class websiteSeleniumTest {

	private static final String SeleniumTestingExcel = null;
	private static WebDriver driver;
	private static BufferedWriter writer;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Charlie\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void justEatSignIn() throws InterruptedException {
		// Optional, if not specified, WebDriver will search your path for chromedriver.
		try {
			driver.get("https://www.just-eat.co.uk/");
			driver.manage().window().fullscreen();
			
			Thread.sleep(5000); // Let the user actually see something!
			WebElement login = driver.findElement(By.className("login"));
			login.click();
			WebElement signUp = driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/p[1]/a"));
			signUp.click();
			Thread.sleep(5000);
			WebElement enterName = driver.findElement(By.name("Name"));
			enterName.sendKeys("Charlie Reilly");
			WebElement enterEmail = driver.findElement(By.name("Email"));
			enterEmail.sendKeys("charlie.reilly@qa.com");
			Thread.sleep(3000);
			
			File file = new File("SeleniumTestingExcel.xlsx");
	       

	        writer = new BufferedWriter(new FileWriter(file));

	        writer.write();

//			searchBox.submit();
//			WebElement chromeDriverLink = driver
//					.findElement(By.linkText("ChromeDriver - WebDriver for Chrome - Google Sites"));
//			chromeDriverLink.click();
//			Thread.sleep(5000); // Let the user actually see something!
			// here you could assert page title or some text or by page URL you're in the
			// correct place
		} finally {
		}
	}

	private void setCellData(String string, int i, String string2) {
		// TODO Auto-generated method stub
		
	}

	private void setExcelFile(String seleniumtestingexcel2, int i) {
		// TODO Auto-generated method stub
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
