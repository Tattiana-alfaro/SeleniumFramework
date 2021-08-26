package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PageFactory extends BasePage_PageFactory{


    //Elements
    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Login' and @type ='submit']")
    WebElement submitButton;

    @FindBy(linkText = "Logout")
    WebElement logOutButton;

    @FindBy(xpath = "//div[contains(@class, 'alert-danger')]")
    WebElement alertMessage;


    public LoginPage_PageFactory(WebDriver _driver) {
        super(_driver);
    }


    public void EnterEmail(String email){
        emailInput.sendKeys(email);
    }

    public void EnterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void ClickSubmitButton(){
        submitButton.click();
    }

    public boolean isLogOutButtonDisplayed(){
        return logOutButton.isDisplayed();
    }

    public String getTextInAlertMessage(){
        return  alertMessage.getText().toLowerCase().trim();
    }


    public void login(String username, String password){
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnMyAccount();
        headerPage.clickOnLoginButton();
    }
}
