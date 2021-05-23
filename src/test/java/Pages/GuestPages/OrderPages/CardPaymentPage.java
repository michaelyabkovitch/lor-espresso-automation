package Pages.GuestPages.OrderPages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class CardPaymentPage extends BasePage {
    // Constructors
    public CardPaymentPage(WebDriver driver) {
        super(driver);
    }

    public CardPaymentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // WebElement definition
    @FindBy(css = "#paymentIframe")
    WebElement iFrame;
    @FindBy(id = "Track2CardNo")
    WebElement creditCardNumber;
    @FindBy(xpath = "//*[@id='expYear']")
    WebElement years;
    @FindBy(id = "expMonth")
    WebElement months;
    @FindBy(id = "personalId")
    WebElement personalId;
    @FindBy(id = "cvv")
    WebElement pattern;
    @FindBy(id = "submitBtn")
    WebElement submitBtn;

    // Variables definition
    Random random = new Random();
    int yearsNum = 15;
    int monthsNum = 12;

    // Functions
    public void startPaymentTest() throws InterruptedException {
        driver.switchTo().frame(iFrame);
        creditCardNumber.sendKeys("4111111111111111");
        Select a = new Select(years);
        a.selectByVisibleText("2024");
        Select months2 = new Select(months);
        months2.selectByVisibleText("04");
        personalId.sendKeys("00000000000000");
        pattern.sendKeys("121");
        submitBtn.click();
        Thread.sleep(5000);
    }
}

