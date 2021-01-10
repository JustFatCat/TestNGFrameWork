package com.hrms.testcases;

import com.hrms.pages.AddEmployee;
import com.hrms.pages.DashBoardPage;
import com.hrms.pages.LoginPage;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import org.testng.annotations.Test;

public class AddEmployeeTest extends CommonMethods {
    @Test
    public void addEmployee(){
        //login to the hrms
        LoginPage login = new LoginPage();
        login.login(ConfigsReader.getPropertyValue("userName"), ConfigsReader.getPropertyValue("password"));
        //navigate to add employee page
        DashBoardPage dashBoardPage = new DashBoardPage();
        jsClick(dashBoardPage.pimBtn);
        jsClick(dashBoardPage.addEmployeeBtn);
        //add employee
        AddEmployee addEmp = new AddEmployee();
        sendText(addEmp.firstNameField, "qwert");
        sendText(addEmp.lastNameField, "asdfg");
        click(addEmp.saveBtn);

        //validation


    }
}
