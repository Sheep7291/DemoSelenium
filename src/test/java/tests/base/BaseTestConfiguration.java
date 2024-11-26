package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;
import java.util.Objects;

public class BaseTestConfiguration {
    protected WebDriver driver;

    @BeforeSuite
    public static void cleanAllureResults() {
        File resultsDir = new File("allure-results");
        if (resultsDir.exists()) {
            for (File file : Objects.requireNonNull(resultsDir.listFiles())) {
                file.delete();
            }
        }
    }

    @BeforeMethod
    public void initDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(5))
                .scriptTimeout(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        driver.quit();
    }
}
