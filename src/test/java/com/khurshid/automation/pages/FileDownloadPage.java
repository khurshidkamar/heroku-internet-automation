package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileDownloadPage extends BasePage {

    private By firstFileLink = By.cssSelector(".example a");

    public FileDownloadPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
    }

    public String clickFirstFile() {
        String fileName = waitUtils.waitForVisibility(firstFileLink).getText();
        waitUtils.waitForClickable(firstFileLink).click();
        return fileName;
    }
}
