package Pages.GuestPages.OrderActions;

import Pages.BasePage;
import Pages.GuestPages.CoffeePages.JacobsPage;
import Pages.GuestPages.CoffeePages.LorCapsulePage;
import Tests.GuestTests.OrderActionTest.OrderWithCouponTest;
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

public class OrderWithCoupons extends BasePage {
    public OrderWithCoupons(WebDriver driver) {
        super(driver);
    }

    public OrderWithCoupons(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // WebElement definition

    @FindBy(css = ".form-control.coupon-code-field")
    WebElement couponCodeFeild;
    @FindBy(css = ".btn.btn-outline-dark.promo-code-btn")
    WebElement submitBtn;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/div/div[2]")
    WebElement itemPrice;
    @FindBy(className = "remove-coupon")
    WebElement removeCoupon;
    @FindBy(css = ".btn.btn-primary.delete-coupon-confirmation-btn.mr-0")
    WebElement confirmBtn;
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

    // Variable definition
    Random random = new Random();
    SoftAssert softAssert = new SoftAssert();
    String stringProductNme;

    //Functions
    public void OrderWithCouponTest() throws InterruptedException {
        enterToPage();
        addToCart();
        twentyPercents();
        deleteCoupon();
        freeCode();

    }

    private void enterToPage() {
        OrderWithCoupons.waitAndClick(jacobsButton);
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

    private void twentyPercents() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        cartMenu.click();
        String price = itemPrice.getText();
        System.out.println(price);
        String[] truePrice = price.split("₪"); // split between values
        System.out.println(truePrice[1]);
        double priceNumber = Double.parseDouble(truePrice[1].toString()); // divide between the number and char
        System.out.println(priceNumber);
        couponCodeFeild.sendKeys("test20");
        submitBtn.click();
        String afterPrice = itemPrice.getText();
        System.out.println(afterPrice);
        String[] afterTruePrice = afterPrice.split("₪"); // split between values
        System.out.println(afterTruePrice[1]);
        double afterPriceNumber = Double.parseDouble(afterTruePrice[1].toString()); // divide between the number and char
        double discount = priceNumber * 0.2;

        softAssert.assertEquals(afterPriceNumber , priceNumber - discount);
    }

    private void deleteCoupon(){
        removeCoupon.click();
        OrderWithCoupons.jsClick(confirmBtn);

    }

    private void freeCode(){
        couponCodeFeild.sendKeys("testfree");
        OrderWithCoupons.jsClick(submitBtn);
        String afterPrice = itemPrice.getText();
        System.out.println(afterPrice);
        String[] afterTruePrice = afterPrice.split("₪"); // split between values
        System.out.println(afterTruePrice[1]);
        double afterPriceNumber = Double.parseDouble(afterTruePrice[1].toString()); // divide between the number and char
        softAssert.assertEquals(afterPriceNumber, 0.00);

    }



}
