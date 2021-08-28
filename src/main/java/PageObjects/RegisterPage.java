package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class RegisterPage extends BasePage {


    public RegisterPage(WebDriver _driver) {
        super(_driver);
    }

    private By nameLocator = By.id("input-firstname");
    private By lastNameLocator = By.id("input-lastname");
    private By emailNameLocator = By.id("input-email");
    private By telephoneLocator = By.id("input-telephone");
    private By passwordLocator = By.id("input-password");
    private By confirmLocator = By.id("input-confirm");
    private By confirmRegisterMessageLocator = By.xpath("//div[@id='content']/h1");
    private By termCheckBoxLocator = By.name("agree");
    private By continueButtonLocator = By.xpath("//input[@value='Continue']");
    private By errorMessageLocator = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    public void FillForm(String firstName, String lastName, String email, String telephone, String password){
        driver.findElement(nameLocator).sendKeys(firstName);
        driver.findElement(lastNameLocator).sendKeys(lastName);
        driver.findElement(emailNameLocator).sendKeys(email);
        driver.findElement(telephoneLocator).sendKeys(telephone);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(confirmLocator).sendKeys(password);
        driver.findElement(termCheckBoxLocator).click();
        driver.findElement(continueButtonLocator).click();
    }

    public  String getConfirmationMessage(){
        return driver.findElement(confirmRegisterMessageLocator).getText();
    }

    public String getEmailAlreadyRegistered(){
        return  driver.findElement(errorMessageLocator).getText();
    }

    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnMyAccount();
        headerPage.clickOnRegisterButton();
    }


}
