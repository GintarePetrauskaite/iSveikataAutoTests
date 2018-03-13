package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PharmacistPage extends WebPage {

    private String URL = "http://localhost:3000/#/druggist";

    public PharmacistPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "li > h4")
    private WebElement firstNameLastNameTitle;
    @FindBy(id = "logout")
    private WebElement logoutLink;
    @FindBy(id = "searchFormInput")
    private WebElement searchIdInput;
    @FindBy(css = "div.col-sm-12 > h3")
    private WebElement infoMsg;
    @FindBy(id = "searchFormSubmit")
    private WebElement searchSubmitButton;
    @FindBy(id = "druggistPassword")
    private WebElement changePasswordLink;
    @FindBy(id = "oldPassword")
    private WebElement oldPasswordInput;
    @FindBy(id = "newPassword")
    private WebElement newPasswordInput;
    @FindBy(id = "newPasswordRepeat")
    private WebElement newPasswordRepeatInput;

    public WebElement getTitleOfLoggedUser(){
        return firstNameLastNameTitle;
    }
    public void clickLogout(){
        logoutLink.click();
    }
    public void searchForPatient(String id){
        searchIdInput.sendKeys(id);
    }
    public WebElement getInfoMsg(){
        return infoMsg;
    }
    public void clickSearchSubmitBtn(){
        searchSubmitButton.click();
    }
    public void goToChangePasswordForm(){
        changePasswordLink.click();
    }
    public void sendOldPassword(String oldPassword){
        oldPasswordInput.sendKeys(oldPassword);
    }
    public void sendNewPassword(String newPassword){
        newPasswordInput.sendKeys(newPassword);
    }
    public void sendNewPasswordRepeat(String newPasswordRepeat){
        newPasswordRepeatInput.sendKeys(newPasswordRepeat);
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
