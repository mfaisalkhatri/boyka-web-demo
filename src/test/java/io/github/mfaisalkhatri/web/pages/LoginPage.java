package io.github.mfaisalkhatri.web.pages;


import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.actions.elements.TextBoxActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.bidi.script.LocalValue;


public class LoginPage {

    public LoginPage() {
    }

    private Locator loginBoxTitle = Locator.buildLocator()
            .name("Login box title")
            .web(By.cssSelector(".col-lg-6:nth-child(2) h2"))
            .build();

    private Locator emailAddressField = Locator.buildLocator()
            .name("Email Address field")
            .web(By.id("input-email"))
            .build();

    private Locator passwordField = Locator.buildLocator()
            .name("Password field")
            .web(By.id("input-password"))
            .build();

    private Locator loginBtn = Locator.buildLocator()
            .name("Login button")
            .web(By.cssSelector("input.btn"))
            .build();

    private Locator alertMessage = Locator.buildLocator()
            .name("Login alert message")
            .web(By.cssSelector("#account-login .alert"))
            .build();

    public void checkLoginBoxTitle() {
        ElementActions.onElement(loginBoxTitle).verifyText().isEqualTo("Returning Customer");
    }

    public void checkWarningMessage() {
        ElementActions.onElement(alertMessage).verifyText().isEqualTo("Warning: No match for E-Mail Address and/or Password.");
    }

    public void performLogin (String username, String password) {
        TextBoxActions.onTextBox(emailAddressField).clear();
        TextBoxActions.onTextBox(emailAddressField).enterText(username);
        TextBoxActions.onTextBox(passwordField).clear();
        TextBoxActions.onTextBox(passwordField).enterText(password);
        ClickableActions.withMouse(loginBtn).click();
    }
}
