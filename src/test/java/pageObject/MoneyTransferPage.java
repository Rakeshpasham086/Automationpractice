package pageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MoneyTransferPage {
	public static WebDriver driver;
	public Select select;
	public MoneyTransferPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Accounting']")
	WebElement linkAccounting;
	@FindBy(id="money-transfer-menu")
	WebElement selectMoneytransfer;
	@FindBy(xpath="//button[@class='btn btn-info']")
	WebElement btnaddmoneytransfer;
	@FindBy(xpath="(//div[@class='btn-group bootstrap-select form-control'])[11]/select")
	WebElement drpfromaccount;
	@FindBy(xpath="(//div[@class='btn-group bootstrap-select form-control'])[12]/select")
	WebElement drpToaccount;
	@FindBy(xpath="(//input[@class='form-control'])[14]")
	WebElement txtAmount;
	@FindBy(xpath="(//button[text()='Submit'])[9]")
	WebElement btnsubmit;
	public void clickOnAccounting() {
		linkAccounting.click();
	}
	public void clickOnMoneyTransfer() {
		selectMoneytransfer.click();
	}
	public void clickOnAddMoneytransfer() {
		btnaddmoneytransfer.click();
	}
	public void selectfromaccount() {
		select=new Select(drpfromaccount);
		select.selectByIndex(5);
	}
	public void selectToAccount() {
		select=new Select(drpToaccount);
		select.selectByIndex(7);
	}
	public void setAmount(String amount) {
		txtAmount.sendKeys(amount);
	}
	public void clickOnSubmit() {
		btnsubmit.click();
	}

}
