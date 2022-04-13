package Pages.GuestPages.OrderActions;

import Pages.BasePage;
import Pages.GuestPages.CoffeePages.JacobsPage;
import Pages.GuestPages.CoffeePages.LorCapsulePage;
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

public class OrderOver150NIS extends BasePage {

    public OrderOver150NIS(WebDriver driver) {
        super(driver);
    }

    public OrderOver150NIS(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // WebElement definition
    @FindBy(id = "jacobs_coffee")
    WebElement jacobsButton;
    @FindBy(css = ".container.product-tile.d-flex.h-100.flex-column")
    List<WebElement> jacobsProducts;
    @FindBy(css = ".add-to-cart.btn.btn-primary")
    List<WebElement> addToCartButton;
    @FindBy(className = "pdp-link")
    List<WebElement> productName;
    @FindBy(css = ".minicart.header-nav.header-cart")
    WebElement cartMenu;
    @FindBy(css = ".quantity-button.quantity-upper")
    List<WebElement> upperBtn;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/div/div[2]")
    WebElement itemPrice;
    @FindBy(css = ".promotion-information.container.row.text-right")
    WebElement discount;
    @FindBy(css = ".btn.btn-primary.cart-delete-confirmation-btn.mr-0")
    List<WebElement> removeButton;
    @FindBy(css = ".hidden-md-down.remove-line-item-lg")
    WebElement removeButtonWindow;


    // Variable definition
    Random random = new Random();
    SoftAssert softAssert = new SoftAssert();
    String stringProductNme;

    // Functions
    public void orderOver150NISTest() throws InterruptedException {
        enterToPage();
        addToCart();
        orderOver150NIS();
        checkDiscount();
        removeItem();
    }

    private void enterToPage() {
        LorCapsulePage.waitAndClick(jacobsButton);
    }

    private void addToCart() {
        int product = random.nextInt(jacobsProducts.size() - 2);
        wait.until(ExpectedConditions.visibilityOfAllElements(jacobsProducts));

        if (addToCartButton.get(product).isDisplayed()) {
            JacobsPage.jsClick(addToCartButton.get(product));
            stringProductNme = productName.get(product).getText();
            System.out.println(stringProductNme);
            ExtentTestManager.getTest().log(Status.INFO, "You ordered: " + stringProductNme);
            driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
        } else {
            JacobsPage.jsClick(addToCartButton.get(product + 1));
            stringProductNme = productName.get(product + 1).getText();
            System.out.println(stringProductNme);
            ExtentTestManager.getTest().log(Status.INFO, "You ordered: " + stringProductNme);
            driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
        }
    }

    private void orderOver150NIS() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        cartMenu.click();

        String price = itemPrice.getText();
        System.out.println(price);
        String[] truePrice = price.split("₪"); // split between values
        System.out.println(truePrice[1]);
        double priceNumber = Double.parseDouble(truePrice[1].toString()); // divide between the number and char
        System.out.println(priceNumber);
        while (priceNumber < 150.0) {
            upperBtn.get(1).click();
            Thread.sleep(2000);

            price = itemPrice.getText();
            System.out.println(price);
            truePrice = price.split("₪"); // split between values
            System.out.println(truePrice[1]);
            priceNumber = Double.parseDouble(truePrice[1].toString());
        }

    }

    private void checkDiscount() {
        softAssert.assertTrue(discount.isDisplayed());
        softAssert.assertAll();


    }
    public void removeItem() {
        removeButtonWindow.click();
        OrderOver150NIS.waitAndClick(removeButton.get(1));
    }

}








