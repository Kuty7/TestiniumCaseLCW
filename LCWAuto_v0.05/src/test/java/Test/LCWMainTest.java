package Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pagefactory.*;

import java.util.concurrent.TimeUnit;

public class LCWMainTest
{
    @Test
    public void lcwMainTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/user/Documents/Selenium Dependencies/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SearchPage searchPage = new SearchPage(driver);
        ProductPage productPage = new ProductPage(driver);
        BasketPage basketPage = new BasketPage(driver);

        driver.get("https://www.lcwaikiki.com/tr-TR/TR");

        Assertions.assertTrue(mainPage.isMainLogoDisplayed());

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        ////Email Adress.
        String emailAdress = "kutyozbek@gmail.com";
        ////Password.
        String passwordKeys = "deneme123";
        ////Selected Product Index Holder.
        int productIndex = 0;
        ////Product Page Price Holder.
        String productPagePrice = "Did not set";
        ////Basket Page Price Holder.
        String basketPagePrice = "Did not set";


        mainPage.clickLoginButton();

        loginPage.loginToAccount(emailAdress, passwordKeys);

        Thread.sleep(2000);
        //Assertions.assertTrue(mainPage.isLoggedIn());
        Assertions.assertEquals("Hesabım", mainPage.getLoggedTxt(), "Not Logged in!");

        mainPage.enterSearch();

        searchPage.ScrollDown();
        searchPage.clickSeeMoreProductsButton();
        //searchPage.findRandomProductIndex(productIndex);
        searchPage.selectProduct(productIndex);

        //productPage.setPriceHolder();
        productPagePrice = productPage.getPriceHolder();

        //System.out.println(productPagePrice);

        productPage.clickSizeButtons();
        productPage.clickAddToCartButton();
        productPage.clickBasketPageButton();

        basketPagePrice = basketPage.getBasketPriceHolder();

        //System.out.println(basketPagePrice);

        Assertions.assertEquals(productPagePrice, basketPagePrice,"Prices did not match!");

        basketPage.clickAddButton();

        //System.out.println(basketPage.getQuantityTxt());

        Assertions.assertEquals("2", basketPage.getQuantityTxt(),"Product quantity did not set to 2");

        Thread.sleep(3000);
        basketPage.clickDeleteButton();

        Thread.sleep(3000);
        basketPage.clickInvertedDeleteButton();

        Assertions.assertTrue(basketPage.getDeletedTxt());

        //Assertions.assertEquals("Sepetinizde ürün bulunmamaktadır.", basketPage.getDeletedTxt(),"Product has not been deleted!");

        //((JavascriptExecutor)driver).executeScript("scroll(0,600)");

        driver.close();
    }

    /*public void ScrollPage(){
        ((JavascriptExecutor))
    }*/

}
