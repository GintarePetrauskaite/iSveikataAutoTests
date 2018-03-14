package sveikata.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebPage {

    private static String URL = "http://localhost:8080/#";

    @FindBy(id = "loginPatient")
    private WebElement loginForPatientsLink;
    @FindBy(id = "loginUsers")
    private WebElement loginForSystemUsersLink;
    @FindBy(id = "publicStatistic")
    private WebElement publicStatisticsLink;
    @FindBy(id = "publicPatient")
    private WebElement loginForPatientButton;
    @FindBy(id = "publicUsers")
    private WebElement loginForUsersButton;
    @FindBy(id = "publicStatistic")
    private WebElement statisticsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void goToLoginForPatients(){
        loginForPatientsLink.click();
    }

    public void goToLoginForSystemUsers(){
        loginForSystemUsersLink.click();
    }

    public void goToStatisticsPage(){
        statisticsButton.click();
    }
    public WebElement getLoginForPatientsLink(){
        return loginForPatientsLink;
    }

    public WebElement getLoginForPatientButton() {
        return loginForPatientButton;
    }

    public WebElement getPublicStatisticsLink() {
        return publicStatisticsLink;
    }

    public WebElement getStatisticsButton() {
        return statisticsButton;
    }

    public WebElement getLoginForSystemUsersLink() {
        return loginForSystemUsersLink;
    }

    public WebElement getLoginForUsersButton() {
        return loginForUsersButton;
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
