package Pages.GuestPages.OrderPages;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    @FindBy(id = "Track2CardNo")
    WebElement creditCardNumber;
    @FindBy(id = "expYear")
    Select years;
    @FindBy(id = "expMonth")
    Select months;
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
    public void startPaymentTest(){
        //wait.until(ExpectedConditions.visibilityOf(creditCardNumber));
        creditCardNumber.sendKeys("4111111111111111");
        years.selectByIndex(random.nextInt(yearsNum));
        months.selectByIndex(random.nextInt(monthsNum));
        personalId.sendKeys("" + Math.random() * 9);
        pattern.sendKeys("121");
        submitBtn.click();
    }
}

