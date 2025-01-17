package com.hrishi.capstone;

import com.hrishi.capstone.models.User;
import com.hrishi.capstone.pages.HomePage;
import com.hrishi.capstone.pages.accounts.LoginPage;
import com.hrishi.capstone.pages.accounts.ProfilePage;
import com.hrishi.capstone.pages.accounts.RegistrationPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Registration")
public class RegistrationTest extends BaseTest{
    @Test(testName = "VerifyUserRegistrationSuccess",description = "Verify that a new user is able to register on the website by creating an account and accessing their profile page.", groups = "register")
    @Story("User Registration Success")
    public void VerifyUserRegistrationSuccess(){
        //arrange
        User user= User.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();

        //act
        loginPage.navToRegisterationPage().createAccount(user);
        ProfilePage profilePage = homePage.getHeader().navToProfilePage();

        //assert
        String accountDetails= profilePage.getAccountDetails();
        Assert.assertTrue(accountDetails.contains(user.getFirst_name()));
    }

    @Test(testName = "VerifyRegistrationWithEmailRequired", description = "Verifies that the user is unable to register without providing an email address by attempting to create an account with an empty email field.", groups = "register")
    @Story("User Registration with Email Required")
    public void verifyThatUserIsNotAbleToRegisterWithEmptyEmail(){
        //arrange
        User user= User.builder().build().userWithoutEmail();
        HomePage homePage=new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();
        RegistrationPage registrationPage=new RegistrationPage(getWebDriver());

        //act
        loginPage.navToRegisterationPage().createAccount(user);

        //assert
        String errorMessage = registrationPage.errorMessage();
        Assert.assertTrue(errorMessage.contains("Email can't be blank"));

    }

    @Test(testName = "RegistrationFailsWithEmptyPassword", description = "Validates that the user is prevented from registering without providing a password by attempting to create an account with an empty password field.")
    @Story("User Registration Fails with Empty Password")
    public void verifyThatUserIsNotAbleToRegisterWithEmptyPassword(){
        //arrange
        User user= User.builder().build().userWithoutPassword();
        HomePage homePage=new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();
        RegistrationPage registrationPage=new RegistrationPage(getWebDriver());

        //act
        loginPage.navToRegisterationPage().createAccount(user);

        //assert
        String errorMessage = registrationPage.errorMessage();
        Assert.assertTrue(errorMessage.contains("Password can't be blank"));
    }
}
