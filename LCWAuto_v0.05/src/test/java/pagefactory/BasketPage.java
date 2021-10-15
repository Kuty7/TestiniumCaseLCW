package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends PageObject{
    @FindBy(xpath = "//*[@id=\"ShoppingCartContent\"]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/span")
    WebElement basketPrice;

    @FindBy(partialLinkText = "+")
    WebElement addButton;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/input")
    WebElement quantityTxt;

    /*@FindBy(partialLinkText = "Sil")
    WebElement deleteButton;*/

    @FindBy(className = "cart-square-link")
    List<WebElement> delFavButtons;
    //WebElement deleteButton;

    @FindBy(partialLinkText = "Sil")
    WebElement invertedDeleteButton;

    @FindBy(className = "cart-empty-title")
    WebElement deletedTxt;

    public Boolean getDeletedTxt(){
        return deletedTxt.isDisplayed();
    }

    public void clickInvertedDeleteButton(){
        invertedDeleteButton.click();
    }

    public void clickDeleteButton(){
        delFavButtons.get(0).click();
        //deleteButton.click();
    }

    public void clickAddButton(){
        addButton.click();
    }

    public String getQuantityTxt(){
        return quantityTxt.getAttribute("value");
    }

    public String getBasketPriceHolder(){
        return basketPrice.getText();
    }

    public BasketPage(WebDriver driver){
        super(driver);
    }
}
