package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageObject{
    // Constructors
    public BasePage(WebDriver driver) {
        super(driver);
    }

    public BasePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // WebElements definition
    @FindBy(css = ".d-inline-block")
    WebElement homePageButton;
    @FindBy(id = "lor_capsule")
    WebElement lorCapsule;
    @FindBy(id = "jacobs_coffee")
    WebElement jacobsCoffee;
    @FindBy(id = "Illy_capsule")
    WebElement illyCapsule;
    @FindBy(id = "next_to_coffee")
    WebElement nextToCoffee;
    @FindBy(css = ".header-search")
    WebElement searchButton;
    @FindBy(css = ".header-cart")
    WebElement cartButton;
    @FindBy(css = ".btn.d-flex.p-0.p-lg-4.js-otpLogin")
    WebElement helloGust;

    // Functions
    public static void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void jsClick(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }
}
