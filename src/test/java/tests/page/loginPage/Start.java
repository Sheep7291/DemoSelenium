package tests.page.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Start {
   private final WebDriver driver;

   private Start(WebDriver driver){
       this.driver = driver;
   }

   public static Start startPage(WebDriver driver) {
       return new Start(driver);
   }

   public Start openStartPage(){
       driver.get("https://www.saucedemo.com/v1/");
       return this;
   }

   public Start typeInUsernameInput(String username){
       driver.findElement(By.cssSelector(Locators.USERNAME_INPUT.locator)).sendKeys(username);
       return this;
   }

   public Start typeInPasswordInput(String password){
       driver.findElement(By.cssSelector(Locators.PASSWORD_INPUT.locator)).sendKeys(password);
       return this;
   }

   public Start clickLoginButton(){
       driver.findElement(By.cssSelector(Locators.SUBMIT_LOGIN_BUTTON.locator)).click();
       return this;
   }

   public Start checkLoginError(){
       WebElement loginErrorElement = driver.findElement(By.cssSelector(Locators.LOGIN_ERROR_MESSAGE.locator));
       boolean loginErrorIsVisible = loginErrorElement.isEnabled();
       Assert.assertTrue(loginErrorIsVisible, "Login Error message isn't visible");
       return this;
   }

   public Start checkCorrectLinkAfterLogin(){
       String currentLink = driver.getCurrentUrl();
       Assert.assertEquals(currentLink, "https://www.saucedemo.com/v1/inventory.html", "Link after login is wrong");
       return this;
   }

   public enum Locators{
       USERNAME_INPUT("input[placeholder=Username]"),
       PASSWORD_INPUT("input[placeholder=Password]"),
       SUBMIT_LOGIN_BUTTON("input[value=LOGIN]"),
       LOGIN_ERROR_MESSAGE("h3[data-test='error']");

       final String locator;
       Locators(String locators){
           this.locator = locators;
       }
   }
}

