package PageObjetcts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchPage {

    private WebDriver driver;
    private By searchBarLocator = By.name("search");
    private By resultsLocator = By.cssSelector(".product-thumb");

    public SearchPage(WebDriver _driver) {
        this.driver = _driver;
    }

    public void searchByTextOnSearchBar(String text){
        driver.findElement(searchBarLocator).sendKeys(text, Keys.ENTER);
    }
    public void validateSearchURL(String text){
        Assert.assertTrue(driver.getCurrentUrl().contains("search=" + text));
    }

    public void validateResultsDisplayed(int expectedResult){
        Assert.assertEquals(getResults() , expectedResult,
                String.format("Expected %s results, but got %s", expectedResult, getResults() ));
    }

    public int getResults(){
        return driver.findElements(resultsLocator).size();
    }


}
