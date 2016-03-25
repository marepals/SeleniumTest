package test.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by srikanth on 3/16/2016.
 */
// right comment
public class Driver {

    private static WebDriver driver;
    public enum Browser {CHROME, IE, FIREFOX, HTMLUNIT, OPERA}
    public static final long DEFAULT_TIMEOUT_SECONDS=10;
    public static String BROWSER_PROPERTY_NAME = "browser.name";
    public static Browser currentBrowser = null;
    private Driver(){
    }

    public static synchronized WebDriver get() {
        String browserName = System.getProperty(BROWSER_PROPERTY_NAME, "chrome");

        if (currentBrowser == null) {

            switch (browserName.toUpperCase()) {
                case "CHROME":
                case "GOOGLE.CHROME":
                    currentBrowser = Browser.CHROME;
                    break;
                case "FIREFOX":
                    currentBrowser = Browser.FIREFOX;
                    break;
                default:
                    currentBrowser = Browser.FIREFOX;
            }
            if (driver == null) {
                switch (currentBrowser) {
                    case CHROME:
                        System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
                        driver = new ChromeDriver();
                        break;
                    case FIREFOX:
                        driver = new FirefoxDriver();
                        break;
                    default:
                        System.setProperty("webdriver.chrome.driver", "/src/main/resources/drivers/chromedriver.exe");
                        driver = new ChromeDriver();
                }
            }
        }
        return driver;
    }

}
