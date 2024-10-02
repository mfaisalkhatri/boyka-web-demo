package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

public class BasePage {

    public BasePage() {
    }

    private final Locator pageHeader = Locator.buildLocator()
            .name("Page header")
            .web(By.cssSelector("#content h1"))
            .build();

    public void checkPageHeader() {
        ElementActions.onElement(pageHeader).verifyText().isEqualTo("Register Account");
    }

}
