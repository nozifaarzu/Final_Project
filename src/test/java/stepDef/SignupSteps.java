package stepDef;

import base.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.SignupPage;

public class SignupSteps extends Config {

    //create an object of signup_page class to use the locators from there
    SignupPage su = new SignupPage(driver);
    @Given("User in Saks Fifth Avenue homepage")
    public void userInSaksFifthAvenueHomepage() {
        System.out.println(driver.getTitle());
        if(driver.getTitle().contains("Luxury Fashion & Designer Clothing,"))
        {
            System.out.println("Right Page");
        }else{
            System.out.println("Wrong Page");
        }
    }
    @And("user clicks close button of pop up")
    public void userClicksCloseButtonOfPopUp() {
        su.clickCloseBtn();
    }
    @And("user clicks on Create Account button by hovering over sign in button")
    public void userClicksOnCreateAccountButtonByHoveringOverSignInButton() {
        su.clickCreateActBtn();
    }

    @And("user enters first and last name")
    public void userEntersFirstAndLastName() {
        su.enterFirstName();
        su.enterLastName();
    }

    @And("user enters their valid and unique email address")
    public void userEntersTheirValidAndUniqueEmailAddress() {
        su.enterEmail();
    }

    @And("user enters password and confirm password")
    public void userEntersPasswordAndConfirmPassword() {
        su.enterPasswordAndConfirmPassword();
    }

    @And("user enters zipcode and phone number")
    public void userEntersZipcodeAndPhoneNumber() {
        su.enterZipCode();
        su.enterPhoneNum();
    }
    @When("user clicks on Create An Account button")
    public void userClicksOnCreateAnAccountButton() {
        su.submitButton();
    }

    @Then("user should be navigated to their My Account page")
    public void userShouldBeNavigatedToTheirMyAccountPage() {
        su.verifyWelcomeMsg();
    }

}
