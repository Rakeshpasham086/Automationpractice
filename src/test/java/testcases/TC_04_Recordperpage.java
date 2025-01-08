package testcases;

import org.testng.annotations.Test;

import pageObject.Action_Moneytransferpage;
import pageObject.MoneyTransferPage;
import pageObject.Recordsper_Pagedropdown;
import pageObject.login;

public class TC_04_Recordperpage extends BaseClass{
	public Recordsper_Pagedropdown rp;
	@Test
	public void records() throws InterruptedException {
		login lg=new login(driver);
		lg.setUsername(username);
		log.info("Entered Username");
		lg.setPassword(password);
		log.info("Entered Password");
		lg.clickOnLogin();
		log.info("Login button clicked successfully");
		MoneyTransferPage mt=new MoneyTransferPage(driver);
		mt.clickOnAccounting();
		log.info("Accounting dropdown");
		mt.clickOnMoneyTransfer();
		log.info("Money transfer");
		Thread.sleep(4000);
		rp=new Recordsper_Pagedropdown(driver);
		rp.clickOnrecordsperpage();
		log.info("50 records per page is clicked");
		Thread.sleep(2000);
		rp.clickOnAllrecords();
		log.info("all records selected");
		Thread.sleep(2000);
		rp.clickOn10records();
		log.info("10 records selected");
		Thread.sleep(2000);
		rp.clickOnNext();
		log.info("Next page is selected");
		Thread.sleep(2000);
		rp.clickOnPrevious();
		log.info("previous page is selected");
		Thread.sleep(2000);
		Action_Moneytransferpage am=new Action_Moneytransferpage(driver);
		am.clickOnAction();
		log.info("Action button is clicked");
		Thread.sleep(2000);
		am.clickOnDelete();
		log.info("delete button is clicked");
		
	}

}
