package Tests;

import Pages.FooterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class FooterTest extends MainTest {
    FooterPage FooterPage;

    @BeforeClass
    public void before() {
         FooterPage = new FooterPage(driver);
    }


    //    @Test
//    public void ContactUsFormFill () throws InterruptedException {
//        FooterPage.ContactUsFormFill();
//    }
//
//    @Test
//    public void footerLinkTest()throws InterruptedException {
//        FooterPage.footerLinkTest();
//
//    }
    @Test(dataProvider = "test-data")
    public void blabls(String expactedValue) throws InterruptedException {

        FooterPage.getLinkValue(expactedValue);
        String actuallVale = FooterPage.getTitle();

        Assert.assertEquals(actuallVale, expactedValue);

    }

    @DataProvider(name = "test-data")
    public Object[][] dataProvFunc() {
        return new Object[][]{
                {"המחירים באתר אינם כוללים דמי משלוח"}, {"שירות המשלוחים"}
        };
    }


}
