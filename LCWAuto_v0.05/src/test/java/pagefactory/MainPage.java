package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends PageObject{
    @FindBy(className = "searchButton")
    WebElement searchButton;

    @FindBy(id = "search_input")
    WebElement searchTxt;

    @FindBy(partialLinkText = "Giriş Yap")
    List<WebElement> loginLinks;

    @FindBy(className = "main-header-logo")
    WebElement mainLogoElement;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/header/div[2]/div/div[3]/div[2]/div[1]/button/span")
    WebElement loggedTxt;

    /*public Boolean isLoggedIn(){
        return loggedTxt.isDisplayed();
    }*/

    public String getLoggedTxt(){
        return loggedTxt.getText();
    }

    public Boolean isMainLogoDisplayed(){
        return mainLogoElement.isDisplayed();
    }

    public void enterSearch(){
        searchTxt.click();
        searchTxt.sendKeys("Pantolon");
        searchButton.click();
    }

    public void clickLoginButton(){
        loginLinks.get(0).click();
    }

    public MainPage(WebDriver driver){
        super(driver);
    }
}
