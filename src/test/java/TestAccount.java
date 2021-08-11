import PageObjetcts.HeaderPage;
import PageObjetcts.LoginPage;
import PageObjetcts.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestAccount extends BaseClass{

    @Description("Validate test loging was successful")
    @Test(description = "Test Login successful")
    public void  Test_Login_Successful(){
        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        String username = "tattiana.alfarocastaneda@ucreativa.com";
        String password = "Testing2@";

        //Go to Login Page
        headerPage.clickOnMyAccount();
        headerPage.clickOnLoginButton();


        //Llenar formulario
        loginPage.EnterEmail(username);
        loginPage.EnterPassword(password);
        loginPage.ClickSubmitButton();


        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());

        }

    @Description("Testing Unsuccessful credentials")
    @Test(description = "Test Login Unsuccessful")
    public void  Test_Login_Unsuccessful() {
        LoginPage loginPage = new LoginPage(driver);

        String username = "tattiana.alfarocastaneda@ucreativa.com";
        String password = "Testing3@";
        String expectedMessage = "warning: no match for e-mail address and/or password.";

        loginPage.GoTo();
        loginPage.login(username, password);


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

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.GoTo();
        registerPage.FillForm(firstName, lastName, email,telephone, password);
        Assert.assertEquals(registerPage.getConfirmationMessage(), expectedMessage);
    }


}
