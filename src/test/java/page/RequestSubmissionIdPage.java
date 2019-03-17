package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestSubmissionIdPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\'newPassword\']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//*[@id=\'confirmPassword']")
    private WebElement newPasswordConfirmField;

    @FindBy(xpath = "//*[@id=\'reset-password-submit-button']")
    private WebElement resetPasswordSubmitButton;


    public RequestSubmissionIdPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return newPasswordField.isDisplayed()
                && driver.getCurrentUrl().contains("requestSubmissionId")
                && driver.getTitle().equals("Reset Password | LinkedIn");
    }

    public RequestSubmissionIdPage enterNewPassword(String newUserPassword, String newPasswordConfirm) {
        newPasswordField.click();
        newPasswordField.sendKeys(newUserPassword);
        newPasswordConfirmField.click();
        newPasswordConfirmField.sendKeys(newPasswordConfirm);
        resetPasswordSubmitButton.submit();
        return new RequestSubmissionIdPage(driver);
    }
}
