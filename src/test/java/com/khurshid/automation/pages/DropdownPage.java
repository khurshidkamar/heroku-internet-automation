package com.khurshid.automation.pages;

import com.khurshid.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage{

    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver){
        super(driver);
    }

    private Select getSelect(){
        return new Select(driver.findElement(dropdown));
    }

    public void selectByVisibleText(String text){
        getSelect().selectByVisibleText(text);
    }

    public void selectByValue(String value){
        getSelect().selectByValue(value);
    }

    public void selectByIndex(int index){
        getSelect().selectByIndex(index);
    }
    public String getSelectedOption(){
        return getSelect().getFirstSelectedOption().getText();
    }
}
