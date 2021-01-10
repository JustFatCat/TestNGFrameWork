package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends CommonMethods {
    @FindBy(id = "welcome")
    public WebElement welcomeMessage;

    @FindBy(id= "menu_pim_viewPimModule")
    public WebElement pimBtn;

    @FindBy(id = "menu_pim_addEmployee']")
    public WebElement addEmployeeBtn;

    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }
}
