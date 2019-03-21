package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoToHomePage extends BasePage {

    public GoToHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement goToHomePageBtn;

    public boolean isPageLoaded() {
        return goToHomePageBtn.isDisplayed()
                && driver.getCurrentUrl().contains("password-reset-submit")
                && driver.getTitle().equals("You've successfully reset your password. | LinkedIn");
    }

    public HomePage returnToHomePage() {
        goToHomePageBtn.click();
        return new HomePage(driver);
    }
}