import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestiniumCase extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    LoginPage loginPage;

    CartPage cartPage;

    @Test
    @Order(1)
    public void searchProduct() throws InterruptedException {

        homePage = new HomePage(driver);
        homePage.checkUrl();

        productsPage =new ProductsPage(driver);

        homePage.searchBox().search("ceket");
        Thread.sleep(3000);

        Assertions.assertTrue(productsPage.isOnProductspage(),
                "NOT ON PRODUCTS PAGE!!");
        Thread.sleep(3000);
    }

    @Test
    @Order(2)
    public void scrollPage() throws InterruptedException {

        productsPage.scrollpage();

        Thread.sleep(3000);

    }

    @Test
    @Order(3)
    public void addProductToCart() throws InterruptedException {

        productsPage.addProduct(0);

    }

    @Test
    @Order(4)
    public void goToCartPage() {

        cartPage = new CartPage(driver);
        productsPage.goToCart();



    }

    @Test
    @Order(5)
    public void login() throws IOException {

        loginPage = new LoginPage(driver);
        loginPage.getData();
        loginPage.clickLogo();


    }


    @Test
    @Order(6)
    public void removeProduct(){

        homePage.clickBagIcon();
        homePage.removeProduct();


    }




}
