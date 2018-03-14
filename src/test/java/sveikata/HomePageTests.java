package sveikata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sveikata.pages.HomePage;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageTests extends BasicTest {

    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void beforeTest() {
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        driver.get(homePage.getUrl());
    }

    @Test
    public void allRequiredElementsDisplayed(){
        assertThat(homePage.getLoginForPatientButton().isDisplayed(), is(true));
        assertThat(homePage.getLoginForPatientButton().isEnabled(), is(true));
        assertThat(homePage.getStatisticsButton().isDisplayed(), is(true));
        assertThat(homePage.getStatisticsButton().isEnabled(), is(true));
        assertThat(homePage.getLoginForUsersButton().isDisplayed(), is(true));
        assertThat(homePage.getLoginForUsersButton().isEnabled(), is(true));
        assertThat(homePage.getLoginForPatientsLink().isDisplayed(), is(true));
        assertThat(homePage.getLoginForPatientsLink().isDisplayed(), is(true));
        assertThat(homePage.getPublicStatisticsLink().isDisplayed(), is(true));
    }
    @After
    public void afterTest(){
        driver.close();
    }

}
