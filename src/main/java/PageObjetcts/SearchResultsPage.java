package PageObjetcts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchResultsPage extends BaseClass{

    private WebDriver driver;
    private By searchBarLocator = By.name("search");
    private By resultsLocator = By.cssSelector(".product-thumb");
    private By noProdMessageLocator = By.id("content");
    private static final String ERROR_MESSAGE_NO_DISPLAYED = "There is no product that matches the search criteria.";


    public SearchResultsPage(WebDriver _driver) {
        this.driver = _driver;
    }

    public void searchByTextOnSearchBar(String text){
        driver.findElement(searchBarLocator).sendKeys(text, Keys.ENTER);
    }
    public void validateSearchURL(String text){
        Assert.assertTrue(driver.getCurrentUrl().contains("search=" + text));
    }

    public void validateResultsDisplayed(int expectedResult){
        Assert.assertEquals(getResultsCount() , expectedResult,
                String.format("Expected %s results, but got %s", expectedResult, getResultsCount() ));
    }

    public void validateNoMatchSearchCriteria(){
        String actualErrorMessage = driver.findElement(noProdMessageLocator).getAttribute("innerHTML");
        Assert.assertTrue(actualErrorMessage.contains(ERROR_MESSAGE_NO_DISPLAYED));

    }

    public int getResultsCount(){
        return driver.findElements(resultsLocator).size();
    }


}
