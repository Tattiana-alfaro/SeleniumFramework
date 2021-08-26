package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage_PageFactory {

    protected WebDriver driver;

    public BasePage_PageFactory(WebDriver _driver) {
        this.driver = _driver;
        PageFactory.initElements(driver, this);
    }
}
