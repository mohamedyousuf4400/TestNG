package basicInTestNG;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipKartApp {

	WebDriver driver = new ChromeDriver();

	//******************  Launch FlipKart  *********************//
	@BeforeClass
	public void FlipKart() throws Exception {

		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	//********************  Enter Mail Id ********************//
	@Test(priority = 1)
	public void EnterMailid() throws Exception {

		WebElement mailId = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
		mailId.sendKeys("mohamedyousuf2000@gmail.com");
		Thread.sleep(2000);
	}

	//***********************  Enter Password  ***************************//
	@Test(priority = 2)
	public void EnterPassword() throws Exception {

		WebElement password = driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']"));
		password.sendKeys("Yousuf@4400");
		Thread.sleep(2000);
	}

	//*********************** Click Login Button  *************************//
	@Test(priority = 3)
	public void ClickLoginBtn() throws Exception {

		WebElement loginBtn = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']"));
		loginBtn.click();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void SearchTheProduct() throws Exception {

		WebElement searchProduct = driver.findElement(By.xpath("//input[@name='q']"));
		searchProduct.sendKeys("Smart watch"+Keys.ENTER);
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void ClickTheproduct() throws Exception {

		WebElement Product = driver.findElement
				(By.xpath("//div[text()='DIZO Watch 2 Smartwatch']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Product);
	    Actions actions = new Actions(driver);
	    actions.moveToElement(Product).click().build().perform();
		
	}

	@Test(priority = 6)
	public void addToCart() throws Exception {

		Set<String> handles = driver.getWindowHandles();

		for (String newWindow : handles) {

			driver.switchTo().window(newWindow);

		}

		WebElement addinCart = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", addinCart);
		addinCart.click();
		Thread.sleep(2000);

	}


							//***************************  Take Screenshot *************************//
	@Test(priority = 7)
	public void screenShot() throws Exception   {

		TakesScreenshot screenshot = ((TakesScreenshot )driver);
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("C:\\Users\\lenovo\\Pictures\\AmazonCart2.png");
		FileHandler.copy(sourceFile,destinationFile);

	}

							//************************ Verify the product in the cart  ************************//
	@Test(priority = 8)
	public void verify() {

		WebElement SmartTV = driver.findElement
				(By.xpath("//a[text()='DIZO Watch 2 Smartwatch']"));
		if (SmartTV.isDisplayed()) {
			System.out.println("Product is added to cart");
		}

	}
	
							//************************  Close Browser  *************************//
	@AfterClass
	public void Close() {

		driver.quit();
	}
}
