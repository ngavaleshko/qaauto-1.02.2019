package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestPasswordResetPage {


    private WebDriver driver;

    @FindBy(xpath = "//*[@id ='reset-password-submit-button']")
    private WebElement findAccountButton;

    @FindBy(xpath = "//*[@id ='username']")
    private WebElement enterYourEmailOrPhone;

    public RequestPasswordResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isPageLoaded() {
        return findAccountButton.isDisplayed()
                && driver.getCurrentUrl().contains("/request-password-reset")
                && driver.getTitle().equals("Reset Password | LinkedIn");
    }

    public CheckpointPage submitYourEmailOrPhone(String userEmail) {
        enterYourEmailOrPhone.click();
        enterYourEmailOrPhone.sendKeys(userEmail);
        enterYourEmailOrPhone.submit();
        return new CheckpointPage(driver);
    }
}
