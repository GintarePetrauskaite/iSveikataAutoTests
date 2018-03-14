package sveikata;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sveikata.pages.DoctorPage;
import sveikata.pages.DoctorPatientListPage;
import sveikata.pages.HomePage;
import sveikata.pages.LoginForSystemUsersPage;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DoctorPatientListPageTests extends BasicTest{

    private WebDriver driver;
    private HomePage homePage;
    private LoginForSystemUsersPage loginForSystemUsersPage;
    private DoctorPage doctorPage;
    private DoctorPatientListPage doctorPatientListPage;

    @Before
    public void beforeTest(){
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        loginForSystemUsersPage = new LoginForSystemUsersPage(driver);
        doctorPage = new DoctorPage(driver);
        doctorPatientListPage = new DoctorPatientListPage(driver);

        driver.get(homePage.getUrl());
        homePage.goToLoginForSystemUsers();
        loginForSystemUsersPage.login("VarMed186", "w3w2k0f0");
        doctorPage.goToPatientList();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void exportPatientList(){
        assertThat(doctorPatientListPage.getGeneratePatientListBtn().isDisplayed(), is(true));
        doctorPatientListPage.clickOnGenerateListBtn();
        assertThat(doctorPatientListPage.getDownloadListBtn().isDisplayed(), is(true));
        doctorPatientListPage.clickDownloadListBtn();
    }
    @Test
    public void addNewRecord(){
        doctorPatientListPage.selectToViewFirstPatient("39410104187");
        doctorPatientListPage.clickNewRecordInsidePatient();
        doctorPatientListPage.selectIcdCode("A04 - Kitos bakterijų sukeltos žarnyno infekcijos");
        doctorPatientListPage.fillInRecord("Tai yra naujo ligos įrašo aprašymas.");
        doctorPatientListPage.checkCompensatedCheckbox();
        doctorPatientListPage.checkRepeatVisitCheckbox();
        doctorPatientListPage.inputVisitDuration("25");
        doctorPatientListPage.clickLabel();
        doctorPatientListPage.clickSubmitBtn();
        assertThat(doctorPatientListPage.getSuccessMsg().isDisplayed(), is(true));
        assertThat(doctorPatientListPage.getSuccessMsg().getText(), is("Naujas įrašas sėkmingai sukurtas"));
    }
    @Test
    public void addNewPrescription(){
        doctorPatientListPage.selectToViewFirstPatient("39410104187");
        doctorPatientListPage.clickNewPrescriptionInsidePatient();
        doctorPatientListPage.selectValidityPeriod("neterminuotas");
        doctorPatientListPage.selectSubstance("Sirolimuzas");
        doctorPatientListPage.inputSubtanceAmount("20");
        doctorPatientListPage.inputPrescriptionDescription("Vartoti kasdien po vieną kapsulę valgio metu");
        doctorPatientListPage.clickSubmitBtn();
        assertThat(doctorPatientListPage.getSuccessMsg().isDisplayed(), is(true));
        assertThat(doctorPatientListPage.getSuccessMsg().getText(), is("Naujas receptas sėkmingai sukurtas."));
    }

    @After
    public void afterTest(){
        driver.close();
    }

}
