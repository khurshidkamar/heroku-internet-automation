package com.khurshid.automation.base;

import com.khurshid.automation.driver.DriverManager;
import com.khurshid.automation.utils.WaitUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.PageLoadStrategy;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WaitUtils waitUtils;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-gpu",
                "--proxy-server='direct://'",
                "--proxy-bypass-list=*"
        );
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        String downloadPath = System.getProperty("user.dir") + "/downloads";
        new File(downloadPath).mkdirs();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);

        options.setExperimentalOption("prefs", prefs);


        WebDriver driver = new ChromeDriver(options);
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
        waitUtils = new WaitUtils(driver, 10);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            captureScreenshot(result);
        }

        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
        DriverManager.unload();
    }

    private void captureScreenshot(ITestResult result) {
        try {
            WebDriver driver = DriverManager.getDriver();
            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            File destination = new File(
                    "screenshots/" + result.getMethod().getMethodName() +
                            "_" + timestamp + ".png"
            );

            destination.getParentFile().mkdirs();
            Files.copy(source.toPath(), destination.toPath());

            System.out.println("📸 Screenshot saved: " + destination.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("❌ Failed to capture screenshot");
            e.printStackTrace();
        }
    }

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}
