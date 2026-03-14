package Pages.GuestPages.OrderPages;

import Pages.BasePage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrder extends BasePage {
    public PlaceOrder(WebDriver driver) {
        super(driver);
    }

    public PlaceOrder(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

//    @FindBy(css = "#terms-approval-payment-step")
//    WebElement termsAndContitions;
//    @FindBy(css = ".btn.btn-primary.order-confirmation-continue-shopping")
//    WebElement backTositeBtn;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/p")
    WebElement numOrder;
    @FindBy(css = "[href='/on/demandware.store/Sites-lor-Site/iw_IL/Home-Show']")
    WebElement backToMainPage;


    public void placeOrder() throws InterruptedException {
//        termsAndContitions.click();
//        backTositeBtn.click();
        ExtentTestManager.getTest().log(Status.INFO,"Your number ordered is : " + numOrder.getText() );
        System.out.println(numOrder.getText());
        backToMainPage.click();
    }
}
