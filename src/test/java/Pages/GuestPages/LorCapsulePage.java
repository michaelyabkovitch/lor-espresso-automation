package Pages.GuestPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LorCapsulePage extends BasePage {
    //Constructors
    public LorCapsulePage(WebDriver driver) {
        super(driver);
    }

    public LorCapsulePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // WebElements definition
    @FindBy(id = "lor_capsule")
    WebElement lorCapsule;

    // Functions
    public void enterToLorPage() {
        LorCapsulePage.waitAndClick(lorCapsule);
    }
}
