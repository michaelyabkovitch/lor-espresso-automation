package Pages.RegisteredUserPages;

import Pages.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.ThreadLocalRandom;

public class EditDetailsPage extends BasePage {

    // Constructors

    public EditDetailsPage(WebDriver driver) {
        super(driver);
    }

    public EditDetailsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // variables def
    String firstName = null;
    String lastName = null;
    String phone = null;
    String email = null;

    // WebElement def
    @FindBy(css=".nav-link.active")
    WebElement personalDetailsButton;
    @FindBy(className="t-card-edit")
    WebElement editButton;
    @FindBy(id = "firstName")
    WebElement firstNameField;
    @FindBy(id = "lastName")
    WebElement lastNameField;
    @FindBy(id = "phone")
    WebElement phoneNumberField;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "date")
    WebElement daysList;
    @FindBy(id = "month")
    WebElement monthsList;
    @FindBy(id = "year")
    WebElement yearsList;
    @FindBy(css=".btn.btn-save.btn-block.btn-primary.mb-3")
    WebElement saveButton;

    // functions
    public void editDetailsTest() throws InterruptedException {
        editValues();

    }

    private void editValues() throws InterruptedException {
        firstName = "test";
        lastName = "test";
        phone = "050" + ThreadLocalRandom.current().nextInt(1000000,9999999);
        email = RandomStringUtils.randomAlphabetic(9) + "@gmail.com";
        personalDetailsButton.click();
        editButton.click();

        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phone);
        emailField.clear();
        emailField.sendKeys(email);

        Select days = new Select(daysList);
        days.selectByIndex(1);
        Select months = new Select(monthsList);
        months.selectByIndex(4);
        Select years = new Select(yearsList);
        years.selectByIndex(10);
        Thread.sleep(1000);
        saveButton.click();

    }

}
