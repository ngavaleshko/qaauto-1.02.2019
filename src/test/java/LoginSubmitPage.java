import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginSubmitPage {
    WebDriver driver;

    WebElement passwordValidationMessage;
    WebElement emailValidationMessage;
    WebElement loginForm;

    public LoginSubmitPage(WebDriver driver) {
    this.driver=driver;
    initElements();
    }
    private void initElements(){
        loginForm = driver.findElement(By.xpath("//form[@class='login__form']"));
        passwordValidationMessage =driver.findElement (By.xpath("//div[@id='error-for-password']"));
        emailValidationMessage =driver.findElement (By.xpath("//div[@id='error-for-username']"));
    }

    public boolean isPageLoaded() {
            return loginForm.isDisplayed()
                    && driver.getCurrentUrl().contains("/login-submit")
                    && driver.getTitle().contains("Sign In to LinkedIn");
    }

    public String getPasswordValidationMessageText() {
        return passwordValidationMessage.getText();
    }
}
