import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){ this.driver = driver; }

    public WebElement find(By locator){ return driver.findElement(locator); }

    public List<WebElement> findAll(By locator){ return driver.findElements(locator); }

    public void click(By locator){ find(locator).submit();}

    public void type(By locator, String text){ find(locator).sendKeys(text);}

    public Boolean isDisplayed(By locator){ return find(locator).isDisplayed();}




}
