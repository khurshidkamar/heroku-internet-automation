package com.khurshid.automation.base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void setUp(){
        ChromeOptions options = new ChromeOptions();

// Essential Linux Fixes
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

// Network/DNS Hang Fixes
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");

// Speed up loading by not waiting for failing resources (like that log/favicon)
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
