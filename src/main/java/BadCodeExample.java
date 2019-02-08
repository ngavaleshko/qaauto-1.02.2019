import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*Home Task #2:
Complete Google search scenario.
- Loop through List of WebElements in searchResultElements list
- Print text of each WebElement
- Print "searchTerm found" if "Selenium" is present in WebElement
- Print "searchTerm not found" if "Selenium" is not present in WebElement
*/
public class BadCodeExample {
    public static void main(String[] args) {
//        System.out.printf("Hello world!!!");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


//////        WebElement searchField = driver.findElement(By.name("q"));
//////        searchField.clear();
//////        searchField.sendKeys("selenium");

        String searchTerm = "Selenium";
        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        searchField.clear();
        searchField.sendKeys("searchTerm");
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> searchResultElements = driver.findElements(By.xpath("//div[@class='srg']/div"));
        System.out.println("Search results count: " + searchResultElements.size());

//for each Webelement in SearchResultElements print text
        for (WebElement searchResultElement : searchResultElements) {
            String searchResultElementText = searchResultElement.getText();
            System.out.println(searchResultElement.getText());
            if (searchResultElementText.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("searchTerm found".toUpperCase());
            } else {
                System.out.println("searchTerm not found");
            }
        }
    }
}