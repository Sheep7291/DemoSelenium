package tests.scenario;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.base.BaseTestConfiguration;
import tests.page.loginPage.Start;
import tests.page.products.Products;

public class TestLoginPage extends BaseTestConfiguration {

    @Test(priority = 2, description = "Test nieudanego logowania")
    @Description("Scenariusz niepoprawnego zalogowania do aplikacji")
    public void testValidCredentials(){
        var page = Start.startPage(driver);
        page.openStartPage()
                .typeInUsernameInput("standard_user")
                .typeInPasswordInput("test")
                .clickLoginButton()
                .checkLoginError();
    }

    @Test(priority = 1, description = "Test poprawnego logowania")
    @Description("Scenariusz poprawnego zalogowania do aplikacji")
    public void testSuccesfulLogin(){
        var page = Start.startPage(driver);
        page.openStartPage()
                .typeInUsernameInput("standard_user")
                .typeInPasswordInput("secret_sauce")
                .clickLoginButton()
                .checkCorrectLinkAfterLogin();
    }

    @Test(priority = 1, description = "Test dodawania produktów do koszyka")
    @Description("Scenariusz dodania produktów, usunięcia ich oraz sprawdzenie zgodności koszyka")
    public void testAddAndRemoveElementsToCart(){
        var page = Start.startPage(driver);
        page.openStartPage()
                .typeInUsernameInput("standard_user")
                .typeInPasswordInput("secret_sauce")
                .clickLoginButton()
                .checkCorrectLinkAfterLogin();

        var products = Products.productsPage(driver);
        products.addProductToCart("Sauce Labs Backpack")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .addProductToCart("Sauce Labs Bike Light")
                .addProductToCart("Sauce Labs Fleece Jacket")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .removeProductFromCart("Sauce Labs Bolt T-Shirt")
                .validateCartItems();
    }
}
