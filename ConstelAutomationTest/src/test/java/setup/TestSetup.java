package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverManager;

public class TestSetup {

    public static WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the testing environment
        initializeDriver();
        // You can add more setup steps if needed
    }

    @AfterClass
    public void tearDown() {
        // Clean up after test execution
        quitDriver();
        // You can add more teardown steps if needed
    }

    private void initializeDriver() {
        // Initialize WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = DriverManager.getDriver();
    }

    private void quitDriver() {
        // Quit the WebDriver instance
        DriverManager.quitDriver();
    }

    protected WebDriver getDriver() {
        // Return the WebDriver instance for test classes to use
        return driver;
    }
}
