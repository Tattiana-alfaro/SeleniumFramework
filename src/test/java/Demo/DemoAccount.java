package Demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoAccount {
    //Otro tipo de anotations y el driver manager.
    //Debemos agregar el driver manager.
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();

    }

    @Test
    public void test_capabilities(){
        String url = "https://demo.opencart.com/";
        ChromeOptions options = new ChromeOptions();//Manipular los capabilities del browser.
        options.addArguments("--window-size=1700,800");
        options.setAcceptInsecureCerts(true); //Que hacer cuando tiene que aceptar los certificados
        options.setHeadless(true);//Para correr una prueba que no levante UI
        // Tambien ser puede hacer como: options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void test_waits(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10); //Este es una forma de hacerlo esperar
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Esta es la otra.
        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
        driver.findElement(By.id("downloadButton")).click();

        boolean result = false;
        //Manejo de excepciones
        try {

        }catch (WebDriverException exception){
            System.out.println("Error: " + exception);
        }


    }
    @Test
    public void drag_and_drop(){
        ChromeOptions options = new ChromeOptions();//Manipular los capabilities del browser.
        options.addArguments("--window-size=1700,800");
        options.setHeadless(true);
        WebDriver driver = new ChromeDriver(options);


        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");

        Actions actions = new Actions(driver);


        WebElement box_01 = driver.findElement(By.xpath("//span[text()='Draggable 1']"));
        WebElement drop = driver.findElement(By.id("mydropzone"));
        //Point location = drop.getLocation();
        //actions.dragAndDrop(box_01, drop).release().build().perform();
        actions.dragAndDrop(box_01,drop).release().build().perform();


    }
}
