package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected HomePage homePage;

    @Before
    public void setUp() {
        logger.info("----- " + testName.getMethodName() + " was started -----");
        webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Browser was opened");
        homePage = new HomePage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
        logger.info("----- " + testName.getMethodName() + " was closed -----");
    }

    @Rule
    public TestName testName = new TestName();

    private WebDriver initDriver() {
        String browser = System.getProperty("browser");
        if ((browser == null) || "chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if ("edge".equalsIgnoreCase(browser)) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
        return webDriver;
    }
}
