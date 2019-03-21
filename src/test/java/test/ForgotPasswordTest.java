package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class ForgotPasswordTest extends BaseTest {

    @Test
    public void forgotPasswordTest() {
        String userEmail = "signnow.tutorial@gmail.com";
        String newUserPassword = "Account0000";

        RequestPasswordResetPage requestPasswordResetPage = landingPage.clickOnForgotPasswordBtn();
        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(),
                "Request PasswordReset Page did not load.");

        PasswordResetSubmitPage passwordResetSubmitPage = requestPasswordResetPage.findAccount(userEmail);

        Assert.assertTrue(passwordResetSubmitPage.isPageLoaded(),
              "passwordResetSubmitPage did not load.");

        RequestSubmissionIdPage requestSubmissionIdPage = passwordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(requestSubmissionIdPage.isPageLoaded(),
                "RequestSubmissionIdPage did not load.");

        GoToHomePage goToHomePage = requestSubmissionIdPage.enterNewPassword(newUserPassword,newUserPassword);
        Assert.assertTrue(goToHomePage.isPageLoaded(),
                "goToHomePage did not load.");

        HomePage homePage= goToHomePage.returnToHomePage();
        Assert.assertTrue(homePage.isPageLoaded(),
        "YOU DID NOT GET HOME PAGE");
    }
}





