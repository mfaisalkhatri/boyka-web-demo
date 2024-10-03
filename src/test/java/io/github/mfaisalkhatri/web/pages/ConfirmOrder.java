package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

public class ConfirmOrder extends BasePage {

    public ConfirmOrder() {
    }

    private Locator productName = Locator.buildLocator().
            name("Product Name")
            .web(By.cssSelector(".table-bordered > tbody:nth-child(2) > tr:nth-child(1) > td:first-child"))
            .build();

    private Locator productPrice = Locator.buildLocator()
            .name("Product Price")
            .web(By.cssSelector(".table-bordered > tbody:nth-child(2) > tr:nth-child(1) > td:last-child"))
            .build();

    private Locator confirmOrderBtn = Locator.buildLocator()
            .name("Confirm Order button")
            .web(By.cssSelector("button#button-confirm"))
            .build();


    public void checkPageHeader() {
        ElementActions.onElement(pageHeader).verifyText().isEqualTo("Confirm Order");
    }

    public void checkProductName(String expectedProductName) {
        ElementActions.onElement(productName).verifyText().isEqualTo(expectedProductName);

    }

    public void checkProductPrice(String expectedProductPrice) {
        ElementActions.onElement(productPrice).verifyText().isEqualTo(expectedProductPrice);
    }

    public OrderSuccessPage confirmOrder() {
        ClickableActions.withMouse(confirmOrderBtn).click();
        return new OrderSuccessPage();
    }


}
