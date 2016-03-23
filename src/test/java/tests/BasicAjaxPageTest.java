package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.selenium.pageobjects.BasicAjaxPageObject;
import test.selenium.pageobjects.ProcessedPageObject;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import test.selenium.utils.Driver;


/**
 * Created by srikanth on 3/12/2016.
 */
public class BasicAjaxPageTest {
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
    public void BasicAjaxTest(){
        BasicAjaxPageObject ajaxPageObject = new BasicAjaxPageObject(driver);
        ajaxPageObject.fillAjaxForm("Desktop", "Visual Basic", "24");
        ProcessedPageObject processedPageObject = new ProcessedPageObject(driver);
//        processedPageObject.get();
        assertThat("check value category", processedPageObject.getCategory(), is("2"));
        assertThat("check value language", processedPageObject.getLanguage(), is("13"));
    }

    @Test
    public void VerifyDefaultsTest(){
        BasicAjaxPageObject ajaxPageObject = new BasicAjaxPageObject(driver);
        //assertThat("Verify the Category Default value", ajaxPag);
        assertThat("Catagory Default Value ", ajaxPageObject.getCategoryValue(), is("Web"));
        assertThat("Language Default Value ", ajaxPageObject.getLanguageValue(), is("Javascript"));

    }
    @After

    public void cleanup(){

    }
}
