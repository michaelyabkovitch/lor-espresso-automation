package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage extends BasePage {
    public FooterPage(WebDriver driver) {
        super(driver);
    }

    public FooterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}
