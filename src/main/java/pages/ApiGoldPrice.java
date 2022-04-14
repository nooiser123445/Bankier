package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApiGoldPrice {
	WebDriver driver;

	public ApiGoldPrice(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > span:nth-child(2)")
	WebElement goldApi;

	public String apiGold(WebDriver driver) {

		driver.get("http://api.nbp.pl/api/cenyzlota/today");

		System.out.println(goldApi.getText());

		return goldApi.getText();

	}

}
