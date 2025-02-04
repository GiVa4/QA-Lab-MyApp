package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainScreen extends PageObject {
    int i = 1;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"App logo and name\"]")
    private WebElement tvTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productRV")
    private WebElement rvProductsContainer;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement rvCart;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]")
    private List rvProducts;

    public boolean isTitleDisplayed() {
        waitFor(ExpectedConditions.visibilityOf(tvTitle));
        return tvTitle.isDisplayed();
    }

    public boolean isProductsContainerDisplayed() {
        waitFor(ExpectedConditions.visibilityOf(rvProductsContainer));
        return rvProductsContainer.isDisplayed();
    }

    public void findProductByName(String productName) {
        click(rvProducts.get())
        String productXpath = String.format("//android.widget.TextView[contains(@text, '%s')]", productName);
        WebElement productTitle = waitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath(productXpath)));
        productTitle.findElement(By.xpath("./ancestor::android.view.ViewGroup")).click();
    }

    public void goToCart() {
        waitFor(ExpectedConditions.visibilityOf(rvCart));
        rvCart.click();
    }

}
