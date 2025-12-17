package com.khurshid.automation.tests;

import com.khurshid.automation.base.BaseTest;
import com.khurshid.automation.pages.FileUploadPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() {
        getDriver().get("https://the-internet.herokuapp.com/upload");

        FileUploadPage uploadPage = new FileUploadPage(getDriver(), waitUtils);


        String filePath = System.getProperty("user.dir") + "/src/test/resources/testfile.txt";

        uploadPage.uploadFile(filePath);

        assertTrue(uploadPage.getUploadedFileName().contains("testfile.txt"));
    }
}
