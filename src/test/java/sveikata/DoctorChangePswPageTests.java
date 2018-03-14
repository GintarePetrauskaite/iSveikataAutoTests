package sveikata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sveikata.pages.DoctorChangePswPage;
import sveikata.pages.DoctorPage;
import sveikata.pages.HomePage;
import sveikata.pages.LoginForSystemUsersPage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DoctorChangePswPageTests extends BasicTest{

    private WebDriver driver;
    private HomePage homePage;
    private LoginForSystemUsersPage loginForSystemUsersPage;
    private DoctorPage doctorPage;
    private DoctorChangePswPage doctorChangePswPage;

    @Before
    public void beforeTest(){
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        loginForSystemUsersPage = new LoginForSystemUsersPage(driver);
        doctorPage = new DoctorPage(driver);
        doctorChangePswPage = new DoctorChangePswPage(driver);

        driver.get(homePage.getUrl());
        homePage.goToLoginForSystemUsers();
        loginForSystemUsersPage.login("WerBur415","9w29rr0u");
        doctorPage.goToChangePasswordForm();
    }
    @Test
    public void changePasswordWorksCorrectly(){
        doctorChangePswPage.inputOldPassword("9w29rr0u");
        doctorChangePswPage.inputNewPassword("naujas1234");
        doctorChangePswPage.inputRepeatNewPassword("naujas1234");
        doctorChangePswPage.clickSubmitBtn();
        assertThat(doctorChangePswPage.getSuccessMsg().isDisplayed(), is(true));
        assertThat(doctorChangePswPage.getSuccessMsg().getText(), is(""));
    }
    @After
    public void afterTest(){
        driver.close();
    }
}
