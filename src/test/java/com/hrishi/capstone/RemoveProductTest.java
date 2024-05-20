package com.hrishi.capstone;

import com.hrishi.capstone.actions.SearchContent;
import com.hrishi.capstone.modals.CartModal;
import com.hrishi.capstone.pages.CartPage;
import com.hrishi.capstone.pages.HomePage;
import com.hrishi.capstone.pages.ProductDetailsPage;
import com.hrishi.capstone.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveProductTest extends BaseTest{

    @Test
    public void verifyProductRemovalFromCart() throws InterruptedException {
        SearchContent searchContent=SearchContent.builder().build().bellDress();
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().clickSearchBtn().searchProduct(searchContent.getInput());

        SearchResultPage searchResultPage=new SearchResultPage(getWebDriver());
        ProductDetailsPage productDetailsPage = searchResultPage.clickToViewProductByName();
        CartModal cartModal=new CartModal(getWebDriver());
        CartPage cartPage=new CartPage(getWebDriver());

        if(!productDetailsPage.isProductSoldOut()){
            productDetailsPage.clickAddToCart();
        }else{
            Assert.fail("Product Out of Stock");
        }

        cartModal.clickAddToCart();
        cartPage.removeProductFromCart(cartPage.getAddedProductName());
        Assert.assertTrue(cartPage.isCartEmpty());

    }
}
