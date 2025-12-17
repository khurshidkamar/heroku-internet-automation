package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePage {

    private By startButton = By.cssSelector("#start button");
    private By loadingText = By.id("loading");
    private By finishText = By.id("finish");

    public DynamicLoadingPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
    }

    public void clickStart() {
        waitUtils.waitForClickable(startButton).click();
    }

    public String getFinishText() {
        return waitUtils.waitForPresenceAndVisible(finishText).getText();
    }
    public boolean isFinishTextDisplayed() {
        return !driver.findElements(finishText).isEmpty()
                && driver.findElement(finishText).isDisplayed();
    }
}
