import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSearch extends BaseClass{

    @Test
    public void Validate_Search(){
        String searchCriteria = "Macbook";
        int expectedResult = 3;

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria, Keys.ENTER);

        Assert.assertTrue(driver.getCurrentUrl().contains("search=" + searchCriteria));
        List<WebElement> result = driver.findElements(By.cssSelector(".product-thumb"));

        Assert.assertEquals(result.size(), expectedResult,
                String.format("Expected %s results, but got %s", expectedResult, result.size() ));
    }



}
