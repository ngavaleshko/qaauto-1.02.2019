package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginSubmitPage {
    WebDriver driver;

    @FindBy(xpath ="//form[@class='login__form']")
    private WebElement loginForm;

    @FindBy (xpath = "//div[@id='error-for-password']")
    private WebElement passwordValidationMessage;

    @FindBy (xpath = "//div[@id='error-for-username']")
    private WebElement emailValidationMessage;


    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded() {
            return loginForm.isDisplayed()
                    && driver.getCurrentUrl().contains("/login-submit")
                    && driver.getTitle().contains("Sign In to LinkedIn");
    }

    public String getPasswordValidationMessageText() {
        return passwordValidationMessage.getText();
    }

    public String getEmailValidationMessageText() {
        return emailValidationMessage.getText();
    }
}
