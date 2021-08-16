import PageObjetcts.SearchPage;
import org.testng.annotations.Test;

public class TestSearch extends BaseClass{

    @Test
    public void Validate_Search(){
        String searchCriteria = "Macbook";
        int expectedResult = 3;
        SearchPage searchPage = new SearchPage(driver);

        searchPage.searchByTextOnSearchBar(searchCriteria);
        searchPage.validateSearchURL(searchCriteria);
        searchPage.validateResultsDisplayed(expectedResult);
    }

    @Test
    public void Validate_Empty_Results(){
        String searchCriteria = "Star Wars";
        int expectedResult = 0;

        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchByTextOnSearchBar(searchCriteria);
        searchPage.validateResultsDisplayed(expectedResult);
    }
}
