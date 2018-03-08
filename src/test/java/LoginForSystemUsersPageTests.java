import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.LoginForSystemUsersPage;
import pages.PatientRegistrationFormPage;

import java.util.Random;


public class LoginForSystemUsersPageTests extends BasicTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginForSystemUsersPage loginForSystemUsersPage;
    private PatientRegistrationFormPage patientRegistrationFormPage;

    private static final String USERNAME = "root";
    private static final String PASSWORD = "123";
    private Random randomData = new Random();
    private String inputData = "SysUser" + randomData.nextInt();

    @Before
    public void beforeTest(){
        driver = new FirefoxDriver();
        driver.get(homePage.getUrl());
        homePage = new HomePage(driver);
        loginForSystemUsersPage = new LoginForSystemUsersPage(driver);
        patientRegistrationFormPage = new PatientRegistrationFormPage(driver);

        homePage.goToLoginForSystemUsers();
    }
    @Test
    public void adminLoginSuccessfullyTest() {

        loginForSystemUsersPage.loginAsAdmin("root", "123");
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:3000/#/admin/"));
    }
    @Test
    public void doctorLoginSuccessfullyTest(){

    }

    @After
    public void afterTest(){
        driver.close();
    }
}
