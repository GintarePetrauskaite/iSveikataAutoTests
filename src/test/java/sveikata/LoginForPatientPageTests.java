package sveikata;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sveikata.pages.HomePage;
import sveikata.pages.LoginForPatientPage;
import sveikata.pages.PatientPage;

public class LoginForPatientPageTests extends BasicTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginForPatientPage loginForPatientPage;
    private PatientPage patientPage;
    private String id = "36912120000";
    private String password = "VarVar69";

    @Before
    public void beforeTest(){
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        loginForPatientPage = new LoginForPatientPage(driver);
        patientPage = new PatientPage(driver);

        homePage.goToLoginForPatients();
    }
    @Test
    public void patientRegistersSuccessfully(){
        loginForPatientPage.fillInPatientId(id);
        loginForPatientPage.fillInPassword(password);
        loginForPatientPage.ClickSubmit();

        Assert.assertTrue(patientPage.getLoggedInPatientTitle().isDisplayed());
    }
    @Test
    public void patientRegistrationWithoutData(){
        loginForPatientPage.ClickSubmit();
        Assert.assertTrue(loginForPatientPage.getErrorMsg().isDisplayed() &&
        loginForPatientPage.getErrorMsg().getText().contains("Prašome taisyklingai užpildyti visus laukus."));
    }
    @Test
    public void patientRegistrationWithInvalidId(){
        loginForPatientPage.fillInPatientId("36912320000");
        loginForPatientPage.fillInPassword(password);
        loginForPatientPage.ClickSubmit();
    }
    @Test
    public void patientRegistrationWithInvalidPassword(){
        loginForPatientPage.fillInPatientId(id);
        loginForPatientPage.fillInPassword("VarVar");
        loginForPatientPage.ClickSubmit();
    }
    @Test
    public void patientRegistrationOfNonExistentPatient(){
        loginForPatientPage.fillInPatientId("46712121111");
        loginForPatientPage.fillInPassword("VarVar88");
        loginForPatientPage.ClickSubmit();
    }

    @After
    public void afterTest(){
        driver.close();

    }
}
