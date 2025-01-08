package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.MoneyTransferPage;
import pageObject.login;
import utilities.XL_Utilities;

public class TC_02_MoneyTransferPage extends BaseClass{
	public MoneyTransferPage mt;
	@Test(priority=1)
	public void Transfermoney(){
		login lg=new login(driver);
		lg.setUsername(username);
		log.info("Entered Username");
		lg.setPassword(password);
		log.info("Entered Password");
		lg.clickOnLogin();
		log.info("Login button clicked successfully");
		mt=new MoneyTransferPage(driver);
		mt.clickOnAccounting();
		log.info("Accounting dropdown");
		mt.clickOnMoneyTransfer();
		log.info("Money transfer");
		mt.clickOnAddMoneytransfer();
		log.info("Add Money transfer");
		mt.selectfromaccount();
		log.info("From Account");
		mt.selectToAccount();
		log.info("To Account");
		mt.setAmount(amount);
		log.info("set amount");
		mt.clickOnSubmit();
		log.info("submit button");
	}
	@Test(priority=2, dataProvider="Login_testdata1")
	public void sendingamount(String Amount) {
		mt=new MoneyTransferPage(driver);
		mt.clickOnAddMoneytransfer();
		log.info("Add Money transfer");
		mt.selectfromaccount();
		log.info("From Account");
		mt.selectToAccount();
		log.info("To Account");
		mt.setAmount(Amount);
		log.info("set amount");
		mt.clickOnSubmit();
		log.info("submit button");
		
	}

	@DataProvider(name="Login_testdata1")
	String[][] getData() throws IOException
	{
		String path="C:\\Users\\Hp\\eclipse-workspace\\Automatiopractice\\src\\test\\java\\testdata\\Amount.xlsx";
		int rownum=XL_Utilities.getRowCount(path,"Sheet1");
		int colcount=XL_Utilities.getCellcount(path, "Sheet1",1);
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XL_Utilities.getcelldata(path,"Sheet1",i,j);
			}
		}
		return logindata;
	}
	


}
