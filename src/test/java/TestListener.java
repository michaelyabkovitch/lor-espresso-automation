import Tests.MainTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.service.ExtentTestManager;
import net.bsmch.Screenshot;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestListener implements ITestListener, IAnnotationTransformer {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentTestManager.createMethod(iTestResult);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentTestManager.getTest().log(Status.PASS,
                iTestResult.getTestContext().getName() + " Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ExtentTestManager.getTest().log(Status.PASS,
                iTestResult.getTestContext().getName() + " Test failed");
        ExtentTestManager.getTest().info("screenshot", Screenshot.captureScreen("fail", MainTest.driver));

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentService.getInstance().flush();
    }


//    @Override
//    public void transform(ITestAnnotation testAnnotation, Class testClass, Constructor testConstructor, Method testMethod) {
//        IRetryAnalyzer retry = testAnnotation.getRetryAnalyzer();
//
//        if (retry == null) {
//            testAnnotation.setRetryAnalyzer(RetryFailedTestCases.class);
//        }
//    }
}
