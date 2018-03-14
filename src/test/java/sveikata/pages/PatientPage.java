package sveikata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientPage extends WebPage {


    public PatientPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "li[navbar-text] > h4")
    private WebElement loggedInPatientNameText;
    @FindBy(id = "logout")
    private WebElement logout;

    public WebElement getLoggedInPatientTitle(){
        return loggedInPatientNameText;
    }

    public void clickLogout(){
        logout.click();
    }

    @Override
    public String getUrl() {
        return null;
    }
}
