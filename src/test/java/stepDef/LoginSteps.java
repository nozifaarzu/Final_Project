package stepDef;

import base.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;
import pageObject.SignupPage;

public class LoginSteps extends Config {
    //create an object of LoginPage class to use the methods from there
    LoginPage lg = new LoginPage(driver);
    @And("user enters username and password")
    public void userEntersUsernameAndPassword() {
        lg.enterUsername();
        lg.enterPassword();
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        lg.clickLoginBtn();
    }

    @Then("user should be able to successfully login")
    public void userShouldBeAbleToSuccessfullyLogin() {
        lg.verifyLogin();
    }
}
