package com.khurshid.automation.base;

import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;
    protected WaitUtils waitUtils;

    @BeforeMethod
    public void setUp(){
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


        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory",
                System.getProperty("user.dir") + "/downloads");
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        waitUtils = new WaitUtils(driver, 5);
    }

    @AfterMethod
    public void tearDown(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
