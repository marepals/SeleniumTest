package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.selenium.pageobjects.BasicAjaxPageObject;
import test.selenium.utils.Driver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by srikanth on 3/16/2016.
 */
public class BasicAjaxPageDefaultsTest {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup(){
        System.out.println("in before method");
        driver = Driver.get();
        wait = new WebDriverWait(driver, 10, 50);
        driver.navigate().to("http://compendiumdev.co.uk/selenium/basic_ajax.html");
    }

    @Test
    public void ValidateDefaultsTest(){
        BasicAjaxPageObject ajaxPageObject = new BasicAjaxPageObject(driver);
        //assertThat("Verify the Category Default value", ajaxPag);
        assertThat("Catagory Default Value ", ajaxPageObject.getCategoryValue(), is("Web"));
        assertThat("Language Default Value ", ajaxPageObject.getLanguageValue(), is("Javascript"));

    }
    @After

    public void cleanup(){

    }
}
