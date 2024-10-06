package io.github.mfaisalkhatri.web.pages;

import java.text.MessageFormat;

import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

public class SearchResultPage {

    private final Locator addToCartBtn            = Locator.buildLocator ()
        .name ("Add to cart button")
        .web (By.cssSelector (".cart-28"))
        .build ();
    private final Locator addToCartSuccessMessage = Locator.buildLocator ()
        .name ("Add to Cart Success Message")
        .web (By.cssSelector (".d-flex > p"))
        .build ();
    private final Locator productOne              = Locator.buildLocator ()
        .name ("Product One")
        .web (By.cssSelector (".product-layout"))
        .build ();
    private final Locator productOneName          = Locator.buildLocator ()
        .name ("Product One Name")
        .web (By.cssSelector (".caption h4"))
        .build ();
    private final Locator productOnePrice         = Locator.buildLocator ()
        .name ("Product One Price")
        .web (By.cssSelector (".caption .price span"))
        .build ();
    private final Locator viewCartBtn             = Locator.buildLocator ()
        .name ("View Cart button")
        .web (By.cssSelector (".form-row a.btn-primary"))
        .build ();

    public SearchResultPage () {

    }

    public void addProductToCart () {
        ClickableActions.withMouse (this.productOne)
            .hover ();
        ClickableActions.withMouse (this.addToCartBtn)
            .click ();
    }

    public void checkProductName (final String expectedProductName) {
        ElementActions.onElement (this.productOne)
            .verifyText ()
            .contains (expectedProductName);
    }

    public void checkSuccessMessageForProductAddedToCart () {
        ElementActions.onElement (this.addToCartSuccessMessage)
            .verifyText ()
            .isEqualTo (MessageFormat.format ("{0}\n{1}\n{2}\n{3}\n{4}", "Success: You have added", getProductName (),
                "to your", "shopping cart", "!"));
    }

    public String getProductName () {
        return ElementActions.onElement (this.productOneName)
            .getText ();
    }

    public String getProductPrice () {
        return ElementActions.onElement (this.productOnePrice)
            .getText ();
    }

    public ShoppingCartPage navigateToCart () {
        ClickableActions.withMouse (this.viewCartBtn)
            .click ();
        return new ShoppingCartPage ();
    }
}
