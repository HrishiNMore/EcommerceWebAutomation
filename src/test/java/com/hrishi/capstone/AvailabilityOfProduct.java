package com.hrishi.capstone;

import com.hrishi.capstone.actions.SearchContent;
import com.hrishi.capstone.pages.HomePage;
import com.hrishi.capstone.pages.ProductDetailsPage;
import com.hrishi.capstone.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AvailabilityOfProduct extends BaseTest{
    @Test(testName = "Verify Product Availability", description = "Verify that the product is available when the user searches for it.")
    public void verifyThatProductIsAvailable(){
        SearchContent searchContent=SearchContent.builder().build().bellDress();
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().clickSearchBtn().searchProduct(searchContent.getInput());
        SearchResultPage searchResultPage=new SearchResultPage(getWebDriver());
        ProductDetailsPage productDetailsPage = searchResultPage.clickToViewProductByIndex(0);
        Assert.assertFalse((productDetailsPage.isProductSoldOut()), "Product is Available");
    }

    @Test(testName = "Verify Product Out of Stock", description = "Verify that the product is marked as out of stock when the user searches for it.")
    public void verifyThatProductIsOutOfStock(){
        SearchContent searchContent=SearchContent.builder().build().soldOutProduct();
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().clickSearchBtn().searchProduct(searchContent.getInput());
        SearchResultPage searchResultPage=new SearchResultPage(getWebDriver());
        ProductDetailsPage productDetailsPage = searchResultPage.clickToViewProductByIndex(0);
        Assert.assertTrue(productDetailsPage.isProductSoldOut(), "The product is marked Out of Stock as expected.");
    }

}
