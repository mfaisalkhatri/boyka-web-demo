package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

public class ShoppingCartPage {

    private final Locator cartTotalAmount = Locator.buildLocator ()
        .name ("Shopping Cart Total Amount")
        .web (By.cssSelector ("table.m-0 > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2) > strong"))
        .build ();
    private final Locator checkoutBtn     = Locator.buildLocator ()
        .name ("Checkout button")
        .web (By.cssSelector (".buttons a.btn-primary"))
        .build ();
    private final Locator productName     = Locator.buildLocator ()
        .name ("Product Name in Shopping cart")
        .web (By.cssSelector ("#content .table-responsive .table td:nth-child(2) a"))
        .build ();
    private final Locator productPrice    = Locator.buildLocator ()
        .name ("Product Total Price in Cart")
        .web (By.cssSelector ("td.text-right:nth-child(6)"))
        .build ();

    public ShoppingCartPage () {

    }

    public void checkCartTotalAmount (final String expectedTotalAmount) {
        ElementActions.onElement (this.cartTotalAmount)
            .verifyText ()
            .isEqualTo (expectedTotalAmount);
    }

    public void checkProductName (final String expectedProductName) {
        ElementActions.onElement (this.productName)
            .verifyText ()
            .isEqualTo (expectedProductName);
    }

    public void checkProductPrice (final String expectedProductPrice) {
        ElementActions.onElement (this.productPrice)
            .verifyText ()
            .isEqualTo (expectedProductPrice);
    }

    public CheckoutPage navigateToCheckoutPage () {
        ClickableActions.withMouse (this.checkoutBtn)
            .click ();
        return new CheckoutPage ();
    }

}
