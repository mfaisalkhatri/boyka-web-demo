package io.github.mfaisalkhatri.web.actions;

import static io.github.mfaisalkhatri.web.pages.LoginPage.loginPage;
import static io.github.boykaframework.actions.elements.ClickableActions.withMouse;
import static io.github.boykaframework.actions.elements.ElementActions.onElement;
import static io.github.boykaframework.actions.elements.TextBoxActions.onTextBox;

import lombok.experimental.UtilityClass;

@UtilityClass
public class LoginActions {
    public static void verifyLogin () {
        onTextBox (loginPage ().getUserName ()).enterText ("tomsmith");
        onTextBox (loginPage ().getPassword ()).enterText ("SuperSecretPassword!");
        withMouse (loginPage ().getLogin ()).click ();
        onElement (loginPage ().getMessage ())
            .verifyText ()
            .contains ("You logged into a secure area!");
    }

    public static void verifyLogout () {
        withMouse (loginPage ().getLogout ()).click ();
        onElement (loginPage ().getMessage ())
            .verifyText ()
            .contains ("You logged out of the secure area!");
    }
}
