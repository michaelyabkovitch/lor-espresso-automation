package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FooterPage  extends BasePage {
    public FooterPage(WebDriver driver) {

        super(driver);
    }

    public FooterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    // WebElements definition
    @FindBy (name = "contactFirstName" )
    WebElement contactFirstName;
    @FindBy (name = "contactLastName" )
    WebElement contactLastName;
    @FindBy (name = "contactEmail" )
    WebElement contactEmail;
    @FindBy (name = "contactComment")
    WebElement contactComment;
    @FindBy (className = "list-item")
    List<WebElement> listIteml ;
    @FindBy (id  = "contact-topic")
    WebElement contactTopicDropDownMenu;

    //
    @FindBy(className = "faq-title")
    WebElement title;


    // Variable definition
    SoftAssert softAssert = new SoftAssert();


    private  String returnWebElement(String value) throws InterruptedException {
        js.executeScript("window.scrollBy(0,5000)");
        String element = null;
        for (int i = 0; i < listIteml.size(); i++) {
            if (listIteml.get(i).getText().equalsIgnoreCase(value)) {
                element = listIteml.get(i).getText();
                System.out.println(listIteml.get(i).getText());
                break;
            }
        }
        return element;
    }
    public   void getLinkValue( String value) throws InterruptedException {
        waitAndClick(driver.findElement(By.partialLinkText(returnWebElement(value))));

    }


    public void ContactUsFormFill () throws InterruptedException {
        getLinkValue("צרו קשר");
        FooterPage.sendKeys(contactFirstName,"Test");
        FooterPage.sendKeys(contactLastName, "Test");
        FooterPage.sendKeys(contactEmail, "Test@gmail.com");
        Select mySelection = new Select(contactTopicDropDownMenu);
        mySelection.selectByValue("ביטול הזמנה");
        FooterPage.sendKeys(contactComment,"Test Test Test");



    }


    public void footerLinkTest () throws InterruptedException {
        getLinkValue("המחירים באתר אינם כוללים דמי משלוח");
        Assert.assertEquals(getTitle(),"המחירים באתר אינם כוללים דמי משלוח");
        Assert.assertEquals(getTitle(),"המחירים באתר אינם כוללים דמי משלוח");

    }

    public String getTitle (){
        return title.getText();




    }





}
