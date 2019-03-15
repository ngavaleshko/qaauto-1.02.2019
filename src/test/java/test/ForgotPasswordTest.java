package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class ForgotPasswordTest extends BaseTest {

    @Test
    public void forgotPasswordTest() {
        String userEmail = "missnatalize@gmail.com";

        RequestPasswordResetPage requestPasswordResetPage = landingPage.clickOnForgotPasswordBtn();

        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(),
                "Request PasswordReset Page did not load.");

            requestPasswordResetPage.findAccount(userEmail);

//        RequestSubmissionIdPage requestSubmissionIdPage = new RequestSubmissionIdPage;
//        Assert.assertTrue(requestSubmissionIdPage.isPageLoaded(),
//                "Request Submission Id Page did not load.");
//
//        PasswordResetSubmitPage passwordResetSubmitPage = requestSubmissionIdPage.clickOnResetPasswordSubmitButton();
//        Assert.assertTrue(requestSubmissionIdPage.isPageLoaded();
//                "Password Reset SubmitPage did not load.");
    }
}





