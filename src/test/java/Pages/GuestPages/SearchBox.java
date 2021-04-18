package Pages.GuestPages;

import Pages.BasePage;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class SearchBox extends BasePage {
    // Constructors
    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public SearchBox(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // Variables definition
    String productsNames []  = {"מילקה לבבות פרלינים"," עוגיות אוראו דקות בטעם וניל",
            "עוגיות אוראו גולדן","עוגיות אוראו מיני בטעם שוקו",
            "לור כוס זכוכית לונגו"," קפה נמס ג'ייקובס קרוננג שקית 160 גרם", "קלאסיקו 7, קפסולות ג'ייקובס",
            "קפה נמס ג'ייקובס גולד צנצנת 200 גרם","קפה נמס ג'ייקובס נטול קפאין צנצנת 200 גרם",
            "ריסטרטו 12, קפסולות ג'ייקובס","סונטוזו 8, קפסולות קפה לור","אור רוז 7, קפסולות קפה לור"
            ,"אור אבסולו 9, קפסולות קפה לור","הודו 10, קפסולות קפה לור","אולטימו 13, קפסולות קפה לור"};
    Random productName = new Random();
    String name;
    SoftAssert softAssert = new SoftAssert();

    // WebElements definition
    @FindBy(css = ".search.header-nav.header-search")
    WebElement searchButton;
    @FindBy(css = ".form-control.search-field.container")
    WebElement searchField;
    @FindBy(className = "logo-home")
    WebElement homeButton;
    @FindBy(className = "pdp-link")
    WebElement itemName;

    // Functions
    public void searchItem() {
        SearchBox.waitAndClick(searchButton);
        name = productsNames[productName.nextInt(productsNames.length -1)];
        searchField.sendKeys(name);
        searchField.submit();
        ExtentTestManager.getTest().info("You searched: " + name);
        softAssert.assertTrue(itemName.getText().contains(name));
        softAssert.assertAll();
        homeButton.click();
    }
}
