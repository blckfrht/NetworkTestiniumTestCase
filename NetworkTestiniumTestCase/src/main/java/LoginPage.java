import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);

    }
    public void getData() throws IOException {

        String path = "src\\data.csv";
        String line = "";


        BufferedReader br = new BufferedReader(new FileReader(path));

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
//                System.out.println("email: " + values[0] + " //// password: " + values[1]);
            WebElement emailBox = driver.findElement(By.xpath("//input[@id='n-input-email']"));

            emailBox.sendKeys(values[0]);

            WebElement passwordBox =driver.findElement(By.xpath("//input[@id='n-input-password']"));

            passwordBox.sendKeys(values[1]);

            WebElement loginButton =driver.findElement(By.xpath("//button[@type='submit']"));

            loginButton.click();

        }
    }

    public void clickLogo() {
        WebElement logo = driver.findElement(By.xpath("//a[@class='header__logo']//*[name()='svg']"));
        logo.click();
    }
}
