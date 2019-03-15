package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;

public class ForgotPasswordTest extends BaseTest {



    @DataProvider
    public Object[][] validEmail() {
        return new Object[][]{
                {"missnatalize@gmail.com"}
        };
    }
    public Object[][] newUserPassword() {
            return new Object[][]{
                    {"Account0000"}
            };
    }

    @Test (dataProvider = "validEmail")
    public void ForgotPasswordTest(String userEmail) throws InterruptedException {

        RequestPasswordResetPage requestPasswordResetPage = landingPage.clickOnForgotPasswordBtn();
        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(),
                "Request PasswordReset Page did not load.");

        CheckpointPage checkpointPage = requestPasswordResetPage.submitYourEmailOrPhone(userEmail);
        Thread.sleep(4000);
        Assert.assertTrue(checkpointPage.isPageLoaded(),
                "checkpoint Page did not load.");

        Thread.sleep(120000);

    }
        @Test (dataProvider = "newUserPassword")


        public void SecondPart(String newPasswordField)

        RequestSubmissionIdPage requestSubmissionIdPage = new RequestSubmissionIdPage;
        Assert.assertTrue(requestSubmissionIdPage.isPageLoaded(),
                "Request Submission Id Page did not load.");

        PasswordResetSubmitPage passwordResetSubmitPage = requestSubmissionIdPage.clickOnResetPasswordSubmitButton();
        Assert.assertTrue(requestSubmissionIdPage.isPageLoaded(),
                "Password Reset SubmitPage did not load.");
        }

    }

