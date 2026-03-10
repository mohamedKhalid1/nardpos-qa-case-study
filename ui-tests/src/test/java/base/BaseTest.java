package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;

import reporting.ExtentManager;
import utils.DriverManager;
import utils.ScreenshotUtil;

import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupSuite() {

        // get report instance from ExtentManager
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setup(Method method) {

        // get driver from DriverManager
        driver = DriverManager.getDriver();

        driver.get("https://www.saucedemo.com/");

        // create test in report
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            test.fail(result.getThrowable());

            // capture screenshot
            ScreenshotUtil.capture(driver, result.getName());

        } else if (result.getStatus() == ITestResult.SUCCESS) {

            test.pass("Test Passed");

        } else if (result.getStatus() == ITestResult.SKIP) {

            test.skip("Test Skipped");
        }

        // quit driver using DriverManager
        DriverManager.quitDriver();
    }

    @AfterSuite
    public void generateReport() {

        extent.flush();
    }
}