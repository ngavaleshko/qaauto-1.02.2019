package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

import java.util.List;

public class SearchTests extends BaseTest {

    /**
     * Verify basic search functionality.
     * Scenario:
     * Implement basicSearchTest() Scenario.
     * - Open new Browser
     * - Navigate to http://www.linkedin.com
     * - Verify that Landing page is loaded
     * - Login with valid credentials
     * - Verify that Home page is loaded
     * - Search for "HR" search term
     * - Verify that Search page is loaded
     * - Verify that numbers of search results is 10
     * - Verify that each search result contains search term
     *
     * @throws InterruptedException
     */
    @Test
    public void basicSearchTest() throws InterruptedException {
        String userEmail = "missnatalize@gmail.com";
        String userPassword = "Account0000";
        String searchTerm = "HR";
//        int searchResultElements = 10;

        Assert.assertTrue(landingPage.isPageLoaded(),
                "Landing page is not loaded.");

        HomePage homePage = landingPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page did not load after Login.");

        SearchPage searchPage = homePage.search(searchTerm);
        Assert.assertTrue(searchPage.isPageLoaded(),
                "Search Page is not loaded.");

        Assert.assertEquals(searchPage.getSearchResultsCount(), 10,
                "Search result Count is wrong");
        List<String> searchResultsList = searchPage.getSearchResultsList();
        for (String searchResult : searchResultsList) {

            Assert.assertTrue(searchResult.contains(searchTerm),
                    "SearchTerm " + searchTerm + " not found in: \n" + searchResult);
        }
    }
}


//        List<WebElement> results = searchPage.searchResultElements;
//
//        JavascriptExecutor jsx = (JavascriptExecutor)driver;
//        jsx.executeScript("window.scrollBy(0,1750)", "");
//        Thread.sleep(4000);
//
//        Assert.assertEquals(results.size(),searchResultElements,"Numbers of search results isn't valid");
//
//        for (WebElement result : results) {
//            Assert.assertTrue(result.getText().toLowerCase().contains(searchTerm.toLowerCase()), "Result does not contain HR.");
//        }



