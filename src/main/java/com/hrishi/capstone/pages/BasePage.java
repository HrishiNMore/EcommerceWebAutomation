package com.hrishi.capstone.pages;

import com.hrishi.capstone.actions.ButtonAction;
import com.hrishi.capstone.actions.TextBox;
import com.hrishi.capstone.actions.WebActions;
import com.hrishi.capstone.components.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver webDriver;
    protected ButtonAction buttonActions;
    protected TextBox textBox;
    protected WebActions webActions;
    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        this.buttonActions=new ButtonAction(webDriver);
        this.textBox=new TextBox(webDriver);
        this.webActions=new WebActions(webDriver);
    }
    public HeaderComponent getHeader(){
        return new HeaderComponent(webDriver);
    }

}
