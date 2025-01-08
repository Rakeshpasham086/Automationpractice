package testcases;

import org.testng.annotations.Test;

import pageObject.login;

public class TC_01_Login extends BaseClass{
	public login lg;
	@Test
	public void login() {
		lg=new login(driver);
		lg.setUsername(username);
		log.info("Entered Username");
		lg.setPassword(password);
		log.info("Entered Password");
		lg.clickOnLogin();
		log.info("Login button clicked successfully");
	}

}
