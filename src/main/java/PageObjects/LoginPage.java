package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //Elements
    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By submitButtonSelector = By.xpath("//input[@value='Login' and @type ='submit']");

    public LoginPage(WebDriver _driver) {
        this.driver = _driver;
    }

    public void EnterEmail(String email){
        driver.findElement(emailInputLocator).sendKeys(email);
    }

    public void EnterPassword(String password){
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void ClickSubmitButton(){
        driver.findElement(submitButtonSelector).click();
    }

    public void login(String username, String password){
        driver.findElement(emailInputLocator).sendKeys(username);
        driver.findElement(passwordInputLocator).sendKeys(password);
        driver.findElement(submitButtonSelector).click();
    }

    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnMyAccount();
        headerPage.clickOnLoginButton();
    }
}
