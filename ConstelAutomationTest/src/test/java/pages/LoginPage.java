package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToLoginPage(String url) {
        driver.get(url);
    }

    public void login(String email, String password) {
        By emailLocator = By.id("email");
        By passwordLocator = By.id("password");
        By loginButtonLocator = By.id("loginSubmitBtn");

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
        emailInput.sendKeys(email);
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        passwordInput.sendKeys(password);
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
        loginButton.click();
    }

    public boolean isLoginPageDisplayed() {
        By loginContainer = By.className("login");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginContainer)).isDisplayed();
    }
}
