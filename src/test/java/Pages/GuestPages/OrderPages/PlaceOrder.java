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

    @FindBy(css = "#terms-approval-payment-step")
    WebElement termsAndContitions;
    @FindBy(css = "[value='place-order']")
    WebElement submit;
    @FindBy(xpath = "//*[@class='order-thank-you-email-msg text-center mb-5']/span")
    WebElement numOrder;


    public void placeOrder() throws InterruptedException {
        termsAndContitions.click();
        submit.click();
        //ExtentTestManager.getTest().log(Status.INFO,"Your number ordered is : " + numOrder.getText() );
        System.out.println(numOrder.getText());
    }
}
