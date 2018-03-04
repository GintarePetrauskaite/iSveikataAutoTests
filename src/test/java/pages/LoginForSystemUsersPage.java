package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginForSystemUsersPage extends WebPage {

    private static String URL = "http://localhost:3000/#/vartotojams";

    public LoginForSystemUsersPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "loginFormFirstInput")
    private WebElement usernameInput;

    @FindBy(id = "loginFormSecondInput")
    private WebElement passwordInput;

    @FindBy(id = "loginFomrSubmit")
    private WebElement submitButton;

    public void loginAsAdmin(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
    }


    @Override
    public String getUrl() {
        return URL;
    }
}
