package demandableAutomationEngineerWithCroreSalary;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManagerReport 
{
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports report;
	
	public static ExtentReports getInstance()
	{
		if(htmlReport==null)
			htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+"//reports//report.html");
			htmlReport.config().setDocumentTitle("Automation Reports");
			htmlReport.config().setReportName("Functional Report");
			htmlReport.config().setTheme(Theme.STANDARD);
		
			 report = new ExtentReports();
			 report.attachReporter(htmlReport);
			 report.setSystemInfo("OS", "Windows10");
			 report.setSystemInfo("TesterName", "Singhel");
			 report.setSystemInfo("Browser", "Chrome");
		 
		 
		return report;
		
	}
}
