package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.BasicAjaxPageDefaultsTest;

/**
 * Created by srikanth on 3/16/2016.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( value = {
        BasicAjaxPageDefaultsTest.class
})
public class ChromeTestSuite {
}
