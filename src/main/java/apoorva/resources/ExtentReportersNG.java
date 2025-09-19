package apoorva.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportersNG {
	
	public static ExtentReports getReportObject() {
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	
	ExtentSparkReporter reporter =new ExtentSparkReporter(path);
			//ExtentSparkReporter reporter is responsible for creating html file and do some configurations
    reporter.config().setReportName("Web Automation results");
 reporter.config().setDocumentTitle("Test Results");
 ExtentReports extent=new ExtentReports();
extent.attachReporter(reporter);
extent.setSystemInfo("Tester","Apoorva");
System.out.println("Extent report generated at: " + path);
return extent;
}
}