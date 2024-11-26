package tests.page.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Products {
    private final WebDriver driver;
    private Integer productsInCart = 0;

    private Products(WebDriver driver){
        this.driver = driver;
    }

    public static Products productsPage(WebDriver driver) {
        return new Products(driver);
    }

    public Products addProductToCart(String productName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'inventory_item')]//div[@class='inventory_item_name' and contains(text(), '" + productName + "')]")
        ));
        WebElement addToCartButton = productContainer.findElement(By.xpath("//button[contains(text(), 'ADD TO CART')]"));
        addToCartButton.click();
        productsInCart = productsInCart +1;
        return this;
    }

    public Products removeProductFromCart(String productName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'inventory_item')]//div[@class='inventory_item_name' and contains(text(), '" + productName + "')]")
        ));
        WebElement addToCartButton = productContainer.findElement(By.xpath("//button[contains(text(), 'REMOVE')]"));
        addToCartButton.click();
        productsInCart = productsInCart -1;
        return this;
    }

    public Products validateCartItems(){
        WebElement cartInteger = driver.findElement(By.cssSelector("span.fa-layers-counter.shopping_cart_badge"));
        String cartValue = cartInteger.getText();
        Assert.assertEquals(cartValue, productsInCart.toString(), "Items in cart are valid, added products !== cart items");
        return this;
    }
}
