package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructors
    public PageObject(WebDriver driver) {
        this(driver, new WebDriverWait(driver, 10));
    }

    public PageObject(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

        PageFactory.initElements(driver, this);
    }
}
