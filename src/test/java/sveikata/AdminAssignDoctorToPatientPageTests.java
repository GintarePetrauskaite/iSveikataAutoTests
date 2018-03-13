package sveikata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sveikata.models.Credentials;
import sveikata.pages.*;

public class AdminAssignDoctorToPatientPageTests extends BasicTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginForSystemUsersPage loginForSystemUsersPage;
    private AdminPage adminPage;
    private AdminAssignDoctorToPatientPage adminAssignDoctorToPatientPage;

    @Before
    public void beforeTest() {
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        loginForSystemUsersPage = new LoginForSystemUsersPage(driver);
        adminPage = new AdminPage(driver);
        adminAssignDoctorToPatientPage = new AdminAssignDoctorToPatientPage(driver);

        driver.get(homePage.getUrl());
        homePage.goToLoginForSystemUsers();
        loginForSystemUsersPage.login(Credentials.ROOT);
        adminPage.goToAssignDoctorToPatientForm();
    }
    @Test
    public void assignDoctorToPatientWorksCorrectly(){
        adminAssignDoctorToPatientPage.selectFirstDoctorFromList("Meduolis");
        adminAssignDoctorToPatientPage.selectFirstPatientFromList("3941010");

    }
    @After
    public void afterTest(){
        driver.close();
    }
}
