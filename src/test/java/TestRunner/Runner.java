package TestRunner;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import Utilities.ExtentReportManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "Features", 
		glue= {"StepDefinition"},
		dryRun = false,
		monochrome = true,
		tags = "@Sanity or @Regression",
		plugin = {"pretty", "html:target/HtmlReports/index.html"}
		)

public class Runner extends AbstractTestNGCucumberTests{

	
	@BeforeSuite
    public void beforeSuite() {
        ExtentReportManager.getReportInstance();
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReportManager.flushReports();
    }
}
