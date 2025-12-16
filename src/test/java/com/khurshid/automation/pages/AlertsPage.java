package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage {

    private By jsAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private By resultText = By.id("result");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void openJsAlert() {
        driver.findElement(jsAlertButton).click();
    }

    public void openJsConfirm() {
        driver.findElement(jsConfirmButton).click();
    }

    public void openJsPrompt() {
        driver.findElement(jsPromptButton).click();
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void enterTextInPrompt(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResultText() {
        return driver.findElement(resultText).getText();
    }
}