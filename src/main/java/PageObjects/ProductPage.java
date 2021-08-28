package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    //elementos
    private String ProductTitleSelector = "//h1[text()='<name>']";
    private By ProductQuantityInputSelector = By.id("input-quantity");
    private By AddButtonSelector = By.id("button-cart");
    private By AlertSuccess = By.cssSelector(".alert-success");
    private By addProductToShoppingCartMessage = By.xpath("//div[@id='product-product']/div[1]");
    private By cartButtonLocator = By.xpath("//span[@id='cart-total']");
    private By viewCartLinkLocator = By.xpath("//*[@id='cart']/ul/li[2]/div/p/a[1]");
    private By currencyMenuOnHeaderLocator = By.xpath("//div[@class='btn-group']/button[@class='btn btn-link dropdown-toggle']");
    private By currencyEuroCurrencyLocator = By.xpath("//form[@id='form-currency']/div[@class='btn-group open']/ul/li[1]/button");
    private By currencyPoundSterlingCurrencyLocator = By.xpath("//form[@id='form-currency']/div[@class='btn-group open']/ul/li[2]/button");
    private By currencyUSDollarCurrencyLocator = By.xpath("//form[@id='form-currency']/div[@class='btn-group open']/ul/li[3]/button");
    private By currentProductPrice = By.xpath("//div[@id='content']/div/div[2]/ul[2]/li[1]/h2");

    public ProductPage(WebDriver _driver){
        super(_driver);
    }

    public boolean isTitleDisplayed(String name){
        return driver.findElement(By.xpath(ProductTitleSelector.replace("<name>", name))).isDisplayed();
    }
    public boolean isAddProductToShoppingCartMessage(){
        return driver.findElement(addProductToShoppingCartMessage).isDisplayed();
    }

    public void SetQuantity(int quantity){
        driver.findElement(ProductQuantityInputSelector).clear();
        driver.findElement(ProductQuantityInputSelector).sendKeys("" + quantity);
    }

    public void clickAddButton(){
        driver.findElement(AddButtonSelector).click();
    }

    public boolean isAlertSuccessDisplayed(){
        return driver.findElement(AlertSuccess).isDisplayed();
    }

    public void navigateToCartPage(){
        driver.findElement(cartButtonLocator).click();
        driver.findElement(viewCartLinkLocator).click();
    }
    public void changeCurrencyPriceToEuro(){
        driver.findElement(currencyMenuOnHeaderLocator).click();
        driver.findElement(currencyEuroCurrencyLocator).click();
    }
    public void changeCurrencyPriceToPoundSterling(){
        driver.findElement(currencyMenuOnHeaderLocator).click();
        driver.findElement(currencyPoundSterlingCurrencyLocator).click();
    }

    public void changeCurrencyPriceToUSDollar(){
        driver.findElement(currencyMenuOnHeaderLocator).click();
        driver.findElement(currencyUSDollarCurrencyLocator).click();
    }

    public double getCurrentProductPrice(String currency){
        return Double.parseDouble(driver.findElement(currentProductPrice).getText().replace(currency, "").replace(",", ""));
    }

}