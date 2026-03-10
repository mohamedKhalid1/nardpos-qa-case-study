package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postal = By.id("postal-code");

    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");

    public void completeCheckout(){

        driver.findElement(firstName).sendKeys("Test");
        driver.findElement(lastName).sendKeys("User");
        driver.findElement(postal).sendKeys("12345");

        driver.findElement(continueBtn).click();
        driver.findElement(finishBtn).click();
    }

    public String getConfirmationMessage(){

        return driver.findElement(
                By.className("complete-header")).getText();
    }
}