package Tests;

import Pages.FooterPage;
import Tests.GuestTests.FooterLinks;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class FooterTest extends MainTest {
    private FooterPage FooterPage;

    @BeforeClass
    public void before() {
        FooterPage = new FooterPage(driver);
    }

//    @Test(dataProviderClass = FooterLinks.class, dataProvider = "footer-links-and-links-title")
//    public void footerLinks(String linkText, String expectedTitle) {
//
//        FooterPage.getLinkValue(linkText);
//        String actualTitle = FooterPage.getTitle();
//
//        Assert.assertEquals(actualTitle, expectedTitle);
//    }
//
//    @Test(dataProviderClass = FooterLinks.class, dataProvider = "footer-by-links-and-links-title")
//    public void footerByLinks(String linkText, String expectedTitle) {
//
//        FooterPage.getLinkValue(linkText);
//        String actualTitle = FooterPage.getByTitle();
//
//        Assert.assertEquals(actualTitle, expectedTitle);
//    }
//
//
//    @Test
//    public void ContactUsFormFill(){
//        FooterPage.ContactUsFormFill();
//    }
//
//    @Test
//    public void QuestionsCheck() {
//        FooterPage.FrequentlyAskedQuestionsCheck();
//
//    }
    @Test
    public void emailConsent(){
        FooterPage.hpEmailSignUp();
    }
}
