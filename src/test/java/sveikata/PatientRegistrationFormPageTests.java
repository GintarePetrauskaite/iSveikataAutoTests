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

public class PatientRegistrationFormPageTests extends BasicTest {

    private static final String PATIENT_ID = "3941010" + new Random().nextInt(5555);
    private static final String FIRSTNAME = "Vardenis";
    private static final String LASTNAME = "Pavardenis";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123";

    private WebDriver driver = new FirefoxDriver();
    private PatientRegistrationFormPage patientRegistrationFormPage = new PatientRegistrationFormPage(driver);
    private HomePage homePage = new HomePage(driver);
    private LoginForSystemUsersPage loginForSystemUsersPage = new LoginForSystemUsersPage(driver);

    @Before
    public void beforeTest(){
        driver.get(loginForSystemUsersPage.getUrl());
    }
    @Test
    public void patientIsRegisteredSuccessfully() {
        loginForSystemUsersPage.login(USERNAME, PASSWORD);
        patientRegistrationFormPage.fillInPatientRegFormCorrectly(PATIENT_ID, FIRSTNAME, LASTNAME);

        Assert.assertTrue(patientRegistrationFormPage.GetSuccessMessage().isDisplayed() &&
                patientRegistrationFormPage.GetSuccessMessage().getText().contains("Sukurtas naujas pacientas"));
    }
    @After
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
