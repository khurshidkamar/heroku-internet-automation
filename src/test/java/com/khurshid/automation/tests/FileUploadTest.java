package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.FileUploadPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUploadTest extends BaseTest {

    @Test
    void fileUploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");

        FileUploadPage uploadPage = new FileUploadPage(driver);


        String filePath = System.getProperty("user.dir") + "/src/test/resources/testfile.txt";

        uploadPage.uploadFile(filePath);

        assertTrue(uploadPage.getUploadedFileName().contains("testfile.txt"));
    }
}
