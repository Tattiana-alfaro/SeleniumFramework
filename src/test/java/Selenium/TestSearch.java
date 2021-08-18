package Selenium;

import PageObjetcts.BaseClass;
import PageObjetcts.SearchResultsPage;
import dataProviders.SearchProvider;
import io.qameta.allure.Attachment;
import org.testng.annotations.Test;
import pojo.SearchData;

import java.io.IOException;

public class TestSearch extends BaseClass {

    private String testData;
    private String expectedResult;

    @Test
    public void Validate_Search(){
        String searchCriteria = "Macbook";
        int expectedResult = 3;
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.searchByTextOnSearchBar(searchCriteria);
        searchResultsPage.validateSearchURL(searchCriteria);
        searchResultsPage.validateResultsDisplayed(expectedResult);
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
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.searchByTextOnSearchBar(testData.getSearchCriteria());

        if(testData.getExpectedResults() > 0) {
            searchResultsPage.validateResultsDisplayed(testData.getExpectedResults());
        }else{
            searchResultsPage.validateNoMatchSearchCriteria();
        }
        this.testData = testData.getSearchCriteria();
        this.expectedResult = String.valueOf(testData.getExpectedResults());


    }

    @Attachment(value = "TestData", type = "text/plain", fileExtension = ".txt")
    public String PrintTestData() throws IOException {
        //File file = new File();
        return "Search Criteria used: " + testData + "Expected results: " + expectedResult;
    }
}
