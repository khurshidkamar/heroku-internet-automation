package com.khurshid.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import com.khurshid.automation.base.BasePage;
import org.openqa.selenium.WebElement;

public class CheckBoxesPage extends BasePage {


    //Locators
    private By checkbox1 = By.xpath("//input[@type='checkbox'][1]");
    private By checkbox2 = By.xpath("//input[@type='checkbox'][2]");

    //Constructor
    public CheckBoxesPage(WebDriver driver){
        super(driver);
    }

    //Actions
    public void selectCheckBox1(){
        WebElement cb1 = driver.findElement(checkbox1);
         if(!cb1.isSelected()) cb1.click();
    }
    public void deselectCheckBox1(){
        WebElement cb1 = driver.findElement(checkbox1);
        if(cb1.isSelected()) cb1.click();
    }
    public void selectCheckBox2(){
        WebElement cb2 = driver.findElement(checkbox2);
        if(!cb2.isSelected()) cb2.click();
    }
    public void deselectCheckBox2(){
        WebElement cb2 = driver.findElement(checkbox2);
        if(cb2.isSelected()) cb2.click();
    }

    public boolean isCheckbox1Selected(){
        return driver.findElement(checkbox1).isSelected();
    }
    public boolean isCheckbox2Selected(){
        return driver.findElement(checkbox2).isSelected();
    }
}
