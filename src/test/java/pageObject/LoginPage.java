package pageObject;

import base.Config;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Config {
    //create a constructor of this class
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Config.driver=driver;
    }

    //locators
    @FindBy(how= How.NAME, using = "username")
    public WebElement usernameLocator;
    @FindBy(how= How.NAME, using = "password")
    public WebElement passwordLocator;
    @FindBy(how= How.XPATH, using = "//input[@value='Log In']")
    public WebElement loginBtnLocator;
    @FindBy(how= How.XPATH, using = "//h1[@class='title']")
    public WebElement ActOverviewLocator;


    // functions
    //create an object of signuppage class to access its attributes
    SignupPage su = new SignupPage(driver);
    public void enterUsername(){
        String un = su.username;
        usernameLocator.sendKeys(un);
    }
    public void enterPassword(){
        String p = su.pass;
        passwordLocator.sendKeys(p);
    }
    public void clickLoginBtn(){
        loginBtnLocator.click();

    }
    public void verifyLogin(){
        String overview = ActOverviewLocator.getText();
        if(overview.contains("Accounts Overview")){
            System.out.println("User Successfully Logged In");
        }else {
            System.out.println("Login failed");
        }

    }
}
