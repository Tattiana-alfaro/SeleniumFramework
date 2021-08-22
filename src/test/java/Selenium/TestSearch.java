package Selenium;

import PageObjects.BaseClass;
import PageObjects.BasePage;
import PageObjects.SearchResultsPage;
import dataProviders.SearchProvider;
import org.testng.annotations.Test;
import pojo.SearchData;


public class TestSearch extends BaseClass {

    private String testData;
    private String expectedResult;

    @Test
    public void Validate_Search(){
        String searchCriteria = "Macbook";
        int expectedResult = 3;
        searchResultsPage().searchByTextOnSearchBar(searchCriteria);
        searchResultsPage().validateSearchURL(searchCriteria);
        searchResultsPage().validateResultsDisplayed(expectedResult);
    }

    @Test
    public void Validate_Empty_Results(){
        String searchCriteria = "Star Wars";
        int expectedResult = 0;

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.searchByTextOnSearchBar(searchCriteria);
        searchResultsPage.validateResultsDisplayed(expectedResult);
    }

    @Test(dataProvider = "getSearchDataFromJson", dataProviderClass = SearchProvider.class)
    public void Test_Search_WithData(SearchData testData){
        searchResultsPage().searchByTextOnSearchBar(testData.getSearchCriteria());

        if(testData.getExpectedResults() > 0) {
            searchResultsPage().validateResultsDisplayed(testData.getExpectedResults());
        }else{
            searchResultsPage().validateNoMatchSearchCriteria();
        }
        this.testData = testData.getSearchCriteria();
        this.expectedResult = String.valueOf(testData.getExpectedResults());
    }
}
