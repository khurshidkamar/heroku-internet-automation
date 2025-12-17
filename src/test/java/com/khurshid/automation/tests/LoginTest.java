package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.LoginPage;
import com.khurshid.automation.pages.SecureAreaPage;
import com.khurshid.automation.testdata.LoginTestData;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    @Test
   public void validLoginTest() {
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver, waitUtils);
        loginPage.login(
                LoginTestData.VALID_USERNAME,
                LoginTestData.VALID_PASSWORD
        );

        SecureAreaPage secureAreaPage = new SecureAreaPage(driver, waitUtils);
        assertTrue(
                secureAreaPage.getSuccessMessage().contains("You logged into a secure area"),
                "Login should be successful"
        );
    }

    @Test
   public void invalidLoginTest() {
        driver.get("https://the-internet.herokuapp.com/login");

        LoginPage loginPage = new LoginPage(driver, waitUtils);
        loginPage.login(
                LoginTestData.INVALID_USERNAME,
                LoginTestData.INVALID_PASSWORD
        );

        assertTrue(
                loginPage.getFlashMessage().contains("Your username is invalid"),
                "Error message should be displayed"
        );
    }
}