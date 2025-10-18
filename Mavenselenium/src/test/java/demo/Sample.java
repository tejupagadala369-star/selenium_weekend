package demo;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Sample 
{
	@Test
	public void launch()
	{
	   Reporter.log("sample is executed",true);
	}

}
