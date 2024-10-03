package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.drivers.DriverActions;
import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderSuccessPage {


    public OrderSuccessPage() {

    }

    private Locator orderSuccessMessageText = Locator.buildLocator()
            .name("Order Status Text")
            .web(By.cssSelector("#content h1"))
            .build();

    private Locator continueBtn = Locator.buildLocator()
            .name("Continue Button")
            .web(By.cssSelector("div.buttons .btn-primary"))
            .build();

    public void checkOrderSuccessMessage() {

        DriverActions.withDriver().waitUntil(ExpectedConditions.textToBe(orderSuccessMessageText.getLocator(), "Your order has been placed!"));

    }

    public void continueToHomePage() {
        ClickableActions.withMouse(continueBtn).click();
    }

}
