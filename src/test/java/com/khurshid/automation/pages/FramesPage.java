package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FramesPage extends BasePage {

    private By iframe = By.id("mce_0_ifr");
    private By textBox = By.id("tinymce");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void switchToIframe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }

    public void clearAndTypeText(String text) {
        driver.findElement(textBox).clear();
        driver.findElement(textBox).sendKeys(text);
    }

    public String getEditorText() {
        return driver.findElement(textBox).getText();
        }
    public boolean frameIsDisplayed(){
        return driver.findElement(By.id("tinymce")).isDisplayed();
    }
    public void switchBackToMainPage() {
        driver.switchTo().defaultContent();
    }
}
