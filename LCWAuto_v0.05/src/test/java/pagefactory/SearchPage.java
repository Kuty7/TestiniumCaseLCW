package pagefactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.List;
import java.util.Random;

public class SearchPage extends PageObject{

    Random rn = new Random();

    //int productNum = rn.nextInt();
    //List<WebElement> pictureBoxes = new ArrayList<WebElement>();

    @FindBy(className = "lazy-load-button")
    WebElement seeMoreProductsButton;

    @FindBy(className = "picture-box")
    List<WebElement> pictureBoxes;

    /*int pictureBoxesSize = pictureBoxes.size();
    int productNum = rn.nextInt(pictureBoxesSize);*/

    /*public int productSelection(){
        int num = rn.nextInt(pictureBoxes.size() - 1);
        return num;
    }
    public void findRandomProductIndex(int num){
        num = productSelection();
    }*/

    public void selectProduct(int indexHolder){
        //pictureBoxes.get(rndIndex - 1).click();

        indexHolder = rn.nextInt(pictureBoxes.size() - 1);

        pictureBoxes.get(indexHolder).click();
    }

    public void clickSeeMoreProductsButton(){
        seeMoreProductsButton.click();
    }

    public void ScrollDown(){
        ((JavascriptExecutor)driver).executeScript("scroll(0,10000)");
    }

    public SearchPage(WebDriver driver){
        super(driver);
    }
}
