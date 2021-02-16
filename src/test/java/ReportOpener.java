import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReportOpener {
    // Variable definition
    WebDriver driver;

    // Code section
    @Test
    public void openReport() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        driver.get("file:///" + dir + "\\test-output\\SparkReport\\index.html");
    }
}
