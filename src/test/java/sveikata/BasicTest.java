package sveikata;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class BasicTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

    protected String getHost() {
        return "http://localhost:3000";
    }

}
