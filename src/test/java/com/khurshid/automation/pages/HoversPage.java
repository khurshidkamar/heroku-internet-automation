package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import com.khurshid.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoversPage extends BasePage {

    private By users = By.cssSelector(".figure");

    public HoversPage(WebDriver driver, WaitUtils waitUtils) {
        super(driver, waitUtils);
    }

    private WebElement getUser(int index) {
        List<WebElement> userList = driver.findElements(users);
        return userList.get(index);
    }

    public void hoverOverUser(int index) {
        WebElement user = getUser(index);
        actions.moveToElement(user).perform();
    }

    public String getUserName(int index) {
        WebElement user = getUser(index);
        return user.findElement(By.tagName("h5")).getText();
    }

    public boolean isProfileLinkVisible(int index) {
        WebElement user = getUser(index);
        By profileLink = By.cssSelector("a[href*='users']");
        WebElement link = waitUtils.waitForVisibility(user, profileLink);
        return link.isDisplayed();
    }
}
