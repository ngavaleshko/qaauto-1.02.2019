package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetSubmitPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id ='reset-password-submit-button']")
    private WebElement resetPasswordSubmitButton;

    @FindBy(xpath = "//*[@id ='username']")
    private WebElement enterYourEmailOrPhone;

    public PasswordResetSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isPageLoaded() {
        return resetPasswordSubmitButton.isDisplayed()
                && driver.getCurrentUrl().contains("/password-reset-submit");
    }
}
