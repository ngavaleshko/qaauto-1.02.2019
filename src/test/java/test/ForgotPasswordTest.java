package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CheckpointPage;
import page.RequestPasswordResetPage;

public class ForgotPasswordTest extends BaseTest {



    @DataProvider
    public Object[][] validEmail() {
        return new Object[][]{
                {"missnatalize@gmail.com"}
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

        RequestSubmissionIdPage requestSubmissionIdPage=new RequestSubmissionIdPage
        }

    }

