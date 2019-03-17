package page;

import com.sun.net.httpserver.Authenticator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestPasswordResetPage {
    private WebDriver driver;

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

    public void findAccount(String userEmail) {
        userEmailField.sendKeys(userEmail);


        String messageSubject = "password";
        String messageTo = userEmail;
        String messageFrom = "linkedin";

        GMailService gMailService = new GMailService();
        gMailService.connect();

        findAccountBtn.click();

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);

        // String resetPasswordUrl =
        Pattern pattern = Pattern.compile("<a\\s+(?:[^>]*?\\s+)?href=([\"'])(.*?)\\1");
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            String resetPasswordUrl = (message.substring(matcher.start(), matcher.end())).replace("<a href=\"https//", "").replace("\"","");
            if (resetPasswordUrl.toLowerCase().contains("timetoken")) {
                System.out.println("The link is " + resetPasswordUrl);
                driver.get(resetPasswordUrl);
            }
        }

    }
}
