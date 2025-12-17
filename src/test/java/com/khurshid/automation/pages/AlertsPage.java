package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage {

    private By jsAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private By resultText = By.id("result");

    public AlertsPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
    }

    public void openJsAlert() {
        waitUtils.waitForClickable(jsAlertButton).click();
    }

    public void openJsConfirm() {
        waitUtils.waitForClickable(jsConfirmButton).click();
    }

    public void openJsPrompt() {
        waitUtils.waitForClickable(jsPromptButton).click();
    }

    public String getAlertText() {
        Alert alert = waitUtils.waitForAlert();
        return alert.getText();
    }

    public void acceptAlert() {
        waitUtils.waitForAlert().accept();
    }

    public void dismissAlert() {
        waitUtils.waitForAlert().dismiss();
    }

    public void enterTextInPrompt(String text) {
        Alert alert = waitUtils.waitForAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getResultText() {
        return waitUtils.waitForVisibility(resultText).getText();
    }
}
