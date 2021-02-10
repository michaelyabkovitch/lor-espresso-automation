package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageObject{
    // Constructor
    public BasePage(WebDriver driver) {
        super(driver);
    }

    public BasePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // WebElements definition

}
