package core.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	 private static ExtentReports extent;
	 public synchronized static ExtentReports getInstance() {
	        if (extent == null)
	            createInstance("extent.html");
	        return extent;
	    }


	    public synchronized static ExtentReports createInstance(String fileName) {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Unbxd-Console-UI-ExtentReports");
	        htmlReporter.config().setReportName("UNBXD Console UI Automation Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	        htmlReporter.config().setTheme(Theme.DARK);
	        htmlReporter.config().setEncoding("utf-8");

	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setReportUsesManualConfiguration(true);
	        return extent;
	    }

	
}
