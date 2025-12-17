package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxesPage extends BasePage {

    private By checkbox1 = By.xpath("//input[@type='checkbox'][1]");
    private By checkbox2 = By.xpath("//input[@type='checkbox'][2]");

    public CheckBoxesPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
    }

    // Actions
    public void selectCheckBox1() {
        WebElement cb1 = waitUtils.waitForClickable(checkbox1);
        if (!cb1.isSelected()) cb1.click();
    }

    public void deselectCheckBox1() {
        WebElement cb1 = waitUtils.waitForClickable(checkbox1);
        if (cb1.isSelected()) cb1.click();
    }

    public void selectCheckBox2() {
        WebElement cb2 = waitUtils.waitForClickable(checkbox2);
        if (!cb2.isSelected()) cb2.click();
    }

    public void deselectCheckBox2() {
        WebElement cb2 = waitUtils.waitForClickable(checkbox2);
        if (cb2.isSelected()) cb2.click();
    }

    // Assertions
    public boolean isCheckbox1Selected() {
        return waitUtils.waitForVisibility(checkbox1).isSelected();
    }

    public boolean isCheckbox2Selected() {
        return waitUtils.waitForVisibility(checkbox2).isSelected();
    }
}
