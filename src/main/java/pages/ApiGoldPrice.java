package pages;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
	//1 ounce - 28.35 grams
	double ounce = 28.35;

	@FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > span:nth-child(2)")
	WebElement goldApi;
	
	@FindBy(tagName="pre")
	WebElement rate;
	
	public Double apiGold(WebDriver driver) {

		driver.get("http://api.nbp.pl/api/cenyzlota");
		//Covert WebElement to String
		String goldToString = goldApi.getText().toString();
		Double goldtoDouble = Double.parseDouble(goldToString);
		//convert grams to ounce
		double convertOunce = goldtoDouble*ounce;
		//convert PLN to USD
		plnCourse plnCoursePage = new plnCourse(driver);
		double finalValue = convertOunce*plnCoursePage.getPLNCourse(driver);
		//round a double to 2 decimal places
		double finalValueConverted = new BigDecimal(finalValue)
				.setScale(2, RoundingMode.HALF_UP).doubleValue();
		
		System.out.println(finalValueConverted);
		
		return finalValueConverted;

	}

}
