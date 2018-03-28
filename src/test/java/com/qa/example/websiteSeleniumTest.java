package com.qa.example;

import org.apache.maven.shared.utils.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class websiteSeleniumTest {

	private static final String SeleniumTestingExcel = null;
	private static WebDriver driver;
	private static BufferedWriter writer;
	private static final String FILE_NAME = System.getProperty("user.dir") + "\\Usrnme_&_Password.xlsx";
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Admin\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void justEatSignIn() throws InterruptedException, IOException {
		// Optional, if not specified, WebDriver will search your path for chromedriver.
		try {
			
			XSSFWorkbook workbook = new XSSFWorkbook();
	        CreationHelper createHelper = workbook.getCreationHelper();
	        XSSFSheet sheet = workbook.createSheet("Username And Password");

			
           
	        
			driver.get("https://www.just-eat.co.uk/");
			driver.manage().window().fullscreen();
			
			Thread.sleep(3000); // Let the user actually see something!
			WebElement login = driver.findElement(By.className("login"));
			login.click();
			WebElement signUp = driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/p[1]/a"));
			signUp.click();
			Thread.sleep(3000);
			
			
			WebElement enterName = driver.findElement(By.name("Name"));
			enterName.sendKeys("Charlie Reilly");
			
			Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("Username: ");
            Cell cell1 = row.createCell(1);
            cell1.setCellValue("Charlie Reilly");
            
            
			WebElement enterEmail = driver.findElement(By.name("Email"));
			enterEmail.sendKeys("charlie.reilly@qa.com");
			
			Row row2 = sheet.createRow(1);
            Cell cell2a = row2.createCell(0);
            cell2a.setCellValue("Email: ");
            Cell cell2b = row2.createCell(1);
            cell2b.setCellValue("charlie.reilly@qa.com");
            
            
			WebElement password = driver.findElement(By.id("Password"));
			password.sendKeys("f6h7lc31!");
			
			Row row3 = sheet.createRow(2);
            Cell cell3a = row3.createCell(0);
            cell3a.setCellValue("Password: ");
            Cell cell3b = row3.createCell(1);
            cell3b.setCellValue("f6h7lc31!");
			
			Thread.sleep(3000);
			WebElement submit = driver.findElement(By.xpath("//*[@id=\"register\"]/div[2]/form/div[4]/input"));
//			submit.submit();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\Admin\\Desktop\\Week 7 Selenium Testing\\java-selenium-example\\screenshot.png"));
//			File file = new File("SeleniumTestingExcel.xlsx");
//	       
			
	        
	        FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
	            workbook.write(outputStream);
	            workbook.close();
		}catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

//	        System.out.println("Done");
	    
//
//	        writer = new BufferedWriter(new FileWriter(file));
//
//	        writer.write();

//			searchBox.submit();
//			WebElement chromeDriverLink = driver
//					.findElement(By.linkText("ChromeDriver - WebDriver for Chrome - Google Sites"));
//			chromeDriverLink.click();
//			Thread.sleep(5000); // Let the user actually see something!
			// here you could assert page title or some text or by page URL you're in the
			// correct place
		} 
	


	@After
	public void tearDown() {
		driver.quit();
	}

}