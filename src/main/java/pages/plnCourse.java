package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class plnCourse {
	
	WebDriver driver;
	
	public plnCourse(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName="pre")
	WebElement plnCourse;
	
	public double getPLNCourse (WebDriver driver) {
		
		driver.get("https://currencies.apps.grandtrunk.net/getlatest/PLN/USD");
		String strPLN = plnCourse.getText().toString();
		Double doublePLN = Double.parseDouble(strPLN);
		
		return doublePLN;
		
		
	}
	

}
