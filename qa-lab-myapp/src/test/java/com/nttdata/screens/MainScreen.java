package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
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

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup[1]")
    private WebElement rvProduct1;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup[2]")
    private WebElement rvProduct2;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup[3]")
    private WebElement rvProduct3;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']")
    private WebElement rvProductList;

    public int getProductCount() {
        waitFor(ExpectedConditions.visibilityOf(rvProductList));
        List<WebElement> productElements = rvProductList.findElements(By.xpath(".//android.widget.TextView"));
        return productElements.size();
    }

    public boolean isTitleDisplayed() {
        waitFor(ExpectedConditions.visibilityOf(tvTitle));
        return tvTitle.isDisplayed();
    }

    public boolean isProductsContainerDisplayed() {
        waitFor(ExpectedConditions.visibilityOf(rvProductsContainer));
        return rvProductsContainer.isDisplayed();
    }

    public void clickOnProductByName(String productName) {
        switch (productName) {
            case "Sauce Labs Backpack":
                waitFor(ExpectedConditions.visibilityOf(rvProduct1));
                rvProduct1.click(); break;
            case "Sauce Labs Bike Light":
                waitFor(ExpectedConditions.visibilityOf(rvProduct2));
                rvProduct2.click(); break;
            case "Sauce Labs Bolt - T-Shirt":
                waitFor(ExpectedConditions.visibilityOf(rvProduct3));
                rvProduct3.click(); break;
            default:
                throw new IllegalArgumentException("Producto no encontrado: " + productName);
        }
    }


    public void goToCart() {
        waitFor(ExpectedConditions.visibilityOf(rvCart));
        rvCart.click();
    }

}
