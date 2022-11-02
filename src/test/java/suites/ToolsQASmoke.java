package suites;

import alertsTests.AlertsTests;
import buttonTests.ButtonTests;
import dynamicPropertiesTests.DynamicPropertiesTests;
import linksTests.LinksTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import webTablesTests.WebTablesTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AlertsTests.class,
        ButtonTests.class,
        DynamicPropertiesTests.class,
        LinksTests.class,
        WebTablesTests.class
})
public class ToolsQASmoke {
}
