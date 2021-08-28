package Selenium;

import PageObjects.*;
import dataProviders.ProductProvider;
import dataProviders.RegisterUserProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Products;

public class AddToCartTests extends BaseClass {
    @Description("Validate that add to cart is working")
    @Test
    public void Test_Add_To_Cart_Functionality(){
        /**
         * opciones de navegación
         * 1. search
         * 2. home add to cart  *****
         * 3. home -> Product Page -> add to cart
         * 4. contruir la URL
         * */
        int quantity = 5;

        HeaderPage headerPage = new HeaderPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        String name = homePage.selectFirstProductAndGetName();
        Assert.assertTrue(productPage.isTitleDisplayed(name));
        productPage.SetQuantity(quantity);
        productPage.clickAddButton();
        Assert.assertTrue(productPage.isAlertSuccessDisplayed());
        headerPage.clickOnCartButton();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(shoppingCartPage.isProductNameDisplayed(name), "Title was not displayed");
        Assert.assertEquals(shoppingCartPage.getProductQuantity(), quantity, "Quantity is not matching");

    }

    @Description("Validate several items added to the cart")
    @Test
    public void Test_Several_Items_Added_To_The_Cart(){
        homePage().selectProductByName("MacBook");
        productPage().SetQuantity(2);
        productPage().clickAddButton();
        homePage().GoTo();
        homePage().selectProductByName("iPhone");
        productPage().SetQuantity(5);
        productPage().clickAddButton();
        headerPage().clickOnCartButton();
        Assert.assertEquals(shoppingCartPage().getAmountOfShoppingCartRows(), 2, "Expected to get 2 rows");
    }

    /**
     * Caso #2
     *
     * Agregar una orden de compras utilizando la búsqueda para encontrar el producto.
     * Ir al sitio web.
     * Buscar un producto (Macbook)
     * Hacer click en el producto.
     * Agregar el producto al carrito de compras.
     * Verificar el mensaje de éxito.
     * Ir al carrito de compras
     * Verificar que el producto no se pueda agregar!
     */
    @Description("Validate add a product from search page then validate product are not available")
    @Test
    public void Test_Add_To_Cart_From_Search(){
        String expectedErrorMessage = "Products marked with *** are not available in the desired quantity or not in stock!\n" +
                "×";
        String searchCriteria = "MacBook Air";
        searchResultsPage().searchByTextOnSearchBar(searchCriteria);
        homePage().selectProductByName(searchCriteria);
        productPage().clickAddButton();
        Assert.assertTrue(productPage().isAddProductToShoppingCartMessage());
        productPage().navigateToCartPage();
        Assert.assertTrue(shoppingCartPage().isCheckoutCartMessageDisplayed());
        Assert.assertEquals(shoppingCartPage().getCheckoutCartMessageMessage(), expectedErrorMessage);
    }

    /**
     * Caso #3
     * Verificar el precio de un producto en las distintas monedas.
     * Dado un json con productos y precios en distintas monedas.
     * Ir a la página del producto.
     * Verificar el precio de cada producto en las distintas monedas.
     */
    @Description("Validate product price currency")
    @Test (dataProvider = "getProductsDataFromJson", dataProviderClass = ProductProvider.class)
    private void Test_Product_Price_Currency(Products products){
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        searchResultsPage.searchByTextOnSearchBar(products.getProductName());
        homePage.selectProductByName(products.getProductName());
        productPage.changeCurrencyPriceToEuro();
        Assert.assertEquals(productPage.getCurrentProductPrice("€"),products.getEuroPrice());
        productPage.changeCurrencyPriceToPoundSterling();
        Assert.assertEquals(productPage.getCurrentProductPrice("£"),products.getPoundSterlingPrice());
        productPage.changeCurrencyPriceToUSDollar();
        Assert.assertEquals(productPage.getCurrentProductPrice("$"), products.getDollarPrice());
    }
}