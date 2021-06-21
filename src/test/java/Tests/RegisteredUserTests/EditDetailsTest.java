package Tests.RegisteredUserTests;

import Pages.RegisteredUserPages.EditDetailsPage;
import Pages.RegisteredUserPages.SignUpPage;
import Tests.MainTest;
import org.testng.annotations.Test;

public class EditDetailsTest extends MainTest {

    @Test
    public void editDetailsTesting() throws InterruptedException {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUp();
        Thread.sleep(5000);
        EditDetailsPage editDetailsPage = new EditDetailsPage(driver);
        editDetailsPage.editDetailsTest();
    }
}
