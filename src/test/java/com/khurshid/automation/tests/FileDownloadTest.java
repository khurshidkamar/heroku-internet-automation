package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.FileDownloadPage;


import java.io.File;
import java.time.Duration;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileDownloadTest extends BaseTest {

    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

        FileDownloadPage page = new FileDownloadPage(driver, waitUtils);
        String fileName = page.clickFirstFile();

        File downloadedFile = new File(
                System.getProperty("user.dir") + "/downloads/" + fileName
        );

        // Wait briefly for download to complete
        int attempts = 0;
        while (!downloadedFile.exists() && attempts < 10) {
            Thread.sleep(1000);
            attempts++;
        }

        assertTrue(downloadedFile.exists(), "Downloaded file should exist");
    }
}
