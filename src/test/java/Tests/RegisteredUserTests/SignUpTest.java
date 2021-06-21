package Tests.RegisteredUserTests;

import Pages.RegisteredUserPages.SignUpPage;
import Tests.MainTest;
import org.testng.annotations.Test;

public class SignUpTest extends MainTest {
    @Test
    public void signUpTesting() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUp();
    }
}
