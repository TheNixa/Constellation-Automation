package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isLogoutButtonDisplayed() {
        By logoutButtonLocator = By.xpath("/html/body/article/section/header/div[2]/div/div[2]/a");
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButtonLocator));
        return logoutButton.isDisplayed();
    }

    public void clickLogoutButton() {
        By logoutButtonLocator = By.xpath("/html/body/article/section/header/div[2]/div/div[2]/a");
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logoutButtonLocator));
        logoutButton.click();
    }
}
