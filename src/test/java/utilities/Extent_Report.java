package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import testcases.BaseClass;

public class Extent_Report implements ITestListener {
	public ExtentSparkReporter reporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext context) {
		String timestamp=new SimpleDateFormat("YYYY.MM.DD.HH.mm.ss").format(new Date());
		String repname="POS_testreport"+timestamp+".html";
		
		reporter=new ExtentSparkReporter("C:\\Users\\Hp\\eclipse-workspace\\Automatiopractice\\reports\\"+repname);
		reporter.config().setDocumentTitle("POS test report");
		reporter.config().setReportName("POS login");
		reporter.config().setTheme(Theme.STANDARD);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("user", "Rakesh");
		extent.setSystemInfo("host", "localhost");
		extent.setSystemInfo("os", "windows10");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("browsers", "chrome,edge");
	}
	public void onTestSuccess(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		try {
			String imgpath = new BaseClass().captureScreen(tr.getName());
			test.addScreenCaptureFromPath(imgpath);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void onTestSkipped(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
		
		
	}
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
