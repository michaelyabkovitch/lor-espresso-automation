package Pages.RegisteredUserPages;

import Pages.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.windows.WEmbeddedFrame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SignUpPage extends BasePage {

    // Constructors
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // WebElement def
    @FindBy(css = ".js-otpLogin")
    WebElement signUpBtn;
    @FindBy(css = ".btn-outline-secondary")
    WebElement newAccountBtn;
    @FindBy(id = "registration-form-fname")
    WebElement userFirstName;
    @FindBy(id = "registration-form-lname")
    WebElement userLastName;
    @FindBy(id = "registration-form-phone")
    WebElement userPhone;
    @FindBy(id = "date")
    WebElement daysList;
    @FindBy(id = "month")
    WebElement monthsList;
    @FindBy(id = "year")
    WebElement yearsList;
    @FindBy(id = "registration-form-email")
    WebElement userEmail;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div/form/div/div[2]/div[2]/div[2]/div[1]/label")
    WebElement acceptBtn;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div/form/div/div[2]/div[2]/div[2]/button")
    WebElement submit;

    // Function
    public void signUp() {
        SignUpPage.waitAndClick(signUpBtn);
        SignUpPage.waitAndClick(newAccountBtn);
        SignUpPage.waitAndClick(userFirstName);
        userFirstName.sendKeys("tester");
        userLastName.sendKeys("selenium");
        userPhone.sendKeys("050" + ThreadLocalRandom.current().nextInt(1000000,9999999));
        Select days = new Select(daysList);
        days.selectByIndex(2);
        Select months = new Select(monthsList);
        months.selectByIndex(4);
        Select years = new Select(yearsList);
        years.selectByIndex(2);
        String mail = "@gmail.com";
        String generatedString = RandomStringUtils.randomAlphabetic(9);
        userEmail.sendKeys(generatedString + mail);
        acceptBtn.click();
        submit.click();
    }
}
