package com.khurshid.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileDownloadPage {

    private WebDriver driver;

    private By firstFileLink = By.cssSelector(".example a");

    public FileDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public String clickFirstFile() {
        String fileName = driver.findElement(firstFileLink).getText();
        driver.findElement(firstFileLink).click();
        return fileName;
    }
}
