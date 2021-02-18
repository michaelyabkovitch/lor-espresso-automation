package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NextToTheCoffeePage extends BasePage{
    //Constructors
    public NextToTheCoffeePage(WebDriver driver) {
        super(driver);
    }

    public NextToTheCoffeePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // WebElements definition
    @FindBy(id = "next_to_coffee")
    WebElement nextToCoffee;

    // Functions
    public void click() {
        NextToTheCoffeePage.waitAndClick(nextToCoffee);
    }
}
