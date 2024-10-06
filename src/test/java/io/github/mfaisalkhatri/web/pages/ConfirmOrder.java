package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

public class ConfirmOrder extends BasePage {

    private final Locator confirmOrderBtn = Locator.buildLocator ()
        .name ("Confirm Order button")
        .web (By.cssSelector ("button#button-confirm"))
        .build ();
    private final Locator productName     = Locator.buildLocator ()
        .name ("Product Name")
        .web (By.cssSelector (".table-bordered > tbody:nth-child(2) > tr:nth-child(1) > td:first-child"))
        .build ();

    private final Locator productPrice = Locator.buildLocator ()
        .name ("Product Price")
        .web (By.cssSelector (".table-bordered > tbody:nth-child(2) > tr:nth-child(1) > td:last-child"))
        .build ();

    public ConfirmOrder () {
    }

    public void checkPageHeader () {
        ElementActions.onElement (this.pageHeader)
            .verifyText ()
            .isEqualTo ("Confirm Order");
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

    public OrderSuccessPage confirmOrder () {
        ClickableActions.withMouse (this.confirmOrderBtn)
            .click ();
        return new OrderSuccessPage ();
    }

}
