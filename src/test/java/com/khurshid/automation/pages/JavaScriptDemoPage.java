package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.JavaScriptUtils;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptDemoPage extends BasePage {

    private JavaScriptUtils jsUtils;

    private By inputField = By.cssSelector("#input-example input");
    private By enableButton = By.xpath("//button[text()='Enable']");

    public JavaScriptDemoPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
        this.jsUtils = new JavaScriptUtils(driver);
    }

    public void scrollToInput() {
        WebElement input = waitUtils.waitForVisibility(inputField);
        jsUtils.scrollIntoView(input);
    }

    public void enableInputUsingJS() {
        WebElement input = waitUtils.waitForVisibility(inputField);
        jsUtils.removeDisabled(input);
    }

    public void typeText(String text) {
        WebElement input = waitUtils.waitForVisibility(inputField);
        input.sendKeys(text);
    }

    public String readDisabledAttribute() {
        WebElement input = waitUtils.waitForVisibility(inputField);
        return jsUtils.getAttribute(input, "disabled");
    }

    public void clickEnableWithJS() {
        WebElement button = waitUtils.waitForClickable(enableButton);
        jsUtils.clickWithJS(button);
    }

    public boolean isInputDisabled() {
        WebElement input = waitUtils.waitForVisibility(inputField);
        return !input.isEnabled(); // true if input is disabled
    }
}
