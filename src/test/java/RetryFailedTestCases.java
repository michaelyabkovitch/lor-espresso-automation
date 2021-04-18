import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {
    private int retryCnt = 0;
    private static final int maxRetryCnt = 2;

    @Override
    public boolean retry(ITestResult result) {

        if (retryCnt < maxRetryCnt) {
            retryCnt++;
            return true;
        }
        return false;
    }
}