package Tests;


import UsefulClasses.MainFunctions;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.w3c.dom.Document;


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainTest {

    // Variables definition
    public static Document doc = null;
    public static ATUTestRecorder recorder;
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;
    public static final String RECORD_PATH = "./records";
    public static Date date = new Date();
    public static DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
    public static final String PATH = "https://storefront:diplo@staging-eu01-diplomat.demandware." +
            "net/on/demandware.store/Sites-lor-Site/default/Home-Show";

    // Code section
    @BeforeSuite
    public static void startRecording() throws ATUTestRecorderException{
      MainFunctions.startRecording();
    }

    @BeforeTest
    public void initialize(ITestContext iTestContext) throws ATUTestRecorderException {
        iTestContext.setAttribute("driver", driver);
        MainFunctions.initBrowser();

    }

    @AfterTest
    public void quit() throws ATUTestRecorderException {
       MainFunctions.closeSession();
    }

    @AfterSuite
    public void finish() throws ATUTestRecorderException {
        recorder.stop();
        MainFunctions.openReport();
    }


}
