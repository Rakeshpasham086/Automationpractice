package testcases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import utilities.Reading_Logindata;

public class BaseClass {
	public Logger log;
	Reading_Logindata rl=new Reading_Logindata();
	public String username=rl.getUsername();
	public String password=rl.getPassword();
	public String amount=rl.getAmount();
	public static WebDriver driver;
	@BeforeClass
	@Parameters({"browser", "url"})
	public void openapp(String br, String URL) {
		if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver=new EdgeDriver();
		}
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		log=Logger.getLogger("Automationpractice");
		PropertyConfigurator.configure("log4j.properties");
	}
	public String captureScreen(String tname) 
	{
		 String timestamp=new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss").format(new Date());
		 TakesScreenshot screenshot=((TakesScreenshot) driver);
		 File source=screenshot.getScreenshotAs(OutputType.FILE);
		 String destination=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
		 try
		 {
			 FileUtils.copyFile(source, new File(destination));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return destination;
		
	}
	
	
	@AfterClass
	public void closeApp() {
		driver.close();
	}
	
	

}
