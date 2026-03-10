package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    By product1 = By.id("add-to-cart-sauce-labs-backpack");
    By product2 = By.id("add-to-cart-sauce-labs-bike-light");

    By cartBtn = By.className("shopping_cart_link");

    public void addProducts() {

        driver.findElement(product1).click();
        driver.findElement(product2).click();
    }

    public void goToCart() {
        driver.findElement(cartBtn).click();
    }

}