package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

public class HomePage {

    public HomePage() {
    }

    private final Locator myAccountLink = Locator.buildLocator()
            .name("My account link")
            .web(By.cssSelector("#widget-navbar-217834 > ul > li:nth-child(6) > a"))
            .build();

    private final Locator registerLink = Locator.buildLocator()
            .name("Register Link")
            .web(By.linkText("Register"))
            .build();

    public RegistrationPage openRegistrationPage() {
        ClickableActions.withMouse(myAccountLink).click();
        ClickableActions.withMouse(registerLink).click();
        return new RegistrationPage();
    }

}
