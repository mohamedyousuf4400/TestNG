package basicInTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestSuite {

	WebDriver driver;

	@BeforeSuite
	public void LaunchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Long StartTime =System.currentTimeMillis();
		System.out.println("Start Time In Milliseconds"+StartTime);

	}

	//Open Google
	@Test
	public void OpenGoogle() {
		driver.get("https://google.com");
	}

	//Open Gmail
	@Test
	public void OpenGmail() {
		driver.get("https://accounts.google.com");
	}

	//Open Youtube
	@Test
	public void OpenYoutube() {
		driver.get("https://youtube.com");
	}

	@AfterSuite
	public void CloseBrowser() {
		driver.quit();
		Long EndTime = System.currentTimeMillis();
		System.out.println("End Time in Milliseconds"+EndTime);

	}
}
