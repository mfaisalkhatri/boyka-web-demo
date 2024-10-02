package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

import java.text.MessageFormat;

public class SearchResultPage {

    public SearchResultPage() {

    }

    private Locator productOne = Locator.buildLocator()
            .name("Product One")
            .web(By.cssSelector(".product-layout"))
            .build();

    private Locator productOneName = Locator.buildLocator()
            .name("Product One Name")
            .web(By.cssSelector(".caption h4"))
            .build();

    private Locator productOnePrice = Locator.buildLocator()
            .name("Product One Price")
            .web(By.cssSelector(".caption .price span"))
            .build();

    private Locator addToCartBtn = Locator.buildLocator()
            .name("Add to cart button")
            .web(By.cssSelector("btn-cart.cart-28"))
            .build();

    private Locator addToCartSuccessMessage = Locator.buildLocator()
            .name("Add to Cart Success Message")
            .web(By.cssSelector(".d-flex > p"))
            .build();

    private Locator viewCartBtn = Locator.buildLocator()
            .name("View Cart button")
            .web(By.cssSelector(".form-row a.btn-primary"))
            .build();

    public void checkProductName(String expectedProductName) {
        ElementActions.onElement(productOne).verifyText().contains(expectedProductName);
    }

    public String getProductName() {
        return ElementActions.onElement(productOne).getText();
    }

    public String getProductPrice() {
        return ElementActions.onElement(productOnePrice).getText();
    }

    public void addProductToCart() {
        ClickableActions.withMouse(productOne).hover();
        ClickableActions.withMouse(addToCartBtn).click();
    }

    public void checkSuccessMessageForProductAddedToCart() {
        ElementActions.onElement(addToCartSuccessMessage).verifyText().isEqualTo(MessageFormat.format("{0}{1}{2}{3}", "Success: You have added ", productOneName, " to your ", "shopping cart!"));
    }

    public ShoppingCartPage navigateToCart() {
        ClickableActions.withMouse(viewCartBtn).click();
        return new ShoppingCartPage();
    }
}
