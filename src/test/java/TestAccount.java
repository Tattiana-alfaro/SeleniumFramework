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

        String username = "tattiana.alfarocastaneda@ucreativa.com";
        String password = "Testing2@";

        //Go to Login Page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();

        //Llenar formulario
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login' and @type ='submit']")).click();

        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());

        }

    @Description("Testing Unsuccessful credentials")
    @Test(description = "Test Login Unsuccessful")
    public void  Test_Login_Unsuccessful() {

        String username = "tattiana.alfarocastaneda@ucreativa.com";
        String password = "Testing3@";
        String expectedMessage = "warning: no match for e-mail address and/or password.";

        //Go to Login Page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();

        //Llenar formulario
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login' and @type ='submit']")).click();

        WebElement warningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertTrue(warningMessage.isDisplayed());
        Assert.assertEquals(expectedMessage.toLowerCase().trim(), warningMessage.getText().toLowerCase().trim());
    }




}
