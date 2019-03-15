package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class RequestPasswordResetPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='username']")
    private WebElement userEmailField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement findAccountBtn;

    public RequestPasswordResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return findAccountBtn.isDisplayed()
                && driver.getCurrentUrl().contains("/request-password-reset")
                && driver.getTitle().equals("Reset Password | LinkedIn");
    }

    public void findAccount(String userEmail) {
        userEmailField.sendKeys(userEmail);


        String messageSubject = "here's the link to reset your password";
        String messageTo = userEmail;
        String messageFrom = "security-noreply@linkedin.com";

        GMailService gMailService = new GMailService();
        gMailService.connect();

        findAccountBtn.click();

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);

        String resetPasswordUrl = null;// todo
                driver.get(resetPasswordUrl)

    }
}
