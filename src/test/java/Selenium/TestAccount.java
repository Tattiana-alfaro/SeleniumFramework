package Selenium;

import PageObjects.BaseClass;
import PageObjects.LoginPage;
import dataProviders.UsersProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pojo.UserAccount;

public class TestAccount extends BaseClass {
    public static final String ERROR_EMAIL_AND_PASSWORD_INVALID_MESSAGE = "warning: no match for e-mail address and/or password.";
    public By logOutButtonLocator = By.linkText("Logout");
    public By alertMessageLocator = By.xpath("//div[contains(@class, 'alert-danger')]");

    @Description("Validate test loging was successful")
    @Test(description = "Test Login successful")
    public void  Test_Login_Successful(){

        String username = "tattiana.alfarocastaneda@ucreativa.com";
        String password = "Testing2@";

        //Go to Login Page
        headerPage().clickOnMyAccount();
        headerPage().clickOnLoginButton();


        //Llenar formulario
        loginPage().EnterEmail(username);
        loginPage().EnterPassword(password);
        loginPage().ClickSubmitButton();


        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());

    }
    @Description("Validate test login with data")
    @Test (dataProvider = "getUsersData", dataProviderClass = UsersProvider.class)
    public void Test_Login_With_Data(UserAccount testUser){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.GoTo();
        loginPage.login(testUser.getEmail(), testUser.getPassword());

        if(testUser.isValidAccount())
            Assert.assertTrue(driver.findElement(logOutButtonLocator).isDisplayed());
        else
            Assert.assertEquals(ERROR_EMAIL_AND_PASSWORD_INVALID_MESSAGE.toLowerCase(), driver.findElement(alertMessageLocator).getText().toLowerCase().trim());
    }

    @Description("Testing Unsuccessful credentials")
    @Test(description = "Test Login Unsuccessful")
    public void  Test_Login_Unsuccessful() {

        String username = "tattiana.alfarocastaneda@ucreativa.com";
        String password = "Testing3@";
        String expectedMessage = "warning: no match for e-mail address and/or password.";

        loginPage().GoTo();
        loginPage().login(username, password);


        WebElement warningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertTrue(warningMessage.isDisplayed());
        Assert.assertEquals(expectedMessage.toLowerCase().trim(), warningMessage.getText().toLowerCase().trim());
    }
    @Description("Validate create new account")
    @Test(description = "Test create new account")
    public void Test_Create_New_Account(){
        String firstName = "testFirstName";
        String lastName = "testLastName";
        String email = "testAutomationFramewor@test.com";
        String telephone = "2122340";
        String password = "test1234@";
        String expectedMessage = "Your Account Has Been Created!";

        registerPage().GoTo();
        registerPage().FillForm(firstName, lastName, email,telephone, password);
        Assert.assertEquals(registerPage().getConfirmationMessage(), expectedMessage);
    }


}
