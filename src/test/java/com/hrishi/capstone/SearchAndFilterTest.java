package com.hrishi.capstone;

import com.hrishi.capstone.actions.SearchContent;
import com.hrishi.capstone.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchAndFilterTest extends BaseTest{

    @Test
    public void searchAndFilterProductAccordingToPriceRange() throws InterruptedException {
        SearchContent searchContent= SearchContent.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().clickSearchBtn().searchProduct(searchContent.getInput());
        Categories categories = new Categories(getWebDriver());
        categories.openFilterModal().searchByPrice();

        Assert.assertTrue(categories.openFilterModal().searchByPrice(), "Products should be within the specified price range after applying the price filter.");

    }
}
