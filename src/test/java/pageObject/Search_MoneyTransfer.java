package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_MoneyTransfer {
	public static WebDriver driver;
	public Search_MoneyTransfer(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	WebElement txtSearch;
	public void setSearch(String search) {
		txtSearch.sendKeys(search);
		txtSearch.clear();
	}
}