package pageObject;

import base.Config;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    @FindBy(how=How.ID, using = "consent-close")
    public WebElement closeBtn;
//    @FindBy(how=How.XPATH, using = "/html/body/div[4]/div[1]/header/div[1]/div/div/div[3]/div/div/div/div/div[2]/button/span")
//    public WebElement signInBtnLocator;
//
//    @FindBy(how=How.LINK_TEXT, using = "Create an Account")
//    public WebElement createActBtnLocator;
    @FindBy(how= How.NAME, using = "dwfrm_profile_customer_firstname")
    public WebElement fnLocator;
    @FindBy(how= How.NAME, using = "dwfrm_profile_customer_lastname")
    public WebElement lnLocator;
    @FindBy(how= How.NAME, using = "dwfrm_profile_customer_email")
    public WebElement emailLocator;
    @FindBy(how= How.NAME, using = "dwfrm_profile_login_password")
    public WebElement passwordLocator;
    @FindBy(how= How.NAME, using = "dwfrm_profile_login_passwordconfirm")
    public WebElement confirmPasswordLocator;
    @FindBy(how= How.NAME, using = "dwfrm_profile_customer_zipcode")
    public WebElement zipCodeLocator;
    @FindBy(how= How.NAME, using = "dwfrm_profile_customer_phone")
    public WebElement phoneNumLocator;
    @FindBy(how= How.NAME, using = "save")
    public WebElement submitBtnLocator;

    //this locator is for My Account page
    @FindBy(how= How.XPATH, using = "//*[@id=maincontent]/div/div[2]/div/div/div[2]/span[1]")
    public WebElement welcomeMsgLocator;


    //java faker class object
    //to create random data
    Faker faker = new Faker();

    // functions
    public void clickCloseBtn(){
        closeBtn.click();
    }
    public void clickCreateActBtn(){
        // Locating the Main Menu (Parent element)
        WebElement mainMenu = driver.findElement(By.xpath("/html/body/div[4]/div[1]/header/div[1]/div/div/div[3]/div/div/div/div/div[2]/button/span"));
        //Instantiating Actions class
        Actions actions = new Actions(driver);
        //Hovering on main menu
        actions.moveToElement(mainMenu);
        // Locating the element from Sub Menu
        WebElement subMenu = driver.findElement(By.xpath("/html/body/div[4]/div[1]/header/div[1]/div/div/div[3]/div/div/div/div/div[2]/div/a[2]"));
        //To mouseover on sub menu
        actions.moveToElement(subMenu);
        //build()- used to compile all the actions into a single step
        actions.click().build().perform();
    }
    public void enterFirstName(){
        fnLocator.sendKeys(faker.name().firstName());
    }
    public void enterLastName(){
        lnLocator.sendKeys(faker.name().lastName());
    }
    public void enterEmail(){
        emailLocator.sendKeys(faker.internet().emailAddress());
    }
    public void enterPasswordAndConfirmPassword(){
        String fakePass = faker.internet().password(8,11,true,true,true);
        String pass = fakePass+"a";
        passwordLocator.sendKeys(pass);
        confirmPasswordLocator.sendKeys(pass);
    }
    public void enterZipCode(){
        zipCodeLocator.sendKeys(faker.address().zipCode());
    }
    public void enterPhoneNum(){
        phoneNumLocator.sendKeys("5555555555");
    }
    public void submitButton(){
        submitBtnLocator.click();
    }

    public void verifyWelcomeMsg(){
        String welcome = welcomeMsgLocator.getText();
        if(welcome.contains("Welcome,")){
            System.out.println("User Successfully Logged In");
        }else {
            System.out.println("Login failed");
        }

    }

}
