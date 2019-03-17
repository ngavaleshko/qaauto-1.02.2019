package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetSubmitPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id ='resend-url']")
    private WebElement resendLinkBtn;


    public PasswordResetSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isPageLoaded() {
        return resendLinkBtn.isDisplayed()
                && driver.getCurrentUrl().contains("/request-password-reset-submit");
    }
}
