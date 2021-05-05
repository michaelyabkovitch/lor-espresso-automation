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

public class JacobsPage extends BasePage {
    //Constructors
    public JacobsPage(WebDriver driver) {
        super(driver);
    }

    public JacobsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // WebElement definition
    @FindBy(id = "jacobs_coffee")
    WebElement jacobsButton;
    @FindBy(partialLinkText = "המשך קריאה")
    WebElement continueRead;
    @FindBy(partialLinkText = "סגירה")
    WebElement close;
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
    List<WebElement> jacobsProducts;
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
    public void jacobsTest() throws InterruptedException {
        enterToPage();
        //continueAndClose();
        addToCart();
        nameCompere();
        removeItem();
    }

    private void enterToPage() {
        LorCapsulePage.waitAndClick(jacobsButton);
    }

    private void continueAndClose() throws InterruptedException {
        LorCapsulePage.waitAndClick(continueRead);
        Thread.sleep(3000);
        LorCapsulePage.waitAndClick(close);
    }

    private void addToCart() {
        int product = random.nextInt(jacobsProducts.size() -1);
        wait.until(ExpectedConditions.visibilityOfAllElements(jacobsProducts));

        if (addToCartButton.get(product).isDisplayed()) {
            JacobsPage.jsClick(addToCartButton.get(product));
            stringProductNme = productName.get(product).getText();
            System.out.println(stringProductNme);
            ExtentTestManager.getTest().log(Status.INFO,"You ordered: " + stringProductNme );
            driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
        }
        else {
            JacobsPage.jsClick(addToCartButton.get(product +1));
            stringProductNme = productName.get(product+1).getText();
            System.out.println(stringProductNme);
            ExtentTestManager.getTest().log(Status.INFO,"You ordered: " + stringProductNme );
            driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
        }
    }

    private void nameCompere() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        cartMenu.click();
        softAssert.assertTrue(cartProductName.get(1).getText().contains(stringProductNme));
        softAssert.assertAll();
    }

    public void removeItem() {
        removeButtonWindow.click();
        LorCapsulePage.waitAndClick(cancelButton.get(2));
        LorCapsulePage.waitAndClick(removeButtonWindow);
        LorCapsulePage.waitAndClick(removeButton.get(1));
        softAssert.assertTrue(emptyPage.getText().contains("סל הקניות שלך ריק"));
        softAssert.assertAll();
    }
}
