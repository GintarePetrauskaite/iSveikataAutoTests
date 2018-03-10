import com.github.javafaker.Faker;
import models.Credentials;
import models.Pharmacist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

public class PharmacistPageTests extends BasicTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginForSystemUsersPage loginForSystemUsersPage;
    private AdminPage adminPage;
    private SystemUserRegistrationFormPage systemUserRegistrationFormPage;
    private PharmacistPage pharmacistPage;
    private Faker faker;

    @Before
    public void beforeTest(){
        driver = new FirefoxDriver();
        faker = new Faker();
        //create pages
        homePage = new HomePage(driver);
        loginForSystemUsersPage = new LoginForSystemUsersPage(driver);
        adminPage = new AdminPage(driver);
        systemUserRegistrationFormPage = new SystemUserRegistrationFormPage(driver);
        pharmacistPage = new PharmacistPage(driver);
        // create pharmacist
        driver.get(homePage.getUrl());
        homePage.goToLoginForSystemUsers();
        loginForSystemUsersPage.login(Credentials.ROOT);
        adminPage.goToSystemUserRegistrationForm();
        Credentials credentials =
                systemUserRegistrationFormPage.registerNewDruggist(Pharmacist.createPharmacist());
        systemUserRegistrationFormPage.logout();
        // login as pharmacist
        homePage.goToLoginForSystemUsers();
        loginForSystemUsersPage.login(credentials);
    }

    @Test
    public void checkPatientPrescriptionWorksCorrectly(){
        // TODO
        pharmacistPage.searchForPatient("TODO");
        pharmacistPage.clickSearchSubmitBtn();

    }
    @Test
    public void changePasswordSuccessfully(){
        pharmacistPage.goToChangePasswordForm();
        pharmacistPage.sendOldPassword("n4gwg4jf");
        pharmacistPage.sendNewPassword("newnewnewnew");
        pharmacistPage.sendNewPasswordRepeat("newnewnewnew");
        //assert message
        pharmacistPage.clickLogout();

    }
    @After
    public void afterTest(){
        driver.close();
    }
}
