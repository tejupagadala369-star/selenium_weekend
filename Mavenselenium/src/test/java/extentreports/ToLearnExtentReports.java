package extentreports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReports 
{
	@Test
	public void createReport()
	{
		String time = LocalDateTime.now().toString().replace(":", "-");
		//step-1 create ExtentSparkReports object
		ExtentSparkReporter spark=new ExtentSparkReporter("./Html_Reports/ExtentReports"+time+".html");
	   
		//step-2 create ExtentReports object
		ExtentReports ereport=new ExtentReports();
		
		//step-3 attach ExtentSparkReporter to ExtentReports object
		ereport.attachReporter(spark);
		
		//step-4 create ExtentTest object
		ExtentTest test=ereport.createTest("createReport");
		
		//step-5 call log(status,"message")
		test.log(Status.PASS,"message added into report");
		
		//step-6 call flush()
		ereport.flush();
	}

}
