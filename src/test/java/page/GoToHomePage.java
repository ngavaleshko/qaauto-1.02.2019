package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoToHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement goToHomePageBtn;

    public boolean isPageLoaded() {
        return goToHomePageBtn.isDisplayed()
                && driver.getCurrentUrl().contains("password-reset-submit")
                && driver.getTitle().equals("You've successfully reset your password. | LinkedIn");
    }
}