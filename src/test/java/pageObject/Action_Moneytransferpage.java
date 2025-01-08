package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Action_Moneytransferpage {
	public static WebDriver driver;
	public Action_Moneytransferpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//button[@class='btn btn-default btn-sm dropdown-toggle'])[8]")
	WebElement btnaction;
	@FindBy(xpath="(//button[@class='btn btn-link'])[16]")
	WebElement btndelete;
	public void clickOnAction() {
		btnaction.click();
	}
	public void clickOnDelete() {
		btndelete.click();
		Alert a=driver.switchTo().alert();
		a.accept();
	}

}
