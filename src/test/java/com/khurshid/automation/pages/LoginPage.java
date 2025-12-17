package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By flashMessage = By.id("flash");

    public LoginPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
    }

    public void enterUsername(String username) {
        WebElement input = waitUtils.waitForVisibility(usernameInput);
        input.clear();
        input.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement input = waitUtils.waitForVisibility(passwordInput);
        input.clear();
        input.sendKeys(password);
    }

    public void clickLogin() {
        waitUtils.waitForClickable(loginButton).click();
    }

    public String getFlashMessage() {
        return waitUtils.waitForVisibility(flashMessage).getText();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
