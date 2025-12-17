package com.khurshid.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

    private WebDriver driver;

    public JavaScriptUtils(WebDriver driver) {
        this.driver = driver;
    }

    private JavascriptExecutor js() {
        return (JavascriptExecutor) driver;
    }

    // 1️⃣ Scroll element into view
    public void scrollIntoView(WebElement element) {
        js().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // 2️⃣ Click using JavaScript
    public void clickWithJS(WebElement element) {
        js().executeScript("arguments[0].click();", element);
    }

    // 3️⃣ Read hidden / non-visible attribute
    public String getAttribute(WebElement element, String attribute) {
        return (String) js().executeScript(
                "return arguments[0].getAttribute(arguments[1]);",
                element, attribute
        );
    }

    // 4️⃣ Remove disabled attribute (controlled demo)
    public void removeDisabled(WebElement element) {
        js().executeScript("arguments[0].removeAttribute('disabled');", element);
    }
}