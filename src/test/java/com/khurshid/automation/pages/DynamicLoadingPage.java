package com.khurshid.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {

    private WebDriver driver;

    private By startButton = By.cssSelector("#start button");
    private By loadingText = By.id("loading");
    private By finishText = By.id("finish");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStart() {
        driver.findElement(startButton).click();
    }

    public By getFinishTextLocator() {
        return finishText;
    }
}
