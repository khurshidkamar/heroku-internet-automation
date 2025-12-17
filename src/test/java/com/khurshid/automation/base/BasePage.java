package com.khurshid.automation.base;

import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {


    protected WebDriver driver;
    protected WaitUtils waitUtils;
    protected Actions actions;

    public BasePage(WebDriver driver, WaitUtils waitUtils) {
        this.driver = driver;
        this.waitUtils = waitUtils;
        this.actions = new Actions(driver);
    }
}
