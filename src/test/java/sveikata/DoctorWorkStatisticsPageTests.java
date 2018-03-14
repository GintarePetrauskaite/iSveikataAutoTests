package sveikata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sveikata.pages.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

public class DoctorWorkStatisticsPageTests extends BasicTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginForSystemUsersPage loginForSystemUsersPage;
    private DoctorPage doctorPage;
    private DoctorWorkStatisticsPage doctorWorkStatisticsPage;

    @Before
    public void beforeTest(){
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        loginForSystemUsersPage = new LoginForSystemUsersPage(driver);
        doctorPage = new DoctorPage(driver);
        doctorWorkStatisticsPage = new DoctorWorkStatisticsPage(driver);

        driver.get(homePage.getUrl());
        homePage.goToLoginForSystemUsers();
        loginForSystemUsersPage.login("VarMed186", "w3w2k0f0");
        doctorPage.goToStatisticsPage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void doctorStatisticsIsDisplayed(){
        doctorWorkStatisticsPage.inputStartDate("2018-03-01");
        doctorWorkStatisticsPage.inputEndDate("2018-03-13");
        doctorWorkStatisticsPage.clickSubmitButton();
        assertThat(doctorWorkStatisticsPage.getChart().isDisplayed(), is(true));
    }
    @After
    public void afterTest(){
        driver.close();
    }
}

