package stepDef;

import base.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.SignupPage;

public class SignupSteps extends Config {

    //create an object of signup_page class to use the methods from there
    SignupPage su = new SignupPage(driver);
    @Given("User in Para Bank homepage")
    public void userInParaBankHomepage() {
        //verify page title
        String act = driver.getTitle();
        String exp = "ParaBank | Welcome | Online Banking";
        Assert.assertEquals(act,exp);
    }

    @And("user clicks on Register link")
    public void userClicksOnRegisterLink() {
        su.clickRegisterBtn();
    }

    @And("user enters first and last name")
    public void userEntersFirstAndLastName() {
        su.enterFirstName();
        su.enterLastName();
    }

    @And("user enters address, city,state, and zipcode")
    public void userEntersAddressCityStateAndZipcode() {
        su.enterStAddress();
        su.enterCity();
        su.enterState();
        su.enterZipCode();
    }

    @And("user enters phone number")
    public void userEntersPhoneNumber() {
        su.enterPhoneNum();
    }

    @And("user enters social security number")
    public void userEntersSocialSecurityNumber() {
        su.enterSSN();
    }

    @And("user enters username")
    public void userEntersUsername() {
        su.enterUsername();
    }

    @And("user enters password and confirm password")
    public void userEntersPasswordAndConfirmPassword() {
        su.enterPasswordAndConfirmPassword();
    }

    @When("user clicks on Register button")
    public void userClicksOnRegisterButton() {
        su.clickSubmitBtn();
    }

    @Then("user should be successfully registered and logged in")
    public void userShouldBeSuccessfullyRegisteredAndLoggedIn() {
        su.verifyWelcomeMsg();
    }
}
