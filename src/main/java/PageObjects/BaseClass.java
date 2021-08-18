package PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseClass extends PageObjectHandler{

    @BeforeTest
    public void beforeTest(){
        //System.out.println("*BeforeTest");
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browser){

        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;

            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

        }

        String URL = "https://demo.opencart.com/";

        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //
        //driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);//Scripts en correr
        //driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);//page Load
    }
    @AfterTest
    public void AfterTest(){
        //System.out.println("*AfterTest");
    }

    @AfterMethod
    public void AfterMethod(){
        //System.out.println("*AfterMethod");
        TakeScreenshot();
        driver.close();
        try {
            driver.quit();
        }catch (WebDriverException exception){
            System.out.println("Error quit browser:" + exception);
        }
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] TakeScreenshot(){
        return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }
}
