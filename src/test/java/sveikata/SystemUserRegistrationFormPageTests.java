package sveikata;

import com.github.javafaker.Faker;
import sveikata.models.Credentials;
import sveikata.models.Person;
import sveikata.models.Pharmacist;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sveikata.pages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SystemUserRegistrationFormPageTests extends BasicTest {

    private static final String CREATION_SUCCESS_MESSAGE = "Naujo vartotojo paskyra sėkmingai sukurta.";
    private WebDriver driver;
    private HomePage homePage;
    private LoginForSystemUsersPage loginForSystemUsersPage;
    private AdminPage adminPage;
    private PharmacistPage pharmacistPage;
    private SystemUserRegistrationFormPage systemUserRegistrationFormPage;
    private Faker faker = new Faker();

    @Before
    public void beforeTest(){
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        loginForSystemUsersPage = new LoginForSystemUsersPage(driver);
        adminPage = new AdminPage(driver);
        pharmacistPage = new PharmacistPage(driver);
        systemUserRegistrationFormPage = new SystemUserRegistrationFormPage(driver);

        driver.get(homePage.getUrl());
        homePage.goToLoginForSystemUsers();
        loginForSystemUsersPage.login(Credentials.ROOT);
        adminPage.goToSystemUserRegistrationForm();
    }
    @Test
    public void registerNewDoctorSuccessfully(){
        systemUserRegistrationFormPage.registerNewDoctor(faker.firstName(), faker.lastName(), faker.country());
        Assert.assertTrue(systemUserRegistrationFormPage.getSuccessMsg().isDisplayed()
                && systemUserRegistrationFormPage.getSuccessMsg()
                .getText().equals(CREATION_SUCCESS_MESSAGE));
    }
    @Test
    public void newDoctorNotRegisteredWithEmptyFields(){
        systemUserRegistrationFormPage.chooseDoctorRadioButton();
        systemUserRegistrationFormPage.clickSubmit();
        Assert.assertTrue(systemUserRegistrationFormPage.getErrorMsg().isDisplayed() &&
                systemUserRegistrationFormPage.getErrorMsg()
                        .getText().equals("Prašome taisyklingai užpildyti visus laukus."));
    }
    @Test
    public void registerNewAdminSuccessfully(){
        systemUserRegistrationFormPage.registerNewAdmin(Person.createPerson());
        Assert.assertTrue(systemUserRegistrationFormPage.getSuccessMsg().isDisplayed()
                && systemUserRegistrationFormPage.getSuccessMsg()
                .getText().contains(CREATION_SUCCESS_MESSAGE));
    }
    @Test
    public void registerMultiplePharmacists() {
        final List<Pharmacist> users = new ArrayList<>();
        IntStream.range(0, 10)
                .mapToObj(i -> Pharmacist.createPharmacist())
                .forEach(user -> {
                    Credentials cr =
                            systemUserRegistrationFormPage.registerNewDruggist(
                                    user.getFirstName(),
                                    user.getLastName(),
                                    user.getBusinessType(),
                                    user.getCompanyName());
                    assertThat(systemUserRegistrationFormPage.getSuccessMsg().isDisplayed(), is(true));
                    assertThat(systemUserRegistrationFormPage.getSuccessMsg().getText(), is(CREATION_SUCCESS_MESSAGE));
                    user.setPassword(cr.getPassword());
                    user.setUsername(cr.getUsername());
                    users.add(user);
                });
        systemUserRegistrationFormPage.logout();
        users.forEach(user -> {
            homePage.goToLoginForSystemUsers();
            loginForSystemUsersPage.login(user.getUsername(), user.getPassword());
            String loggedTitle = pharmacistPage.getTitleOfLoggedUser().getText();
            assertThat(loggedTitle, containsString(user.getFirstName()));
            assertThat(loggedTitle, containsString(user.getLastName()));
            pharmacistPage.clickLogout();
        });

    }
    @After
    public void afterTest(){
        driver.close();
    }
}
