package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

public class ShoppingCartPage {

    public ShoppingCartPage() {

    }

    private Locator productName = Locator.buildLocator()
            .name("Product Name in Shopping cart")
            .web(By.cssSelector("#content .table-responsive .table td:nth-child(2) a"))
            .build();

    private Locator productPrice = Locator.buildLocator()
            .name("Product Total Price in Cart")
            .web(By.cssSelector("td.text-right:nth-child(6)"))
            .build();

    private Locator cartTotalAmount = Locator.buildLocator()
            .name("Shopping Cart Total Amount")
            .web(By.cssSelector("table.m-0 > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2) > strong"))
            .build();

    private Locator checkoutBtn = Locator.buildLocator()
            .name("Checkout button")
            .web(By.cssSelector(".buttons a.btn-primary"))
            .build();


    public void checkProductName(String expectedProductName) {
        ElementActions.onElement(productName).verifyText().isEqualTo(expectedProductName);
    }

    public void checkProductPrice(String expectedProductPrice) {
        ElementActions.onElement(productPrice).verifyText().isEqualTo(expectedProductPrice);
    }

    public void checkCartTotalAmount(String expectedTotalAmount) {
        ElementActions.onElement(cartTotalAmount).verifyText().isEqualTo(expectedTotalAmount);
    }

    public CheckoutPage navigateToCheckoutPage() {
        ClickableActions.withMouse(checkoutBtn).click();
        return new CheckoutPage();
    }



}
