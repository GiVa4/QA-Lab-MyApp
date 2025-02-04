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
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

        try {
            for (int i = 1; i <= getProductCount(); i++) {
                WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(getProductPath(i))
                ));

                List<WebElement> titles = product.findElements(By.id("com.saucelabs.mydemoapp.android:id/titleTV"));

                if (!titles.isEmpty() && titles.get(0).getText().equalsIgnoreCase(productName)) {
                    wait.until(ExpectedConditions.elementToBeClickable(product)).click();
                    return;
                }
            }
            System.out.println("⚠ Producto no encontrado: " + productName);
        } catch (Exception e) {
            System.out.println("❌ Error al buscar producto: " + e.getMessage());
        }
    }

    public String getProductPath(int index){
        String path;
        path = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup["+index+"]";
        return path;
    }


    public void goToCart() {
        waitFor(ExpectedConditions.visibilityOf(rvCart));
        rvCart.click();
    }

}
