import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;

public class ProductsPage extends BasePage {

    By resultsLocator = By.className("resultInfo");

    By sizeLocator = By.xpath("//*[@id=\"product-137159\"]/div/div[1]/div/div/div");

    JavascriptExecutor js = (JavascriptExecutor)driver;


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductspage() {

        return isDisplayed(resultsLocator);
    }

    public void scrollpage() throws InterruptedException {



      js.executeScript("window.scrollBy(0,17500)");


            Thread.sleep(1000L);


        driver.findElement(By.xpath("//*[@id=\"pagedListContainer\"]/div[2]/div[2]/button")).click();
        System.out.println("Second Page: " + driver.getCurrentUrl());


            Thread.sleep(2000L);


        WebElement price = driver.findElement(By.xpath("//div[@id='product-115346']//div[@class='product__sizeItem']//div[5]//label[1]"));



        js.executeScript("arguments[0].scrollIntoView();", price);


            Thread.sleep(1000L);

        Actions actions = new Actions(driver);
        actions.moveToElement(price).perform();

    }

    private List<WebElement> getAllProduct() {
        return findAll(sizeLocator);

    }
    public void addProduct(int i) {

        getAllProduct().get(i).click();

        driver.findElement(By.xpath("//a[@class='button -primary header__basket--checkout header__basketModal -checkout']")).click();

    }





    public void goToCart() {

        driver.findElement(By.xpath("//button[@class='continueButton n-button large block text-center -primary']")).click();


    }


}