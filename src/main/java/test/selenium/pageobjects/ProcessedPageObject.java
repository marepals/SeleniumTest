package test.selenium.pageobjects;

import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by srikanth on 3/13/2016.
 */
public class ProcessedPageObject extends LoadableComponent<ProcessedPageObject> {

    WebDriver driver;
    WebDriverWait wait;
    WebElement language;
    WebElement category;


    public ProcessedPageObject(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 50);
        category = driver.findElement(By.cssSelector("#_valueid"));
        language = driver.findElement(By.cssSelector("#_valuelanguage_id"));
    }

    public String getLanguage(){
        return language.getText();
    }

    public String getCategory(){
        return category.getText();
    }

    @Override
    protected void load() {
        System.out.println("Load Function");
    }

    @Override
    protected void isLoaded() throws Error {
        System.out.println("Is Loaded");
    }
}
