package extentreports;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnAddingSreenshot 
{
	@Test
	public void addScreenshot()
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		TakesScreenshot ts = (TakesScreenshot)driver;
		String photo = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/screenshotReporter.html");
		ExtentReports ereport=new ExtentReports();
		ereport.attachReporter(spark);
		ExtentTest test=ereport.createTest("addsScreenshot");
		test.log(Status.INFO, "adding screenshot to report");
		test.addScreenCaptureFromBase64String(photo);
		ereport.flush();
		
	}

}
