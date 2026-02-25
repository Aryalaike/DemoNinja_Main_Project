package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {

    public WebDriver driver;
    String url = "https://tutorialsninja.com/demo/";

    public static ExtentReports extent;

    @BeforeSuite
    public void setupReport() {

        ExtentSparkReporter reporter =
                new ExtentSparkReporter("./Reports/Report.html");

        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("TutorialsNinja Testing");
        reporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Tester", "Arya");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openUrl() {
        driver.get(url);
    }

    @AfterSuite
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

        if (extent != null) {
            extent.flush();
        }
    }
}