package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.MoneyTransferPage;
import pageObject.Search_MoneyTransfer;
import pageObject.login;
import utilities.XL_Utilities;

public class TC_03_Search extends BaseClass{
	public Search_MoneyTransfer sm;
	@Test(priority=1)
	public void loginandmoneytransfer() throws InterruptedException {
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
		Thread.sleep(3000);
	}
	@Test(priority=2, dataProvider="Search_testdata")
	public void search(String Search) {
		sm=new Search_MoneyTransfer(driver);
		sm.setSearch(Search);
		log.info("Data Entered");
	}
	
	@DataProvider(name="Search_testdata")
	String[][] getData() throws IOException
	{
		String path="C:\\Users\\Hp\\eclipse-workspace\\Automatiopractice\\src\\test\\java\\testdata\\Amount.xlsx";
		int rownum=XL_Utilities.getRowCount(path,"Sheet2");
		int colcount=XL_Utilities.getCellcount(path, "Sheet2",1);
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XL_Utilities.getcelldata(path,"Sheet2",i,j);
			}
		}
		return logindata;
	}
	

}
