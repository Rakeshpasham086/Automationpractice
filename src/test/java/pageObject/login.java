package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
	public static WebDriver driver;
	public login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="login-username")
	WebElement txtusername;
	@FindBy(id="login-password")
	WebElement txtpassword;
	@FindBy(xpath="//button[@class='btn btn-primary btn-block']")
	WebElement btnlogin;
	public void setUsername(String username) {
		txtusername.sendKeys(username);
	}
	public void setPassword(String password) {
		txtpassword.sendKeys(password);
	}
	public void clickOnLogin() {
		btnlogin.click();
	}
}
