import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginForSystemUsersPage;
import pages.PatientRegistrationFormPage;


public class LoginForSystemUsersPageTests extends BasicTest {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "123";
    private WebDriver driver = new FirefoxDriver();
    private HomePage homePage = new HomePage(driver);
    private LoginForSystemUsersPage loginForSystemUsersPage = new LoginForSystemUsersPage(driver);
    private PatientRegistrationFormPage patientRegistrationFormPage = new PatientRegistrationFormPage(driver);
    private AdminPage adminPage = new AdminPage(driver);

    @Before
    public void beforeTest(){
        driver.get(homePage.getUrl());
        homePage.goToLoginForSystemUsers();
        //driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
    }
    @Test
    public void adminLoginSuccessfullyTest() {

        loginForSystemUsersPage.loginAsAdmin(USERNAME, PASSWORD);
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/admin/"));
    }
    @After
    public void afterTest(){
        driver.close();
    }
}
