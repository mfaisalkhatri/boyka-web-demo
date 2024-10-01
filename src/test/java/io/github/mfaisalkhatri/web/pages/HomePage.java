package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

public class HomePage {

    private static final HomePage HOME_PAGE = new HomePage();

    public static HomePage homePage() {
        return HOME_PAGE;
    }

    private final Locator myAccountLink = Locator.buildLocator()
            .name("My account link")
            .web(By.cssSelector("#widget-navbar-217834 > ul > li:nth-child(6) > a"))
            .build();

    private final Locator registerLink = Locator.buildLocator()
            .name("Register Link")
            .web(By.linkText("Register"))
            .build();

    public void openRegistrationPage() {
        ClickableActions.withMouse(myAccountLink).hover();
        ClickableActions.withMouse(registerLink).click();

    }

}
