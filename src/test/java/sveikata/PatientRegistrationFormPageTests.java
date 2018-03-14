package sveikata;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sveikata.models.Credentials;
import sveikata.models.Patient;
import sveikata.pages.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PatientRegistrationFormPageTests extends BasicTest {

    private static final String PATIENT_ID = "3941010" + new Random().nextInt(9999);
    private static final String CREATION_SUCCESS_MESSAGE = "Naujo paciento paskyra sėkmingai sukurta.";
    private Faker faker;

    private WebDriver driver;
    private HomePage homePage;
    private LoginForSystemUsersPage loginForSystemUsersPage;
    private AdminPage adminPage;
    private PatientRegistrationFormPage patientRegistrationFormPage;
    private LoginForPatientPage loginForPatientPage;
    private PatientPage patientPage;

    @Before
    public void beforeTest() {
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        loginForSystemUsersPage = new LoginForSystemUsersPage(driver);
        adminPage = new AdminPage(driver);
        patientRegistrationFormPage = new PatientRegistrationFormPage(driver);
        loginForPatientPage = new LoginForPatientPage(driver);
        patientPage = new PatientPage(driver);
        faker = new Faker();
        driver.get(homePage.getUrl());
        homePage.goToLoginForSystemUsers();
        loginForSystemUsersPage.login(Credentials.ROOT);
        adminPage.goToPatientRegistrationForm();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void patientIsRegisteredSuccessfully() {

        patientRegistrationFormPage.fillInPatientRegFormCorrectly(PATIENT_ID, faker.firstName(), faker.lastName());
        assertThat(patientRegistrationFormPage.getSuccessMessage().isDisplayed(), is(true));
        assertThat(patientRegistrationFormPage.getSuccessMessage()
                .getText(), is(CREATION_SUCCESS_MESSAGE));
    }
    @Test
    public void patientNotRegisteredWithoutAnyData(){
        patientRegistrationFormPage.clickSubmitButton();
        assertThat(patientRegistrationFormPage.getErrorMessage().isDisplayed(), is(true));
        assertThat(
                patientRegistrationFormPage.getErrorMessage().getText(),
                is("Prašome taisyklingai užpildyti visus laukus.")
        );
    }
    @Test
    public void patientFormInvalidIdValidation(){
        patientRegistrationFormPage.fillInPatientId("34263131387");
        patientRegistrationFormPage.clickPasswordInput();
        assertThat(patientRegistrationFormPage.getCheckIdMsg().isDisplayed(), is(true));
        assertThat(
                patientRegistrationFormPage.getCheckIdMsg().getText(),
                is("Patikrinkite ar gerai įvedėte 1-7 skaitmenis.")
        );
    }
    @Test
    public void registerMultiplyPatientsTest(){
        final List<Patient> users = new ArrayList<>();
        IntStream.range(0, 10)
                .mapToObj(i -> Patient.createPatient())
                .forEach(user -> {
                    Credentials cr =
                            patientRegistrationFormPage.registerNewPatient(
                                    user.getId(),
                                    user.getFirstName(),
                                    user.getLastName());

                    assertThat(patientRegistrationFormPage.getSuccessMessage().isDisplayed(), is(true));
                    assertThat(patientRegistrationFormPage.getSuccessMessage().getText(), is(CREATION_SUCCESS_MESSAGE));
                    user.setPassword(cr.getPassword());
                    user.setId(cr.getUsername());
                    users.add(user);
                });
        patientRegistrationFormPage.logout();
        users.forEach(user -> {
            homePage.goToLoginForPatients();
            loginForPatientPage.login(user.getId(), user.getPassword());
            String loggedTitle = patientPage.getLoggedInPatientTitle().getText();
            assertThat(loggedTitle, containsString(user.getFirstName()));
            assertThat(loggedTitle, containsString(user.getLastName()));
            patientPage.clickLogout();
        });
    }
    @After
    public void afterTest(){
        driver.close();
    }
}
