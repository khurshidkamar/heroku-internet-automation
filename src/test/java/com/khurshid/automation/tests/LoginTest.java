package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.LoginPage;
import com.khurshid.automation.pages.SecureAreaPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    void validLoginTest() {
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tomsmith", "SuperSecretPassword!");

        SecureAreaPage secureAreaPage = new SecureAreaPage(driver);
        assertTrue(
                secureAreaPage.getSuccessMessage().contains("You logged into a secure area"),
                "Login should be successful"
        );
    }

    @Test
    void invalidLoginTest() {
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalidUser", "invalidPass");

        assertTrue(
                loginPage.getFlashMessage().contains("Your username is invalid"),
                "Error message should be displayed"
        );
    }
}