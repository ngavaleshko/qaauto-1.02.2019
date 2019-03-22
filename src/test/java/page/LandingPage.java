package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Page Object class  for Landing page (переменные классы методы)
 */
public class LandingPage extends BasePage  {

    @FindBy (xpath ="//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy (xpath = "//input[@id='login-email']" )
    private WebElement userEmailField;

    @FindBy (xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy (xpath = "//*[@class='link-forgot-password']")
    private  WebElement forgotPasswordLink;

    /**
     * Constructor for Landing Page.
     * @param driver  - WebDriver instance from BaseTest.
     */
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     *Generic method
     * @param userEmail Variations of Linkedin User Email  for testing reasons
     * @param userPassword Variations of Linkedin User Passwords  for testing reasons
     * @param <T> Generic method - checks what page is return
     * @return return result depending from T
     */
    public <T> T login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        if (driver.getCurrentUrl().contains("/feed/")) {
            return (T) new HomePage(driver);
        }
        if (driver.getCurrentUrl().contains("/login-submit")) {
            return (T) new LoginSubmitPage(driver);
        }
        else{
            return (T) new LandingPage(driver);
        }
    }


    /**
     * Method that check if page is load.
     * @return true/false
     */
    public boolean isPageLoaded() {
        return signInButton.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().equals("LinkedIn: Log In or Sign Up");
    }

    /**
     * @return method for clicking the link: Forgot password
     */
    public RequestPasswordResetPage clickOnForgotPasswordBtn() {
        forgotPasswordLink.click();
        return new RequestPasswordResetPage(driver);
    }
}

