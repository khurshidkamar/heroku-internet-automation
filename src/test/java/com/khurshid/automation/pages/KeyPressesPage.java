package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyPressesPage extends BasePage {

    private By inputField = By.id("target");
    private By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
    }

    public void pressKey(Keys key) {
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys(key);
    }

    public String getResultText() {
        waitUtils.waitForText(resultText, "You entered");
        return driver.findElement(resultText).getText();
    }
}
