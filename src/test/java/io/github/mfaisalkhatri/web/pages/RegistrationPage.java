package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.actions.elements.TextBoxActions;
import io.github.boykaframework.builders.Locator;
import io.github.mfaisalkhatri.web.testdata.RegisterUser;
import org.openqa.selenium.By;

public class RegistrationPage extends BasePage {

    private final Locator agreePrivacyPolicy   = Locator.buildLocator ()
        .name ("Agree to Privacy policy")
        .web (By.cssSelector (".float-right .custom-control"))
        .build ();
    private final Locator confirmPasswordField = Locator.buildLocator ()
        .name ("Confirm Password field")
        .web (By.id ("input-confirm"))
        .build ();
    private final Locator continueBtn          = Locator.buildLocator ()
        .name ("Continue Button")
        .web (By.cssSelector ("input[type=submit]"))
        .build ();
    private final Locator emailField           = Locator.buildLocator ()
        .name ("Email field")
        .web (By.id ("input-email"))
        .build ();
    private final Locator firstNameField       = Locator.buildLocator ()
        .name ("First Name field")
        .web (By.id ("input-firstname"))
        .build ();
    private final Locator lastNameField        = Locator.buildLocator ()
        .name ("Last Name field")
        .web (By.id ("input-lastname"))
        .build ();
    private final Locator passwordField        = Locator.buildLocator ()
        .name ("Password field")
        .web (By.id ("input-password"))
        .build ();
    private final Locator telephoneField       = Locator.buildLocator ()
        .name ("Telephone field")
        .web (By.id ("input-telephone"))
        .build ();

    public RegistrationPage () {
    }

    public void checkPageHeader () {
        ElementActions.onElement (this.pageHeader)
            .verifyText ()
            .isEqualTo ("Register Account");
    }

    public RegistrationSuccessPage registerUser (final RegisterUser registerUser) {
        TextBoxActions.onTextBox (this.firstNameField)
            .clear ();
        TextBoxActions.onTextBox (this.firstNameField)
            .enterText (registerUser.getFirstName ());
        TextBoxActions.onTextBox (this.lastNameField)
            .clear ();
        TextBoxActions.onTextBox (this.lastNameField)
            .enterText (registerUser.getLastName ());
        TextBoxActions.onTextBox (this.emailField)
            .clear ();
        TextBoxActions.onTextBox (this.emailField)
            .enterText (registerUser.getEmail ());
        TextBoxActions.onTextBox (this.telephoneField)
            .clear ();
        TextBoxActions.onTextBox (this.telephoneField)
            .enterText (registerUser.getPhoneNumber ());
        TextBoxActions.onTextBox (this.passwordField)
            .clear ();
        TextBoxActions.onTextBox (this.passwordField)
            .enterText ("Password@123");
        TextBoxActions.onTextBox (this.confirmPasswordField)
            .clear ();
        TextBoxActions.onTextBox (this.confirmPasswordField)
            .enterText ("Password@123");
        ClickableActions.withMouse (this.agreePrivacyPolicy)
            .hover ();
        ClickableActions.withMouse (this.agreePrivacyPolicy)
            .click ();

        ClickableActions.withMouse (this.continueBtn)
            .click ();
        return new RegistrationSuccessPage ();
    }
}
