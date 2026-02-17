
package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
public class Base {
    public WebDriver driver;
    String url = "https://tutorialsninja.com/demo/";
    public static ExtentReports extent;

    @BeforeSuite
    public void setupReport() {
     
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
}
