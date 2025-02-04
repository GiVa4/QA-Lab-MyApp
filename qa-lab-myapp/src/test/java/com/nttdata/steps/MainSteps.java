package com.nttdata.steps;

import com.nttdata.screens.CartScreen;
import com.nttdata.screens.MainScreen;
import com.nttdata.screens.ProductsScreen;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class MainSteps {

    MainScreen mainScreen;
    ProductsScreen productsScreen;
    CartScreen cartScreen;

    public void validateSession() {
        Assert.assertTrue(mainScreen.isTitleDisplayed());
    }

    public void validateProductList() {
        Assert.assertTrue(mainScreen.isProductsContainerDisplayed());
    }

    public void findProduct(String productName) {
        mainScreen.selectProduct(productName);
    }

    public void setQuantity(int quantity) {
        for (int i = 0; i < quantity-1; i++) {
            productsScreen.selectQuantity();
        }
        addProduct();
    }

    public void addProduct() {
        productsScreen.clickAddToCart();
    }

    public void clickShoppingCart() {
        mainScreen.goToCart();
    }

    public void validateShoppingCart() {
        Assert.assertTrue(cartScreen.isProductOnCart());
    }
}
