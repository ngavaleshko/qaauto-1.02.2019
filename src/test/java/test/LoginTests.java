package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginSubmitPage;

public class LoginTests extends BaseTest {

    @DataProvider
    public Object[][] invalidData() {
        return new Object[][]{
                {"a@b.c", ""},
                {"", "Account0000"},
        };
    }

    @Test(dataProvider = "invalidData")
    public void negativeLoginTest(String userEmail, String userPassword) {

        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded.");

        landingPage.login (userEmail, userPassword);
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded.");
    }

    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                {"missnatalize@gmail.com", "Account0000"},
//                {"missNATALIze@gmail.com", "Account0000"},
//                {" missnatalize@gmail.com", "Account0000"}
        };
    }

    @Test(dataProvider = "validData")
    public void successfulLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded.");

        HomePage homePage = landingPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page did not load after Login.");
    }


    @DataProvider
    public Object[][] invalidDataAndMessage() {
        return new Object[][]{
                {"missnatalize@gmail.com", "4233666675", "Hmm, that's not the right password. Please try again or request a new one.","" },
                {"missNATALIze1@gmail.com", "Account0000","","Hmm, we don't recognize that email. Please try again."},

        };
    }

    @Test(dataProvider = "invalidDataAndMessage")
    public void negativeLoginReturnToTest(String userEmail,
                                          String userPassword,
                                          String passwordValidationMessage,
                                          String emailValidationMessage) {

        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded.");

      LoginSubmitPage loginSubmitPage = landingPage.login(userEmail, userPassword);

        Assert.assertTrue(loginSubmitPage.isPageLoaded(),
                "Home page did not load after Login.");

        Assert.assertEquals(loginSubmitPage.getPasswordValidationMessageText(),
                passwordValidationMessage,
                "Wrong Validation message for password field ");

        Assert.assertEquals(loginSubmitPage.getEmailValidationMessageText(),
                emailValidationMessage,
                "Wrong Validation message for email field ");
    }
}