package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage {

    private By chooseFileInput = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFileName = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
    }

    public void uploadFile(String filePath) {
        waitUtils.waitForVisibility(chooseFileInput).sendKeys(filePath);
        waitUtils.waitForClickable(uploadButton).click();
    }

    public String getUploadedFileName() {
        return waitUtils.waitForVisibility(uploadedFileName).getText();
    }
}
