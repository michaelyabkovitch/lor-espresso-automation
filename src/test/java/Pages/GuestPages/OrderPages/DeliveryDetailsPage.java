package Pages.GuestPages.OrderPages;

import Pages.BasePage;
import Pages.GuestPages.CoffeePages.NextToTheCoffeePage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DeliveryDetailsPage extends BasePage {
    // Constructor
    public DeliveryDetailsPage(WebDriver driver) {
        super(driver);
    }

    public DeliveryDetailsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // WebElement
    @FindBy(id = "next_to_coffee")
    WebElement nextToCoffee;
    @FindBy(id = "shippingFirstNamedefault")
    WebElement firstNameField;
    @FindBy(id = "shippingLastNamedefault")
    WebElement lastNameField;
    @FindBy(id = "shippingPhoneNumberdefault")
    WebElement phoneNumberField;
    @FindBy(id = "shippingEmaildefault")
    WebElement emailField;
    @FindBy(id = "shippingStreetdefault")
    WebElement streetNameField;
    @FindBy(id = "shippingHouseNumberdefault")
    WebElement houseNumberField;
    @FindBy(id = "shippingAddressEntrydefault")
    WebElement addressEntryField;
    @FindBy(id = "shippingAddressapartmentdefault")
    WebElement addressApartmentField;
    @FindBy(id = "shippingFloordefault")
    WebElement floorField;
    @FindBy(id = "shippingAddressCommentsdefault")
    WebElement addressCommentsField;
    @FindBy(css = ".minicart.header-nav.header-cart")
    WebElement cartMenu;
    @FindBy(css =".btn.btn-primary.btn-block.submit-shipping")
    WebElement submit;
    @FindBy(css = ".btn.btn-block.btn-primary.checkout-as-guest")
    WebElement continueGuestButton;
    @FindBy(css = ".js-cart-checkout-button.btn.btn-primary.col")
    List<WebElement> continueOrderButtons;
    @FindBy(css = ".container.product-tile.d-flex.h-100.flex-column")
    List<WebElement> nextToProducts;
    @FindBy(css = ".add-to-cart.btn.btn-primary")
    List<WebElement> addToCartButton;
    @FindBy(className = "pdp-link")
    List<WebElement> productName;


    // Variables
    Random random = new Random();
    String stringProductNme;

    // Functions
    public void startOrderDetails(){
        startOrder();
        addToCart();
        continueOrder();
        orderItem();
    }

    public void continueOrder() {
        cartMenu.click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        NextToTheCoffeePage.jsClick(continueOrderButtons.get(1));
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        NextToTheCoffeePage.jsClick(continueGuestButton);
    }

    public void orderItem(){
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys("TestFirstName");
        lastNameField.sendKeys("TestLastName");
        phoneNumberField.sendKeys("050-0000000");
        emailField.sendKeys("test@gmail.com");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementById('shippingAddressCitydefault').setAttribute('value', 'רחובות')");
        streetNameField.sendKeys("TestStreet");
        houseNumberField.sendKeys("10");
        addressEntryField.sendKeys("1");
        addressApartmentField.sendKeys("2");
        floorField.sendKeys("1");
        addressCommentsField.sendKeys("TestComments");
        submit.click();

    }

    private void startOrder() {
        DeliveryDetailsPage.waitAndClick(nextToCoffee);
    }

    private void addToCart() {
        int product = random.nextInt(nextToProducts.size()-2);
        wait.until(ExpectedConditions.visibilityOfAllElements(nextToProducts));
        NextToTheCoffeePage.jsClick(addToCartButton.get(product));
        stringProductNme = productName.get(product).getText();
        ExtentTestManager.getTest().log(Status.INFO,"You ordered: " + stringProductNme );
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    }
}

