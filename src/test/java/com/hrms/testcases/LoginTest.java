package com.hrms.testcases;

import com.hrms.pages.DashBoardPage;
import com.hrms.pages.LoginPage;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends CommonMethods {
    @Test
    public void adminLogin(){
        LoginPage login = new LoginPage();
        sendText(login.usernameBox, ConfigsReader.getPropertyValue("userName"));
        sendText(login.passwordBox, ConfigsReader.getPropertyValue("password"));
        click(login.loginBtn);

        //validation that we are logged in
        DashBoardPage dashBoardPage = new DashBoardPage();
        String dashBoardWelcomeMessText = dashBoardPage.welcomeMessage.getText();
        softAssert().assertTrue(dashBoardPage.welcomeMessage.isDisplayed(), "Welcome message is not displayed");
        softAssert().assertEquals(dashBoardWelcomeMessText, "Welcome " + ConfigsReader.getPropertyValue("userName"), "Welcome test is not matching");
        softAssert().assertAll();

        //validation
        //assertion

    }
}
