package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

/**
 * Object class for Home Page
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavMenuItem;

    @FindBy(xpath = "//form[@id='extended-nav-search']//input")
    private WebElement searchField;

    /**
     * Constructor for Home Page.
     * @param driver  - WebDriver instance from BaseTest.
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method that check if page is load.
     * @return true/false
     */
    public boolean isPageLoaded() {
        return profileNavMenuItem.isDisplayed()
                && driver.getCurrentUrl().contains("/feed/")
                && driver.getTitle().contains("LinkedIn");
    }

    /**
     * Search method
     * @param searchTerm variable for searching
     * @return search page denending of search term
     */
    public SearchPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SearchPage(driver);
    }
}

