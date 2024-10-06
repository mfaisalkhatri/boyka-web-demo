package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.actions.elements.TextBoxActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

public class HomePage {

    public HomePage() {
    }

    private final Locator myAccountLink = Locator.buildLocator()
            .name("My account link")
            .web(By.cssSelector("#widget-navbar-217834 > ul > li:nth-child(6) > a"))
            .build();

    private final Locator loginLink = Locator.buildLocator()
            .name("Login link")
            .web(By.linkText("Login"))
            .build();

    private final Locator registerLink = Locator.buildLocator()
            .name("Register Link")
            .web(By.linkText("Register"))
            .build();
    private final Locator searchBox = Locator.buildLocator()
            .name("Search Box")
            .web(By.name("search"))
            .build();

    private final Locator searchBtn = Locator.buildLocator()
            .name("Search Button")
            .web(By.cssSelector(".type-text"))
            .build();

    private Locator cartCount = Locator.buildLocator()
            .name("Cart Count")
            .web(By.cssSelector("#entry_217825 > a:nth-child(1) > div:nth-child(1) > span"))
            .build();

    private Locator logout = Locator.buildLocator()
            .name("Logout link")
            .web(By.linkText("Logout"))
            .build();

    public RegistrationPage openRegistrationPage() {
        ClickableActions.withMouse(myAccountLink).hover();
        ClickableActions.withMouse(registerLink).click();
        return new RegistrationPage();
    }

    public SearchResultPage searchForProduct(String productName) {
        TextBoxActions.onTextBox(searchBox).enterText(productName);
        ClickableActions.withMouse(searchBtn).click();
        return new SearchResultPage();
    }

    public void checkTheCartCount(String expectedCount) {
        ElementActions.onElement(cartCount).verifyText().isEqualTo(expectedCount);
    }

    public void logout() {
        ClickableActions.withMouse(logout).click();
    }

    public LoginPage openLoginPage() {
        ClickableActions.withMouse(myAccountLink).hover();
        ClickableActions.withMouse(loginLink).click();
        return new LoginPage();
    }

}
