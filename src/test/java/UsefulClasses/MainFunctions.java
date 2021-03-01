package UsefulClasses;

import Tests.MainTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;


public class MainFunctions extends MainTest {
    public static boolean recorderStart = false;
    public static void readXmlFile()
    {
        DocumentBuilder dBuilder;
        File fXmlFile = new File("");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
    }
    public static String getData(String value) {
        if (doc == null) {
            readXmlFile();
        }
        return doc.getElementsByTagName(value).item(0).getTextContent();
    }

    public static void initBrowser() throws ATUTestRecorderException {
        driver = initChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
        driver.get(PATH);
        actions =new Actions(driver);
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static void startRecording() throws ATUTestRecorderException{
        DirChecker dirChecker = new DirChecker();
        dirChecker.dirCreator();
                if(!recorderStart) {
            recorder = new ATUTestRecorder(RECORD_PATH,
                "new record - " + dateFormat.format(date), false);
            recorder.start();
        }
        recorderStart = true;
    }

    public static void closeSession() throws ATUTestRecorderException {
        if (driver != null) {
            driver.quit();
        }
    }
}
