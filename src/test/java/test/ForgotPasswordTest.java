package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class ForgotPasswordTest extends BaseTest {

    @Test
    public void forgotPasswordTest() {
        String userEmail = "signnow.tutorial@gmail.com";

        RequestPasswordResetPage requestPasswordResetPage = landingPage.clickOnForgotPasswordBtn();

        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(),
                "Request PasswordReset Page did not load.");

            requestPasswordResetPage.findAccount(userEmail);

        PasswordResetSubmitPage passwordResetSubmitPage = new PasswordResetSubmitPage(driver);

         Assert.assertTrue(passwordResetSubmitPage.isPageLoaded(),
              "passwordResetSubmitPage did not load.");


//        String newUserPassword = "Account0000";
//        String newPasswordConfirm = "Account0000";
//
//        RequestSubmissionIdPage requestSubmissionIdPage =new RequestSubmissionIdPage(driver);
//        Assert.assertTrue(requestSubmissionIdPage.isPageLoaded(),
//                "RequestSubmissionIdPage did not load.");
//
//        GoToHomePage goToHomePage = RequestSubmissionIdPage.enterNewPassword(newUserPassword,newPasswordConfirm);
//
//        Assert.assertTrue(goToHomePage.isPageLoaded(),
//                "goToHomePage did not load.");


    }
}





