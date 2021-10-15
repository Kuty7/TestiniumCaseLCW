package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends PageObject{

    List<WebElement> sizeButtons;

    @FindBy(id = "pd_add_to_cart")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"rightInfoBar\"]/div[1]/div/div[2]/div/div/div/span[2]")
    WebElement price;

    /*@FindBy(xpath = "/html/body/div[5]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[4]/div[1]/div[2]/div/div[1]/div[3]/a[1]")
    List<WebElement> sizeButtons;*/

    @FindBy(xpath = "/html/body/div[5]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[4]/div[1]/div[2]/div/div[1]/div[3]/a[1]")
    WebElement size1;

    @FindBy(xpath = "/html/body/div[5]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[4]/div[1]/div[2]/div/div[1]/div[3]/a[2]")
    WebElement size2;

    @FindBy(xpath = "/html/body/div[5]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[4]/div[1]/div[2]/div/div[1]/div[3]/a[3]")
    WebElement size3;

    @FindBy(partialLinkText = "Sepete Git")
    WebElement basketPageButton;

    /*public void clickFirstSizeButton(){
            if (firstSizeButton.isEnabled())
                firstSizeButton.click();
        }*/

    /*public void findSizeButtons(){

    }*/

    public void clickBasketPageButton(){
        basketPageButton.click();
    }

    public void clickSizeButtons(){
        /*while (true){

            if(sizeButtons.get(counter).isDisplayed()){
                if(sizeButtons.get(counter).isEnabled()){
                    sizeButtons.get(counter).click();
                }
            }

        }*/

        /*for (int i = 0; i < sizeButtons.size() - 1; i++){
            if(sizeButtons.get(i).isEnabled()){
                sizeButtons.get(i).click();
                break;
            }
        }*/

        if (size1.isEnabled())
            size1.click();
        if (size2.isEnabled())
            size2.click();
        if (size3.isEnabled())
            size3.click();
    }

    public String getPriceHolder(){
        //System.out.println(price.getText());
        return price.getText();
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public ProductPage(WebDriver driver){
        super(driver);
    }
}
