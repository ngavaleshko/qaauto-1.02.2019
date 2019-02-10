import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {
    @Test
    public void negativeLoginTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
// LinkedIn: Log In or Sign Up  Assert.assertEquals(actual result, expected res);
        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up", "login page title is wrong");

        //        Verify that Login page URL is correct
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.linkedin.com/", "login page URL is wrong");

//        Verify that Login page has 'Sign In' button displayed
        WebElement signinButton = driver.findElement(By.id("login-submit"));
        if(signinButton.isDisplayed())
                {
                    System.out.println("signinButton is displayed");
                }
                else{
                    System.out.println("signinButton is not displayed");
                }
//        Enter 'a@b.c' into userEmail field
        WebElement loginField= driver.findElement(By.id("login-email"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys("missnatalize@gmail.com");
//        Enter '' into userPass field (means enter empty String)
        WebElement passwordField= driver.findElement(By.id("login-email"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("");

        WebElement Signin= driver.findElement(By.id("login-email"));
        Signin.click();

        String URL1 = driver.getCurrentUrl();
        Assert.assertEquals(URL1, "https://www.linkedin.com/", "login page URL is correct");

    }
}
