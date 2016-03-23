package org.selenium.test;

import org.apache.commons.collections.comparators.BooleanComparator;
import org.apache.xpath.operations.Bool;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


/**
 * Created by srikanth on 1/18/2016.
 */
public class SyncTest {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void InitializeTest(){
        driver = new FirefoxDriver();
        driver.navigate().to("http://compendiumdev.co.uk/selenium/basic_ajax.html");

        wait = new WebDriverWait(driver,10,50);
    }

    @Test
    public void NoSyncTest() {
        WebElement categoryCombobox = driver.findElement(By.cssSelector("#combo1"));
        WebElement languageCombobox = driver.findElement(By.cssSelector("#combo2"));
        WebElement valueTextbox = driver.findElement(By.cssSelector("#lteq30"));
        WebElement codeItInButton = driver.findElement(By.cssSelector("input[name=submitbutton]"));

        categoryCombobox.findElement(By.cssSelector("option[value='3']")).click();
        languageCombobox.findElement(By.cssSelector("option[value='23']")).click();
        valueTextbox.sendKeys("4");
        codeItInButton.click();
    }

    @Test
    public void syncExpectedConditionsTest() {
        WebElement catSelect = driver.findElement(By.cssSelector("#combo1"));
        WebElement lanSelect = driver.findElement(By.cssSelector("#combo2"));
        WebElement valueText = driver.findElement(By.cssSelector("#lteq30"));
        WebElement codeButton = driver.findElement(By.cssSelector("input[name=submitbutton]"));

        catSelect.findElement(By.cssSelector("option[value='3']")).click();
        //wait.until(presenceOfElementLocated(By.cssSelector("option[value='23']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ajaxBusy")));
        lanSelect.findElement(By.cssSelector("option[value='23'")).click();
        valueText.sendKeys("4");
        codeButton.click();
        try {
            wait.until(titleContains("Detasdfsdfils"));
        }catch( TimeoutException e){
            Assert.fail("Title didn't contail the detailsasfadsf.");
        }

    }

    @Test
    public void syncExpectedConditionsWebElementTest(){
        WebElement combo1 = driver.findElement(By.cssSelector("#combo1"));
        WebElement combo2 = driver.findElement(By.cssSelector("#combo2"));
;
        WebElement button = driver.findElement(By.cssSelector("input[name=submitbutton]"));

        combo1.findElement(By.cssSelector("option[value='3']")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 10, 50);
        wait1.until(selectOptionToBePresent(By.cssSelector("#combo2"), "23"));
        //wait.pollingEvery(19, TimeUnit.MILLISECONDS).withMessage("")
        button.click();
        try {
            wait1.until(titleContains("Details"));
        }catch( TimeoutException e){
            Assert.fail("Title contains details");
        }
    }

    @Test
    public void FluentlyWaitTest(){
        WebElement combo1 = driver.findElement(By.cssSelector("#combo1"));
        WebElement combo2 = driver.findElement(By.cssSelector("#combo2"));
        ;
        WebElement button = driver.findElement(By.cssSelector("input[name=submitbutton]"));

        combo1.findElement(By.cssSelector("option[value='3']")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 10, 50);
        wait1.until(selectOptionToBePresent(By.cssSelector("#combo2"), "23"));
//        wait.pollingEvery(19, TimeUnit.MILLISECONDS).withMessage("")
        button.click();
        try {
            wait1.until(titleContains("Details"));
        }catch( TimeoutException e){
            Assert.fail("Title contains details");
        }
    }
    public ExpectedCondition<WebElement> selectOptionToBePresent(final By findBy, final String value) {
        return new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(findBy).findElement(By.cssSelector("option[value='"+value+"']"));
            }
        };
    }

    // Adhoc wait created inline - Anonymous class.
    @Test
    public void syncCustomExpectedConditionsAnonymounsTest() {
        WebElement catSelect = driver.findElement(By.cssSelector("#combo1"));
        final WebElement lanSelect = driver.findElement(By.cssSelector("#combo2"));
        WebElement valueText = driver.findElement(By.cssSelector("#lteq30"));
        WebElement codeButton = driver.findElement(By.cssSelector("input[name=submitbutton]"));

        catSelect.findElement(By.cssSelector("option[value='3']")).click();
        wait.until(new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver webDriver) {

                return lanSelect.findElement(By.cssSelector("option[value='23'")).isDisplayed();
            }
        });
        lanSelect.findElement(By.cssSelector("option[value='23'")).click();
        valueText.sendKeys("4");
        codeButton.click();
        try {
            wait.until(titleContains("Detasdfsdfils"));
        }catch( TimeoutException e){
            Assert.fail("Title didn't contail the detailsasfadsf.");
        }
    }

    //Creating a Expected Conditions anonymous class inside a method. For parameterization and reuse.
    public static ExpectedCondition<Boolean> optionWithValueDisplayed(final String value){
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return webDriver.findElement(By.cssSelector("option[value='"+value+"']")).isDisplayed();
            }
        };
    }
    @Test
    public void syncCustomExpectedConditionsMethodTest() {
        WebElement catSelect = driver.findElement(By.cssSelector("#combo1"));
        WebElement lanSelect = driver.findElement(By.cssSelector("#combo2"));
        WebElement valueText = driver.findElement(By.cssSelector("#lteq30"));
        WebElement codeButton = driver.findElement(By.cssSelector("input[name=submitbutton]"));

        catSelect.findElement(By.cssSelector("option[value='3']")).click();
        wait.until(optionWithValueDisplayed("23"));
        lanSelect.findElement(By.cssSelector("option[value='23'")).click();
        valueText.sendKeys("4");
        codeButton.click();
        try {
            wait.until(titleContains("Detasdfsdfils"));
        }catch( TimeoutException e){
            Assert.fail("Title didn't contail the detailsasfadsf.");
        }

    }

    //Creating a named class for Expected conditions.
    @Test
    public void syncCustomExpectedConditionsTest() {
        WebElement catSelect = driver.findElement(By.cssSelector("#combo1"));
        WebElement lanSelect = driver.findElement(By.cssSelector("#combo2"));
        WebElement valueText = driver.findElement(By.cssSelector("#lteq30"));
        WebElement codeButton = driver.findElement(By.cssSelector("input[name=submitbutton]"));

        catSelect.findElement(By.cssSelector("option[value='3']")).click();
        wait.until(new SelectContainsText("Java", By.cssSelector("#combo2")));
        lanSelect.findElement(By.cssSelector("option[value='23'")).click();
        valueText.sendKeys("4");
        codeButton.click();
        try {
            wait.until(titleContains("Detasdfsdfils"));
        }catch( TimeoutException e){
            Assert.fail("Title didn't contail the detailsasfadsf.");
        }

    }
    private class SelectContainsText implements ExpectedCondition<Boolean>{
        private String textToFind;
        private By findBy;

        public SelectContainsText(String textToFind, By findBy) {
            this.textToFind = textToFind;
            this.findBy = findBy;
        }

        public Boolean apply(WebDriver webDriver) {
           WebElement combo =  webDriver.findElement(this.findBy);
            List<WebElement> options = combo.findElements(By.cssSelector("option"));
            for (WebElement option : options) {
                if(option.getText().equals(this.textToFind)){
                    return true;
                }
            }
            return false;
        }
    }


}


