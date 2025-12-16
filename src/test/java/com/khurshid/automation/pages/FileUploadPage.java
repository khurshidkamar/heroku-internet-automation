package com.khurshid.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    private WebDriver driver;

    private By chooseFileInput = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFileName = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadFile(String filePath) {
        driver.findElement(chooseFileInput).sendKeys(filePath);
        driver.findElement(uploadButton).click();
    }

    public String getUploadedFileName() {
        return driver.findElement(uploadedFileName).getText();
    }
}