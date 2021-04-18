package Pages.GuestPages.CoffeePages;

import Pages.BasePage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class IllyCapsulePage extends BasePage {
    //Constructors
    public IllyCapsulePage(WebDriver driver) {
        super(driver);
    }

    public IllyCapsulePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // WebElements definition
    @FindBy(id = "Illy_capsule")
    WebElement illyCapsulePage;
    @FindBy(css = ".minicart.header-nav.header-cart")
    WebElement cartMenu;
    @FindBy(css = ".hidden-md-down.remove-line-item-lg")
    WebElement removeButtonWindow;
    @FindBy(className = "empty-title")
    WebElement emptyPage;
    @FindBy(css = ".btn.btn-outline-primary")
    List<WebElement> cancelButton;
    @FindBy(css = ".line-item-name")
    List<WebElement>cartProductName;
    @FindBy(css = ".container.product-tile.d-flex.h-100.flex-column")
    List<WebElement> lorProducts;
    @FindBy(css = ".add-to-cart.btn.btn-primary")
    List<WebElement> addToCartButton;
    @FindBy(className = "pdp-link")
    List<WebElement> productName;
    @FindBy(css = ".btn.btn-primary.cart-delete-confirmation-btn.mr-0")
    List<WebElement> removeButton;

    // Variable definition
    Random random = new Random();
    SoftAssert softAssert = new SoftAssert();
    String stringProductNme;

    // Functions
    public void illyTest() {
        enterToPage();
        addToCart();
        nameCompere();
        removeItem();
    }

    private void enterToPage() {
        IllyCapsulePage.waitAndClick(illyCapsulePage);
    }

    private void addToCart() {
        int product = random.nextInt(lorProducts.size());
        wait.until(ExpectedConditions.visibilityOfAllElements(lorProducts));
        IllyCapsulePage.jsClick(addToCartButton.get(product));
        stringProductNme = productName.get(product).getText();
        ExtentTestManager.getTest().log(Status.INFO,"You ordered: " + stringProductNme );
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    }

    private void nameCompere() {
        cartMenu.click();
        softAssert.assertTrue(cartProductName.get(1).getText().contains(stringProductNme));
        softAssert.assertAll();
    }

    public void removeItem () {
        removeButtonWindow.click();
        IllyCapsulePage.waitAndClick(cancelButton.get(3));
        IllyCapsulePage.waitAndClick(removeButtonWindow);
        IllyCapsulePage.waitAndClick(removeButton.get(1));
        softAssert.assertTrue(emptyPage.getText().contains("סל הקניות שלך ריק"));
        softAssert.assertAll();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}






