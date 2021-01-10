package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployee extends CommonMethods{

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "chkLogin")
    public WebElement addLoginDetailsCheckBox;

    @FindBy(id = "user_name")
    public WebElement userNameField;

    @FindBy(id = "user_password")
    public WebElement userPassField;

    @FindBy(id = "re_password")
    public WebElement confirmPassField;

    @FindBy(id = "btnSave")
    public WebElement saveBtn;

    public AddEmployee(){
        PageFactory.initElements(CommonMethods.driver,this);
    }
}
