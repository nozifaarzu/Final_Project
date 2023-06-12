package pageObject;

import base.Config;
import com.github.javafaker.Faker;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignupPage extends Config {

    //create a constructor of this class
    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Config.driver=driver;
    }

    //locators
    @FindBy(how=How.LINK_TEXT, using = "Register")
    public WebElement registerBtnLocator;
    @FindBy(how= How.ID, using = "customer.firstName")
    public WebElement fnLocator;
    @FindBy(how= How.ID, using = "customer.lastName")
    public WebElement lnLocator;
    @FindBy(how= How.ID, using = "customer.address.street")
    public WebElement stAddressLocator;
    @FindBy(how= How.ID, using = "customer.address.city")
    public WebElement cityLocator;
    @FindBy(how= How.ID, using = "customer.address.state")
    public WebElement stateLocator;
    @FindBy(how= How.ID, using = "customer.address.zipCode")
    public WebElement zipCodeLocator;
    @FindBy(how= How.ID, using = "customer.phoneNumber")
    public WebElement phoneNumLocator;
    @FindBy(how= How.ID, using = "customer.ssn")
    public WebElement ssnLocator;
    @FindBy(how= How.ID, using = "customer.username")
    public WebElement usernameLocator;
    @FindBy(how= How.ID, using = "customer.password")
    public WebElement passLocator;
    @FindBy(how= How.ID, using = "repeatedPassword")
    public WebElement confirmPassLocator;
    @FindBy(how= How.XPATH, using = "//input[@value='Register']")
    public WebElement submitBtnLocator;
    @FindBy(how= How.XPATH, using = "//h1[@class='title']")
    public WebElement welcomeLocator;


    //java faker class object
    //to create random data
    Faker faker = new Faker();
    public String username = faker.name().username();

    public String fakePass = faker.internet().password(8,11,true,true,true);
    public String pass = fakePass+"a";




    // functions
    public void clickRegisterBtn(){
        registerBtnLocator.click();
    }
    public void enterFirstName(){
        fnLocator.sendKeys(faker.name().firstName());
    }
    public void enterLastName(){
        lnLocator.sendKeys(faker.name().lastName());
    }
    public void enterStAddress(){
        stAddressLocator.sendKeys(faker.address().streetAddress());
    }
    public void enterCity(){
        cityLocator.sendKeys(faker.address().city());
    }
    public void enterState(){
        stateLocator.sendKeys(faker.address().state());
    }
    public void enterZipCode(){
        zipCodeLocator.sendKeys(faker.address().zipCode());
    }
    public void enterPhoneNum(){
        phoneNumLocator.sendKeys(faker.phoneNumber().cellPhone());
    }
    public void enterSSN(){
        ssnLocator.sendKeys(faker.number().digits(9));
    }
    public void enterUsername(){
        System.out.println(username);
        usernameLocator.sendKeys(username);
    }
    public void enterPasswordAndConfirmPassword(){
        System.out.println(pass);
        passLocator.sendKeys(pass);
        confirmPassLocator.sendKeys(pass);
    }

    public void clickSubmitBtn(){
        submitBtnLocator.click();
    }

    public void verifyWelcomeMsg(){
        String welcome = welcomeLocator.getText();
        if(welcome.contains("Welcome")){
            System.out.println("User Successfully Logged In");
        }else {
            System.out.println("Login failed");
        }

    }

}
