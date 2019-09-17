import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class automation {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeSuite
	public void Setup() {
		System.out.println("Setting up the data");

		System.setProperty("webdriver.chrome.driver", "E:\\jars\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		// Implicite Wait.
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 15);
	}

	@Test
	public void testLogin() throws Exception {
		System.out.println("Trying to open link");
		driver.get("https://www.google.com");

		@SuppressWarnings("unused")
		WebElement Logo, searchBox, searchButtonn;

		Logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hplogo")));

		searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/div[2]/div[1]/div[1]/div/div[2]/input"));

		searchBox.sendKeys("Rsk-Bsl");

		searchButtonn = driver
				.findElement(By.xpath("/html/body/div[1]/div[4]/form/div[2]/div[1]/div[3]/center/input[1]"));

		// Automating Enter Key Functionality.
		searchButtonn.sendKeys(Keys.RETURN);

		System.out.println("Logo found");

		Thread.sleep(3000);
	}

	@AfterSuite
	public void tearDown() {
		System.out.println("Quiting Chrome");
		driver.quit();
	}
}
