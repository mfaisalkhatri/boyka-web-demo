package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.actions.elements.TextBoxActions;
import io.github.boykaframework.builders.Locator;
import org.openqa.selenium.By;

public class LoginPage {

    private final Locator alertMessage      = Locator.buildLocator ()
        .name ("Login alert message")
        .web (By.cssSelector ("#account-login .alert"))
        .build ();
    private final Locator emailAddressField = Locator.buildLocator ()
        .name ("Email Address field")
        .web (By.id ("input-email"))
        .build ();
    private final Locator loginBoxTitle     = Locator.buildLocator ()
        .name ("Login box title")
        .web (By.cssSelector (".col-lg-6:nth-child(2) h2"))
        .build ();
    private final Locator loginBtn          = Locator.buildLocator ()
        .name ("Login button")
        .web (By.cssSelector ("input.btn"))
        .build ();
    private final Locator passwordField     = Locator.buildLocator ()
        .name ("Password field")
        .web (By.id ("input-password"))
        .build ();

    public LoginPage () {
    }

    public void checkLoginBoxTitle () {
        ElementActions.onElement (this.loginBoxTitle)
            .verifyText ()
            .isEqualTo ("Returning Customer");
    }

    public void checkWarningMessage () {
        ElementActions.onElement (this.alertMessage)
            .verifyText ()
            .isEqualTo ("Warning: No match for E-Mail Address and/or Password.");
    }

    public void performLogin (final String username, final String password) {
        TextBoxActions.onTextBox (this.emailAddressField)
            .clear ();
        TextBoxActions.onTextBox (this.emailAddressField)
            .enterText (username);
        TextBoxActions.onTextBox (this.passwordField)
            .clear ();
        TextBoxActions.onTextBox (this.passwordField)
            .enterText (password);
        ClickableActions.withMouse (this.loginBtn)
            .click ();
    }
}
