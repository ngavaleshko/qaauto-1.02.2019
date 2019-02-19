import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void negativeLoginTest() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded.");

        landingPage.login("a@b.c", "");
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded.");
    }

    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                {"missnatalize@gmail.com", "Account0000"},
                {"missNATALIze@gmail.com", "Account0000"},
                {" missnatalize@gmail.com", "Account0000"}
        };
    }

    @Test(dataProvider = "validData")
    public void successfulLoginTest(String userEmail, String userPassword) {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded.");

        landingPage.login(userEmail, userPassword);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page did not load after Login.");
    }



    @Test
//    Correct login and incorrect password
    public void negativeTest2() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded.");

        landingPage.login("missnatalize@gmail.com", "rfgyiefgl");

        GuestHome guestHome = new GuestHome(driver);
        Assert.assertTrue(guestHome.isPageLoaded(),
                "GuestHome page is not loaded.");
    }

    @Test
//    incorrect phone number and incorrect password
    public void negativeTest3() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded.");

        landingPage.login("1234", "1234");
        GuestHome guestHome = new GuestHome(driver);
        Assert.assertTrue(guestHome.errorPhoneMessage(),
                "Phone Error message is not correct");
    }

    @Test
//    country
    public void negativeLoginReturnToTest() {

        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded.");

        landingPage.login("missnatalize@gmail.com", "4233666675");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(),
                "Home page did not load after Login.");

        Assert.assertEquals(loginSubmitPage.getPasswordValidationMessageText(),
                "Hmm, that's not the right password. Please try again or request a new one.",
                "Wrong Validation message for password fiel ");

    }
}