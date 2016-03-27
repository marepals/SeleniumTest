package test.selenium.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Quotes;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srikanth on 3/25/2016.
 */
public class WebTable {

    private final WebElement element;
    private boolean hasHeader;
    private boolean hasFooter;

    public WebTable(WebElement element) {
        String tagName = element.getTagName();

        if ( tagName == null || !tagName.toLowerCase().equals("table")) {
            throw new UnexpectedTagNameException("table", tagName);
        }

        this.element = element;
        hasHeader = true;
        // set the table type later, by default, this will be a simple table.
    }


    public WebTable(WebElement element, boolean hasHeader, boolean hasFooter) {
        String tagName = element.getTagName();

        if ( tagName == null || !tagName.toLowerCase().equals("table")) {
            throw new UnexpectedTagNameException("table", tagName);
        }

        this.element = element;
        this.hasHeader = hasHeader;
        this.hasFooter = hasFooter;
        // set the table type later, by default, this will be a simple table.
    }
    //get cell data ( row name, column name)
    // get cell data ( row id, column id)
    // get header names
    // get column names
    // get column values ( column name)
    // get row values ( row name)
    // verify table row ( list of row elements, inorder
    // get number of rows
    // get number of columns

    public int getRowCount(){
            return element.findElements(By.cssSelector("tr")).size();
    }

    public int getColumnCount(){
        List<WebElement> rows = element.findElements(By.cssSelector("tr"));
        if(hasHeader)
            return(rows.get(0).findElements(By.cssSelector("th")).size());
        else
            return(rows.get(0).findElements(By.cssSelector("td")).size());
    }

    public String getCellData(int rowId, int columnId){
        int rowCount;
        int columnCount;

        rowCount = getRowCount();
        columnCount = getColumnCount();

        if (rowId <=rowCount && columnId <= columnCount) {
            List<WebElement> rows = element.findElements(By.cssSelector("tr"));
            return rows.get(rowId-1).findElements(By.cssSelector("th,td")).get(columnId-1).getText();
        }
        else {
            System.out.println("The row or column id is great then the number of rows/columns in the table");
            System.out.println("rowID given "+rowId+ "rowCount in table "+rowCount);
            System.out.println("columnID given "+columnId+ "columnCount in table "+columnCount);
        }
        return null;
    }

    public int getColumnId( String columnName){
        List <WebElement> columns;
        int columnId=0;
        boolean found = false;

        columns = element.findElement(By.cssSelector("tr")).findElements(By.cssSelector("th,td"));

        for(WebElement column : columns) {
            columnId++;
            if(column.getText().toUpperCase().equals(columnName.toUpperCase())){
                found = true;
                break;
            }

        }
        if(found)
            return columnId;
        else {
            System.out.println("Didn't find the given column - " + columnName);
            return -1;
        }

    }

    public int getRowId(String rowName){
        List<WebElement> rows = element.findElements(By.cssSelector("tr"));
        int rowId = 0;
        boolean found = false;
        for(WebElement row : rows) {
            rowId++;
            if (row.findElement(By.cssSelector("th,td")).getText().equals(rowName)) {
                found = true;
                break;
            }
        }
        if (found)
            return rowId;
        else {
            System.out.println("Didn't find the given row - " + rowName);
            return -1;
        }
    }

    public String getCellData(String rowName, String columnName) {
        int rowId = getRowId(rowName);
        int columnId = getColumnId(columnName);
        if(rowId >0 && columnId >0)
            return getCellData(rowId, columnId);
        else
            return null;
    }
}

