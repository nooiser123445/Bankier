package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class bankier {

	WebDriver driver;

	public bankier(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "m-menu-list__title")
	WebElement dropdown;

	@FindBy(linkText = "Surowce")
	WebElement materials;

	@FindBy(className = "more-link")
	WebElement moreLink;

	@FindBy(xpath = "//tbody[1]/tr[2]/td[3]")
	WebElement GoldCourse;

	@FindBy(xpath = "//span[@class='MuiButton-label' and text()='Zaakceptuj wszystko']")
	WebElement popupPOL;
	
	@FindBy(xpath = "//span[@class='MuiButton-label' and text()='Accept All']")
	WebElement popupENG;

	public Double GetGoldCourse(WebDriver driver) {

		driver.get("https://www.bankier.pl/");

		this.driver.switchTo().frame("cmp-iframe");
		//POL/ENG Popup workaround
		try {
			popupENG.click();
		}catch (NoSuchElementException e) {
			popupPOL.click();
		}
		this.driver.switchTo().defaultContent();
		
		//move mouse to element
		Actions a = new Actions(driver);
		a.moveToElement(dropdown).perform();
		
		materials.click();
		moreLink.click();
		//convert WebElement to string
		String Gold = GoldCourse.getText().toString();
		//Delete and replace illegal chars for double
		Gold = Gold.replace(" ", "").replace(",", ".");
		//convert String to Double
		Double doubleGold = Double.parseDouble(Gold);
		System.out.println(doubleGold);

		return doubleGold;


	}

}
