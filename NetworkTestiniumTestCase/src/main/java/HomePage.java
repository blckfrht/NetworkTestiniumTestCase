import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    private String url="https://www.network.com.tr/";

    SearchBox searchBox;


    public HomePage(WebDriver driver) {

        super(driver);
        searchBox = new SearchBox(driver);
    }


    public SearchBox searchBox() {

        return searchBox;
    }


    private String currentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    public void checkUrl() {
        Assert.assertEquals(url, currentUrl());

    }


    public void clickBagIcon() {
        WebElement bagIcon = driver.findElement(By.xpath("//button[@class='header__basketTrigger js-basket-trigger -desktop']//*[name()='svg']"));

        bagIcon.click();


    }

    public void removeProduct(){

        WebElement removeButton = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/*[name()='svg'][1]/*[name()='use'][1]"));

        removeButton.click();

    }


}
