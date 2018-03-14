package sveikata;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sveikata.models.Credentials;
import sveikata.pages.HomePage;
import sveikata.pages.LoginForSystemUsersPage;
import sveikata.pages.PatientRegistrationFormPage;

import java.util.Random;


public class LoginForSystemUsersPageTests extends BasicTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginForSystemUsersPage loginForSystemUsersPage;
    private PatientRegistrationFormPage patientRegistrationFormPage;

    @Before
    public void beforeTest(){
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        driver.get(homePage.getUrl());
        loginForSystemUsersPage = new LoginForSystemUsersPage(driver);
        patientRegistrationFormPage = new PatientRegistrationFormPage(driver);

        homePage.goToLoginForSystemUsers();

    }
    @Test
    public void adminLoginSuccessfullyTest() {
        loginForSystemUsersPage.login(Credentials.ROOT);
//        TODO add wait
        Assert.assertTrue(driver.getCurrentUrl().contains(getHost() + "/#/admin/"));
    }
    @Test
    public void doctorLoginSuccessfullyTest(){

    }

    @After
    public void afterTest(){
        driver.close();
    }
}
