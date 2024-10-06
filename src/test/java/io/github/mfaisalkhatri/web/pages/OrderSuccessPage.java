package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.drivers.DriverActions;
import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderSuccessPage {

    private final Locator continueBtn             = Locator.buildLocator ()
        .name ("Continue Button")
        .web (By.cssSelector ("div.buttons .btn-primary"))
        .build ();
    private final Locator orderSuccessMessageText = Locator.buildLocator ()
        .name ("Order Status Text")
        .web (By.cssSelector ("#content h1"))
        .build ();

    public OrderSuccessPage () {

    }

    public void checkOrderSuccessMessage () {

        DriverActions.withDriver ()
            .waitUntil (ExpectedConditions.textToBe (this.orderSuccessMessageText.getLocator (),
                "Your order has been placed!"));
    }

    public void continueToHomePage () {
        ClickableActions.withMouse (this.continueBtn)
            .click ();
    }

}
