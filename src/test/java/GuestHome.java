import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GuestHome {

    private WebDriver driver;

    private WebElement errorMessage;
    private WebElement errorPhoneMessage;

    public GuestHome(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        errorMessage = driver.findElement(By.id("error-for-password"));
        errorPhoneMessage = driver.findElement(By.id("error-for-username"));
    }

    public boolean errorPhoneMessage(){
        String actualString = errorPhoneMessage.getText();
        return actualString.contains("and your country code.");
    }

    public boolean isPageLoaded() {
        return errorMessage.isDisplayed()
                && driver.getCurrentUrl().contains("GUEST_HOME")
                && driver.getTitle().contains("Sign In to LinkedIn");
    }
}