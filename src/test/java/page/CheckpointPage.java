package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckpointPage {
    private WebDriver driver;

    @FindBy(xpath ="//*[@id='resend-url']")
    private WebElement resendLinkButton;

    public CheckpointPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return resendLinkButton.isDisplayed()
                && driver.getCurrentUrl().contains("/checkpoint/");
//                && driver.getTitle().equals("Please check your mail for reset password link.  | LinkedIn");
    }
}
