import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {
    @Test
    public void negativeLoginTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
// LinkedIn: Log In or Sign Up  Assert.assertEquals(actual result, expected res);
        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign UpX", "login page title is wrong"

);
    }
}
