package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.drivers.DriverActions;
import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static io.github.boykaframework.actions.elements.ElementActions.onElement;

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

        DriverActions.withDriver().waitUntil(d -> onElement(orderSuccessMessageText).getText().equals("Your order has been successfully placed!"));

        //onElement(orderSuccessMessageText).verifyText().isEqualTo("Your order has been successfully placed!");
    }

    public void continueToHomePage() {
        ClickableActions.withMouse(continueBtn).click();
    }

}
