package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class RequestPasswordResetPage extends BasePage  {

    @FindBy(xpath = "//*[@id='username']")
    private WebElement userEmailField;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement findAccountBtn;

//    @FindBy (xpath ="//a[contains(text(),'Reset my password')]")
//    private WebElement resetMyPasswordUrl;


    public RequestPasswordResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean isPageLoaded() {
        return findAccountBtn.isDisplayed()
                && driver.getCurrentUrl().contains("/request-password-reset")
                && driver.getTitle().equals("Reset Password | LinkedIn");
    }

    public PasswordResetSubmitPage findAccount(String userEmail) {
        userEmailField.sendKeys(userEmail);

        String messageSubject = "password";
        String messageTo = userEmail;
        String messageFrom = "linkedin";

        GMailService gMailService = new GMailService();
        gMailService.connect();

        findAccountBtn.click();

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);

        resetPasswordUrl = StringUtils.substringBetween(message,"href=\"",
                "\" style=\"cursor:pointer;color:#008CC9;-webkit-text-size-adjust:100%;display:inline-block;text-decoration:none;-ms-text-size-adjust:100%;\">Reset my password");
        resetPasswordUrl.replace("amp;", "");
        return new PasswordResetSubmitPage(driver);


    }
}
