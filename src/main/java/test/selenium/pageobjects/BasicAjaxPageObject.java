package test.selenium.pageobjects;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Created by srikanth on 3/8/2016.
 */
public class BasicAjaxPageObject extends LoadableComponent<BasicAjaxPageObject> {

    WebDriver driver;
    WebElement category;
    WebElement language;
    WebElement codeItIn;
    WebElement valuesText;

    WebDriverWait wait;

    public BasicAjaxPageObject(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 50);
        get();
        category = driver.findElement(By.cssSelector("#combo1"));
        language = driver.findElement(By.cssSelector(("#combo2")));
        codeItIn = driver.findElement(By.cssSelector("[name='submitbutton']"));
        valuesText = driver.findElement(By.cssSelector("#lteq30"));
    }

    public void fillAjaxForm(String category, final String language, String valuesText) {
        setCategory(category);
        // wait until the language option displays the language
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver){
                return driver.findElement(By.xpath(".//option[normalize-space(.)='"+language+"']")).isDisplayed();
            }
        });
        setLanguage(language);
        setValuesText(valuesText);
        codeItIn.click();
    }

    public void clickCodeInIt(){
        codeItIn.click();
    }

    public void setValuesText(String valuesText){
        this.valuesText.sendKeys(valuesText);
    }

    public String getCategoryValue(){
        List<WebElement> options = category.findElements(By.cssSelector("option"));
        for ( WebElement option : options) {
            if (option.isSelected())
                return option.getText();
        }
        return null;
    }

    public String getLanguageValue(){
        List<WebElement> options = language.findElements(By.cssSelector("option"));
        for(WebElement option: options){
            if(option.isSelected())
                return option.getText();
        }
        return null;
    }

    public void setCategory(String category ){
        if (category.toUpperCase().equals("WEB"))
            this.category.findElement(By.cssSelector("option[value='1']")).click();
        else if(category.toUpperCase().equals("DESKTOP"))
            this.category.findElement(By.cssSelector("option[value='2']")).click();
        else if(category.toUpperCase().equals("SERVER"))
            this.category.findElement(By.cssSelector("option[value='3']")).click();
        else
            System.out.println("Category not found - given category - "+ category);
    }

    public void setLanguage(String language ){
        if (language.toUpperCase().equals("C++"))
            this.language.findElement(By.cssSelector("option[value='10']")).click();
        else if(language.toUpperCase().equals("ASSEMBLER"))
            this.language.findElement(By.cssSelector("option[value='11']")).click();
        else if(language.toUpperCase().equals("C"))
            this.language.findElement(By.cssSelector("option[value='12']")).click();
        else if(language.toUpperCase().equals("VISUAL BASIC"))
            this.language.findElement(By.cssSelector("option[value='13']")).click();
        else if(language.toUpperCase().equals("JAVASCRIPT"))
            this.language.findElement(By.cssSelector("option[value='0']")).click();
        else if(language.toUpperCase().equals("VBSCRIPT"))
            this.language.findElement(By.cssSelector("option[value='1']")).click();
        else if(language.toUpperCase().equals("FLASH"))
            this.language.findElement(By.cssSelector("option[value='2']")).click();
        else if(language.toUpperCase().equals("COBOL"))
            this.language.findElement(By.cssSelector("option[value='20']")).click();
        else if(language.toUpperCase().equals("FORTRAN"))
            this.language.findElement(By.cssSelector("option[value='21']")).click();
        else if(language.toUpperCase().equals("C++"))
            this.language.findElement(By.cssSelector("option[value='22']")).click();
        else if(language.toUpperCase().equals("JAVA"))
            this.language.findElement(By.cssSelector("option[value='23']")).click();
        else
            System.out.println("Category not found - given category - "+ category);
    }

    @Override
    protected void load() {
        System.out.println("inside Ajax load method");
        driver.get("http://compendiumdev.co.uk/selenium/basic_ajax.html");
    }

    @Override
    protected void isLoaded() throws Error {
        try{
            System.out.println("inside isLoaded - try block");
            assertTrue("is the page displayed",driver.findElement(By.cssSelector("#combo1")).isDisplayed());
        }catch(NoSuchElementException e){
            System.out.println("insude isLoaded - catch block");
            throw new AssertionError();
        }
    }
}
