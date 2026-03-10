package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class POSFlowTest extends BaseTest {

    @Test
    public void createSaleTest(){

        test = extent.createTest("Create Sale Test");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProducts();
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.checkout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.completeCheckout();

        Assert.assertEquals(
                checkout.getConfirmationMessage(),
                "Thank you for your order!",
                "Order not completed"
        );

        test.pass("Order completed successfully");
    }
}