package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Recordsper_Pagedropdown {
	public static WebDriver driver;
	public Select select;
	public Recordsper_Pagedropdown(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//div[@class='btn-group bootstrap-select form-control form-control-sm']/select")
	WebElement drppages;
	@FindBy(xpath="(//a[@class='page-link'])[9]")
	WebElement btnnext;
	@FindBy(id="money-transfer-table_previous")
	WebElement btnprevious;
	
	public void clickOnrecordsperpage() {
		select=new Select(drppages);
		select.selectByValue("50");
		
	}
	public void clickOnAllrecords() {
		select=new Select(drppages);
		select.selectByVisibleText("All");
	}
	public void clickOn10records() {
		select=new Select(drppages);
		select.selectByIndex(0);
	}
	public void clickOnNext() {
		btnnext.click();
	}
	public void clickOnPrevious() {
		btnprevious.click();
	}
}
