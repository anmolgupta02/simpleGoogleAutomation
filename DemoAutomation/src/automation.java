import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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
	
		//GitTutorialDemo
		
		
		System.out.println("Setting up the data");

		System.setProperty("webdriver.chrome.driver", "E:\\jars\\chromedriver.exe");
		

		new DesiredCapabilities();
		DesiredCapabilities sslCapablities = DesiredCapabilities.chrome();
		sslCapablities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		driver = new ChromeDriver(sslCapablities);

		driver.manage().window().maximize();
		// Implicite Wait.
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 15);
		
			
		
	}

	@Test
	public void googleSearch() throws Exception {
		System.out.println("Trying to open link");
		driver.get("https://www.google.com");

		@SuppressWarnings("unused")
		WebElement Logo, searchBox, searchButtonn, resultLink;

		Logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hplogo")));

		searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[4]/form/div[2]/div[1]/div[1]/div/div[2]/input"));

		searchBox.sendKeys("Rsk-Bsl");
		
		searchButtonn = driver
				.findElement(By.xpath("/html/body/div[1]/div[4]/form/div[2]/div[1]/div[3]/center/input[1]"));

		// Automating Enter Key Functionality.
		searchButtonn.sendKeys(Keys.RETURN);
		Thread.sleep(5000);
		//Clicking on the first link 
		resultLink = driver.findElement(By.xpath("//*[contains(text(),'Offshore Outsourcing Software Development Company | RSK ...')]"));
		resultLink.click();
		
		System.out.println("Logo found");

		Thread.sleep(3000);
	}
	

	@AfterMethod
	@AfterSuite
	public void tearDown() {
		System.out.println("Quiting Chrome");
		driver.quit();
		
	}
}
