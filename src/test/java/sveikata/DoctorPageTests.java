package sveikata;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sveikata.pages.DoctorPage;
import sveikata.pages.HomePage;
import sveikata.pages.LoginForSystemUsersPage;

public class DoctorPageTests extends BasicTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginForSystemUsersPage loginForSystemUsersPage;
    private DoctorPage doctorPage;

    @Before
    public void beforeTest(){
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        loginForSystemUsersPage = new LoginForSystemUsersPage(driver);
        doctorPage = new DoctorPage(driver);

        driver.get(homePage.getUrl());
        homePage.goToLoginForSystemUsers();
        loginForSystemUsersPage.login("VarMed186", "w3w2k0f0");
    }

    @Test
    public void checkAllElementsAreDisplayed(){
        assertThat(doctorPage.getViewPatientListButton().isDisplayed(), is(true));
        assertThat(doctorPage.getViewPatientListButton().isEnabled(), is(true));

        assertThat(doctorPage.getViewWorkStatistics().isDisplayed(), is(true));
        assertThat(doctorPage.getViewWorkStatistics().isEnabled(), is(true));

        assertThat(doctorPage.getChangePasswordButton().isDisplayed(), is(true));
        assertThat(doctorPage.getChangePasswordButton().isEnabled(), is(true));
    }
    @After
    public void afterTest(){
        driver.close();
    }
}
