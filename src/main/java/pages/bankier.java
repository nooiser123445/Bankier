package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	@FindBy(xpath = "//span[@class='MuiButton-label' and text()='Accept All']")
	WebElement popup;

	public String GetGoldCourse(WebDriver driver) {

		driver.get("https://www.bankier.pl/");

		this.driver.switchTo().frame("cmp-iframe");
		popup.click();
		this.driver.switchTo().defaultContent();
		dropdown.click();
		materials.click();
		moreLink.click();
		System.out.println(GoldCourse.getText());
		return GoldCourse.getText();

	}

}
