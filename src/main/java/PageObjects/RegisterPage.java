package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BaseClass{
    private WebDriver driver;

    public RegisterPage(WebDriver _driver) {
        this.driver = _driver;
    }

    private By nameLocator = By.name("firstName");
    private By lastNameLocator = By.name("lastname");
    private By emailNameLocator = By.name("email");
    private By telephoneLocator = By.name("telephone");
    private By passwordLocator = By.name("password");
    private By confirmLocator = By.name("confirm");
    private By confirmRegisterMessageLocator = By.xpath("//div[@id='content]/h1");
    private By termCheckBoxLocator = By.name("agree");
    private By continueButtonLocator = By.xpath("//input[@value='Continue'");

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

    public void GoTo(){
        headerPage().clickOnMyAccount();
        headerPage().clickOnRegisterButton();
    }
}
