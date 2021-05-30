package Pages.GuestPages.CoffeePages;

import Pages.BasePage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class NextToTheCoffeePage extends BasePage {
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
    @FindBy(partialLinkText = "המשך קריאה")
    WebElement continueRead;
    @FindBy(partialLinkText = "סגירה")
    WebElement close;
    @FindBy(css = ".hidden-md-down.remove-line-item-lg")
    WebElement removeButtonWindow;
    @FindBy(css = ".minicart.header-nav.header-cart")
    WebElement cartMenu;
    @FindBy(css = ".container.product-tile.d-flex.h-100.flex-column")
    List<WebElement> nextToProducts;
    @FindBy(css = ".add-to-cart.btn.btn-primary")
    List<WebElement> addToCartButton;
    @FindBy(className = "pdp-link")
    List<WebElement> productName;
    @FindBy(className = "empty-title")
    WebElement emptyPage;
    @FindBy(css = ".btn.btn-outline-primary")
    List<WebElement> cancelButton;
    @FindBy(css = ".line-item-name")
    List<WebElement>cartProductName;
    @FindBy(css = ".btn.btn-primary.cart-delete-confirmation-btn.mr-0")
    List<WebElement> removeButton;

    // Variable definition
    Random random = new Random();
    SoftAssert softAssert = new SoftAssert();
    String stringProductNme;

    // Functions
    public void nextToCoffeeTest() {
        enterToPage();
        addToCart();
       // nameCompere();
        removeItem();
    }

    private void enterToPage() {
        NextToTheCoffeePage.waitAndClick(nextToCoffee);
    }

    private void addToCart() {
        int product = random.nextInt(nextToProducts.size()-1);
        wait.until(ExpectedConditions.visibilityOfAllElements(nextToProducts));

        if (addToCartButton.get(product).isDisplayed()) {
            NextToTheCoffeePage.jsClick(addToCartButton.get(product));
            stringProductNme = productName.get(product).getText();
            System.out.println(stringProductNme);
            ExtentTestManager.getTest().log(Status.INFO,"You ordered: " + stringProductNme );
            driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
        }
        else {
            NextToTheCoffeePage.jsClick(addToCartButton.get(product +1));
            stringProductNme = productName.get(product+1).getText();
            System.out.println(stringProductNme);
            ExtentTestManager.getTest().log(Status.INFO,"You ordered: " + stringProductNme );
            driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
        }
    }

//    private void nameCompere() throws InterruptedException {
//        cartMenu.click();
//        System.out.println(" + " + cartProductName.get(0).getText());
//        System.out.println(" - " + stringProductNme);
//        Thread.sleep(4000);
//        System.out.println(" + " + cartProductName.get(1).getText());
//        System.out.println(" - " + stringProductNme);
//        softAssert.assertTrue(cartProductName.get(1).getText().contains(stringProductNme));
//        softAssert.assertAll();
//    }

    public void removeItem () {
        cartMenu.click();
        removeButtonWindow.click();
        IllyCapsulePage.waitAndClick(cancelButton.get(2));
        IllyCapsulePage.waitAndClick(removeButtonWindow);
        IllyCapsulePage.waitAndClick(removeButton.get(1));
        softAssert.assertTrue(emptyPage.getText().contains("סל הקניות שלך ריק"));
        softAssert.assertAll();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}


