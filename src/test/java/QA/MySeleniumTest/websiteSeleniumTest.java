import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class websiteSeleniumTest {

	private static WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); //this instantiates the webdriver allowing Selenium to access Chrome.
	}
	
	@Test
	public void testJustEatSignUp() {
		driver.get("https://www.just-eat.co.uk/");
		driver.click("login");
		driver.click("o-link");
		WebElement searchBox = driver.findElement(By.Id("Name"));
		searchBox.sendKeys("David Malaq");
		WebElement searchBox = driver.findElement(By.Id("Email"));
		searchBox.sendKeys("david.malaq@hello.com");
	}
	
}