package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.DynamicLoadingPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicLoadingTest extends BaseTest {

    @Test
    void dynamicLoadingExample1() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        DynamicLoadingPage page = new DynamicLoadingPage(driver);
        page.clickStart();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String text = wait
                .until(ExpectedConditions.visibilityOfElementLocated(page.getFinishTextLocator()))
                .getText();

        assertEquals("Hello World!", text);
    }

    @Test
    void dynamicLoadingExample2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        DynamicLoadingPage page = new DynamicLoadingPage(driver);
        page.clickStart();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String text = wait
                .until(ExpectedConditions.visibilityOfElementLocated(page.getFinishTextLocator()))
                .getText();

        assertEquals("Hello World!", text);
    }
}
