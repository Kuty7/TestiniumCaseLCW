package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
    @FindBy(id = "LoginEmail")
    WebElement loginTxt;

    @FindBy(id = "Password")
    WebElement passwordTxt;

    @FindBy(id = "loginLink")
    WebElement loginFormSendButton;

    public void loginToAccount(String email, String password){
        loginTxt.click();
        loginTxt.sendKeys(email);

        passwordTxt.click();
        passwordTxt.sendKeys(password);

        loginFormSendButton.click();
    }

    public LoginPage(WebDriver driver){
        super(driver);
    }
}
