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
    private final boolean isMulti;

    public WebTable(WebElement element) {
        String tagName = element.getTagName();

        if (null == tagName || !"select".equals(tagName.toLowerCase())) {
            throw new UnexpectedTagNameException("select", tagName);
        }

        this.element = element;

        String value = element.getAttribute("multiple");

        // The atoms normalize the returned value, but check for "false"
        isMulti = (value != null && !"false".equals(value));
    }

    /**
     * @return Whether this select element support selecting multiple options at the same time? This
     * is done by checking the value of the "multiple" attribute.
     */
    public boolean isMultiple() {
        return isMulti;
    }

    /**
     * @return All options belonging to this select tag
     */
    public List<WebElement> getOptions() {
        return element.findElements(By.tagName("option"));
    }

    /**
     * @return All selected options belonging to this select tag
     */
    public List<WebElement> getAllSelectedOptions() {
        List<WebElement> toReturn = new ArrayList<>();

        for (WebElement option : getOptions()) {
            if (option.isSelected()) {
                toReturn.add(option);
            }
        }

        return toReturn;
    }

    /**
     * @return The first selected option in this select tag (or the currently selected option in a
     * normal select)
     * @throws NoSuchElementException If no option is selected
     */
    public WebElement getFirstSelectedOption() {
        for (WebElement option : getOptions()) {
            if (option.isSelected()) {
                return option;
            }
        }

        throw new NoSuchElementException("No options are selected");
    }

    /**
     * Select all options that display text matching the argument. That is, when given "Bar" this
     * would select an option like:
     * <p>
     * &lt;option value="foo"&gt;Bar&lt;/option&gt;
     *
     * @param text The visible text to match against
     * @throws NoSuchElementException If no matching option elements are found
     */
    public void selectByVisibleText(String text) {
        // try to find the option via XPATH ...
        List<WebElement> options =
                element.findElements(By.xpath(".//option[normalize-space(.) = " + Quotes.escape(text) + "]"));

        boolean matched = false;
        for (WebElement option : options) {

            if (!isMultiple()) {
                return;
            }
            matched = true;
        }

    }
}

