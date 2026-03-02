package Listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestApiListener implements ITestListener {
    private static final ExtentReports extentReports=new ExtentReports();
    private static final ThreadLocal<ExtentTest>extenttest=new ThreadLocal<>();
    static {
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter("target/extent-reports-api.html");
        extentReports.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result){
        ExtentTest test=extentReports.createTest(result.getMethod().getMethodName());
        extenttest.set(test);
        test.info("test started :"+ result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        if (extenttest.get()!=null){
                Response apiResponse=(Response)result.getTestContext().getAttribute("apiResponse");
                extenttest.get().pass("Test passed");
                extenttest.get().info("Response Body"+apiResponse.getBody().asString());

        }
    }
    @Override
    public void onTestFailure(ITestResult result){
        if (extenttest.get()!=null){
            extenttest.get().fail("Test Failed"+result.getThrowable());
        }
    }
    @Override
    public void onFinish(org.testng.ITestContext context) {
        extentReports.flush();
    }
}
