import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.LoginForSystemUsersPage;
import pages.PatientRegistrationFormPage;

public class SystemUserRegistrationFormPageTests extends BasicTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginForSystemUsersPage loginForSystemUsersPage;

    @Before
    public void beforeTest(){
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        driver.get(homePage.getUrl());
        loginForSystemUsersPage = new LoginForSystemUsersPage(driver);
        

        homePage.goToLoginForSystemUsers();
    }
}
