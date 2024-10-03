package io.github.mfaisalkhatri.web.pages;

import io.github.boykaframework.actions.elements.ClickableActions;
import io.github.boykaframework.actions.elements.ElementActions;
import io.github.boykaframework.actions.elements.TextBoxActions;
import io.github.boykaframework.builders.Locator;
import io.github.mfaisalkhatri.web.testdata.RegisterUser;

import org.openqa.selenium.By;


public class RegistrationPage extends BasePage {

    public RegistrationPage() {
    }

    private final Locator firstNameField = Locator.buildLocator()
            .name("First Name field")
            .web(By.id("input-firstname"))
            .build();

    private final Locator lastNameField = Locator.buildLocator()
            .name("Last Name field")
            .web(By.id("input-lastname"))
            .build();

    private final Locator emailField = Locator.buildLocator()
            .name("Email field")
            .web(By.id("input-email"))
            .build();

    private final Locator telephoneField = Locator.buildLocator()
            .name("Telephone field")
            .web(By.id("input-telephone"))
            .build();

    private final Locator passwordField = Locator.buildLocator()
            .name("Password field")
            .web(By.id("input-password"))
            .build();


    private final Locator confirmPasswordField = Locator.buildLocator()
            .name("Confirm Password field")
            .web(By.id("input-confirm"))
            .build();

    private final Locator agreePrivacyPolicy = Locator.buildLocator()
            .name("Agree to Privacy policy")
            .web(By.cssSelector(".float-right .custom-control"))
            .build();


    private final Locator continueBtn = Locator.buildLocator()
            .name("Continue Button")
            .web(By.cssSelector("input[type=submit]"))
            .build();


    public void checkPageHeader() {
        ElementActions.onElement(pageHeader).verifyText().isEqualTo("Register Account");
    }

    public RegistrationSuccessPage registerUser(RegisterUser registerUser) {
        TextBoxActions.onTextBox(firstNameField).clear();
        TextBoxActions.onTextBox(firstNameField).enterText(registerUser.getFirstName());
        TextBoxActions.onTextBox(lastNameField).clear();
        TextBoxActions.onTextBox(lastNameField).enterText(registerUser.getLastName());
        TextBoxActions.onTextBox(emailField).clear();
        TextBoxActions.onTextBox(emailField).enterText(registerUser.getEmail());
        TextBoxActions.onTextBox(telephoneField).clear();
        TextBoxActions.onTextBox(telephoneField).enterText(registerUser.getPhoneNumber());
        TextBoxActions.onTextBox(passwordField).clear();
        TextBoxActions.onTextBox(passwordField).enterText("Password@123");
        TextBoxActions.onTextBox(confirmPasswordField).clear();
        TextBoxActions.onTextBox(confirmPasswordField).enterText("Password@123");
        ClickableActions.withMouse(agreePrivacyPolicy).hover();
        ClickableActions.withMouse(agreePrivacyPolicy).click();

        ClickableActions.withMouse(continueBtn).click();
        return new RegistrationSuccessPage();
    }
}
