package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ApiGoldPrice;
import pages.bankier;

public class TC_1 {

	String driverPath = "C://Work/Drivers/chromedriver.exe";
	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(priority = 0)
	public void CompareGoldPrices() {

		bankier bankierPage = new bankier(driver);
		ApiGoldPrice apiGoldPage = new ApiGoldPrice(driver);
		//Assertion with tolerance of 200 USD
		Assert.assertEquals(bankierPage.GetGoldCourse(driver), apiGoldPage.apiGold(driver), 200, "The maximum tolerance is: 200 USD.");

	}

	@AfterTest
	public void shutDown() {
	   driver.quit();
	}
	

}
