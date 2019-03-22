package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Object class for all page () base class
 */
public class BasePage {
    protected WebDriver driver;
    protected static String resetPasswordUrl;
    protected void waitUntilElementsIsClickable(WebElement webElement, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait (driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    protected  void waitUntilElementsIsClickable (WebElement webElement){
        waitUntilElementsIsClickable(webElement, 5);
    }
    }
