package com.hrishi.capstone.modals;

import com.hrishi.capstone.pages.BasePage;
import com.hrishi.capstone.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchModal extends BasePage {

    @FindBy(id = "Search-In-Modal")
    private WebElement searchInput;

    public SearchResultPage searchProduct(String input){
        textBox.type(searchInput,input);
        searchInput.submit();
        return new SearchResultPage(webDriver);
    }
    public SearchModal(WebDriver webDriver) {
        super(webDriver);
    }
}
