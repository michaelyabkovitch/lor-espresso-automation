package Pages.RegisteredUserPages;

import Pages.BasePage;
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

public class FavoriteItemPage extends BasePage {
    // Constructors
    public FavoriteItemPage(WebDriver driver) {
        super(driver);
    }

    public FavoriteItemPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // Variable definition
    Random random = new Random();
    SoftAssert softAssert = new SoftAssert();
    String stringProductNme;

    // WebElement def
    @FindBy(id = "lor_capsule")
    WebElement lorCapsulePage;
    @FindBy(css = ".container.product-tile.d-flex.h-100.flex-column")
    List<WebElement> lorProducts;
    @FindBy(className = "pdp-link")
    List<WebElement> productName;
    @FindBy(css = ".wishlist-icon")
    List<WebElement> addToWishlistBtn;
    @FindBy(css = ".header-nav.wishlist-nav.d-none.d-md-block.d-lg-block")
    WebElement wishListBtn;
    @FindBy(className = "pdp-link")
    WebElement itemName;
    @FindBy(css = ".wishlist-delete")
    WebElement deleteBtn;

    // Sign Out
    @FindBy(className = "user-button-lg")
    WebElement backToUserPage;
    @FindBy(css = "[href='/on/demandware.store/Sites-lor-Site/iw_IL/Login-Logout']")
    List<WebElement> logoutBtn;

    // Function
    public void favoriteItemTest() throws InterruptedException {
        enterToLorPage();
        addToFavorite();
        nameCompare();
        deleteList();
        logout();
    }

    public void enterToLorPage() throws InterruptedException {
        FavoriteItemPage.waitAndClick(lorCapsulePage);
    }

    public void addToFavorite() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfAllElements(lorProducts));
        LorCapsulePage.jsClick(addToWishlistBtn.get(0));
        stringProductNme = productName.get(0).getText();
        System.out.println(stringProductNme);
        driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
    }

    public void nameCompare() {
        wishListBtn.click();
        FavoriteItemPage.waitAndClick(itemName);
        System.out.println(itemName.getText());
        softAssert.assertTrue(itemName.getText().contains(stringProductNme));
        softAssert.assertAll();
    }

    public void deleteList() {
        deleteBtn.click();
    }

    public void logout() {
        backToUserPage.click();
        FavoriteItemPage.waitAndClick(logoutBtn.get(1));
    }
}

