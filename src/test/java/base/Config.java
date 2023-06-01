package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Config extends TestData{
    //initialize the driver
    public static WebDriver driver;

    //setup browser type //get the browserType from the user
    public static WebDriver setupBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        }
        //maximize the browser window
        driver.manage().window().maximize();
        //wait for 10 secs for all the elements of the page to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;

    }

}
