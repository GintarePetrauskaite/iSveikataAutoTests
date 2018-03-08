import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BasicTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

    protected String getHost() {
        return "http://localhost:3000";
    }

}
