package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import setup.TestSetup;

public class LoginTest extends TestSetup {

    @Test
    public void loginAndLogoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //I know that this data should be in other places, password should be in safe place, but I didn't have time to make this work as it should, sorry
        // Navigate to the login page
        loginPage.navigateToLoginPage("https://constel-social-network.vercel.app/");

        // Login
        loginPage.login("milosevic.edu@gmail.com", "constel123");

        // Test: Check if the user has successfully logged in, and he can see the Logout Button (later I remembered that I shouldn't have used logout button, but e.g. New Post card
        Assert.assertTrue(homePage.isLogoutButtonDisplayed(), "Logout button not displayed. Login failed.");

        // Click on the logout button
        homePage.clickLogoutButton();

        // Test: Check if the user has successfully logged out of the app
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page not displayed after logout.");
    }
}
