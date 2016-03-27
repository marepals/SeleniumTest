package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.selenium.utils.Driver;
import test.selenium.utils.WebTable;

/**
 * Created by srikanth on 3/26/2016.
 */
public class WebTableTest {

    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void setup(){
        driver = Driver.get();
        wait = new WebDriverWait(driver, 10,50);
        driver.navigate().to("http://www.w3schools.com/html/html_tables.asp");
        wait.until(ExpectedConditions.titleIs("HTML Tables"));
    }

    @Test
    public void WebTableClassTest(){

        WebTable table = new WebTable(driver.findElement(By.cssSelector("table")),true, true);

/*        System.out.println(table.getColumnCount());
        System.out.println(table.getRowCount());
        System.out.println(table.getCellData(1,1));
        System.out.println(table.getRowId("3"));
        System.out.println(table.getColumnId("Last Name"));*/
        System.out.println(table.getCellData("3","Number"));
        System.out.println(table.getCellData("3","First Name"));
        System.out.println(table.getCellData("3","Last Name"));
        System.out.println(table.getCellData("7","Points"));





    }
}
