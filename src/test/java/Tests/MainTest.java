package Tests;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainTest {
    // Variables definition
    public WebDriver driver;
    public WebDriverWait wait;
    final String PATH = "https://www.lor-espresso.co.il/";
    final String RECORD_PATH = "./records";
    ATUTestRecorder recorder;
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
    DirChecker dirChecker = new DirChecker();

    // Code section
    @BeforeTest
    public void initialize(ITestContext iTestContext) throws ATUTestRecorderException {
        dirChecker.dirCreator();
        recorder = new ATUTestRecorder(RECORD_PATH,
                "new record - " + dateFormat.format(date), false);
        recorder.start();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        iTestContext.setAttribute("driver", driver);
        driver.get(PATH);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quit() throws ATUTestRecorderException {
        if (driver != null) {
            driver.quit();
            recorder.stop();
        }
    }
}

