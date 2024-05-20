package com.hrishi.capstone.pages.accounts;

import com.hrishi.capstone.models.User;
import com.hrishi.capstone.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"recover\"]")
    private WebElement resetPageHeading;

    @FindBy(id = "RecoverEmail")
    private WebElement emailIdTextBox;

    @FindBy(xpath = "//*[@id=\"MainContent\"]/div/div[1]/form/button")
    private WebElement submitBtn;

    public LoginPage forgotPassword(User user){
        textBox.type(emailIdTextBox, user.getEmailID());
        buttonActions.click(submitBtn);
        return new LoginPage(webDriver);
    }

    public String getResetPasswordPageHeading(){
        return webActions.getText(resetPageHeading);
    }

    public ForgotPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }
}
