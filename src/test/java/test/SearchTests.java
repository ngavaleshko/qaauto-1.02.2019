package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

import java.util.List;

public class SearchTests extends BaseTest {

    @Test
    public void basicSearchTest() throws InterruptedException {
        String userEmail = "missnatalize@gmail.com";
        String userPassword = "Account0000";
        String searchTerm = "HR";
        int searchResultElements = 8;

        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded.");

        HomePage homePage = landingPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page did not load after Login.");

        SearchPage searchPage = homePage.search(searchTerm);
        Assert.assertTrue(searchPage.isPageLoaded(),
                "Search Page is not loaded.");


        //List<WebElement> results = driver.findElements(By.xpath("//*[@class='search-result__wrapper']"));
        List<WebElement> results = searchPage.searchResultElements;
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(4000);
        Assert.assertEquals(results.size(),searchResultElements,"Numbers of search results isn't valid");

        for (WebElement result : results) {
            Assert.assertTrue(result.getText().contains("HR"), "Result does not contain HR.");
        }

    }

}
