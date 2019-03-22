package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Object class for Loging Submit page
 */
public class LoginSubmitPage extends BasePage  {

    @FindBy(xpath ="//form[@class='login__form']")
    private WebElement loginForm;

    @FindBy (xpath = "//div[@id='error-for-password']")
    private WebElement passwordValidationMessage;

    @FindBy (xpath = "//div[@id='error-for-username']")
    private WebElement emailValidationMessage;


    /**
     * Constructor for Loging Submit Page
     * @param driver WebDriver instance from BaseTest.
     */
    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Method that check if page is load.
     * @return true/false
     */
    public boolean isPageLoaded() {
            return loginForm.isDisplayed()
                    && driver.getCurrentUrl().contains("/login-submit")
                    && driver.getTitle().contains("Sign In to LinkedIn");
    }

    /**
     * Method that return message
     * @return me
     */
    public String getPasswordValidationMessageText() {
        return passwordValidationMessage.getText();
    }

    public String getEmailValidationMessageText() {
        return emailValidationMessage.getText();
    }
}
